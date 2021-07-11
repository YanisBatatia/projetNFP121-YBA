package Framework;

import java.util.HashMap;

public class Application {
    private HashMap<Option, Action> configuration = new HashMap<Option, Action>();

    public Application(HashMap<Option, Action> configuration) {
        this.configuration = configuration;
    }
    public Application() {
    }

    public HashMap<Option, Action> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(HashMap<Option, Action> configuration) {
        this.configuration = configuration;
    }

    public void addConfigurationEntry(Option option,Action action){
        if(this.getConfiguration().containsKey(option)){
            System.out.println("Key : " + option.getAccess() + " already existed so it was replaced");
            this.changeConfigurationOptionAction(option, action);
        }
        this.getConfiguration().put(option, action);
    }

    public void changeConfigurationOptionAction(Option option, Action action){
        if(this.getConfiguration().containsKey(option)){
            this.getConfiguration().replace(option, action);
        }
        else {
            System.out.println("Key : " + option.getAccess() + " Didn't exist so it was just added");
            this.addConfigurationEntry(option,action);
        }
    }

}
