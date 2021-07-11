package Framework;

import java.lang.reflect.Field;

public class CLIOutils {

    static public CLI fromClass(String classname) throws ClassNotFoundException {
        CLI cli = new CLI();
        Class<?> myClass = Class.forName(classname);

        for (Field field : myClass.getDeclaredFields()) {
            if (field.getType().equals(Boolean.TYPE)) {
                Option optionTrue = new Option(field.getName().charAt(0), "Positionner " + field.getName() + " à vrai", false);
                cli.addOption(optionTrue);
                Option optionFalse = new Option(Character.toUpperCase(field.getName().charAt(0)), "Positionner " + field.getName() + " à faux", false);
                cli.addOption(optionFalse);
            } else {
                Option option = new Option(Character.toUpperCase(field.getName().charAt(0)),"Valeur de " + field.getName(), !field.getType().isEnum());
                cli.addOption(option);
            }
        }
        return cli;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        CLIOutils.fromClass("Configuration");
    }
}
