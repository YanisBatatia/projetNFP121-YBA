package Framework;

import base.Configuration;
import base.Mode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CLI {

    Set<Option> options = new HashSet<>();

    public static void execute(Application appli, String... args){
        boolean finOptions = false;
        int i = 0;
        boolean continueFlag = false;
        while (i < args.length && ! finOptions) {
            String arg = args[i];
            for (Map.Entry<Option, Action> set : appli.getConfiguration().entrySet()) {
                if (arg.equals("-" + set.getKey().getAccess())) {
                    if (set.getKey().isNeedValue()) {
                        set.getValue().faire(args[++i]);
                    } else set.getValue().faire();
                    continueFlag = true;
                    break;
                }
            }
            i++;
            if (continueFlag)  continue;
            finOptions = arg.length() == 0 || arg.charAt(0) != '-';
            if (!finOptions) {
                System.out.println("Option inconnue : " + arg);
            }
        }
    }

    public static Configuration configuration(String... args) {
        Configuration config = new Configuration();
        Application appli = new Application();

        Option optionK = new Option('K', "Valeur de l'indice à calculer", true);
        Option optionP = new Option('P', "Mode matrice pleine", false);

        Action ActionK = new ActionWithValue() {
            @Override
            public void faire(String value) {config.indice = Integer.parseInt(value);}};
        Action ActionP = new ActionWithoutValue() {
            @Override
            public void faire() {config.mode = Mode.PLEINE;}
        };

        HashMap<Option, Action> appliConfig = new HashMap<Option, Action>();

        appliConfig.put(optionK,ActionK);
        appliConfig.put(optionP,ActionP);

        appli.setConfiguration(appliConfig);

        execute(appli, args);

        return config;
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public static void main(String[] args) {
        System.out.println(configuration(args));
    }
}
