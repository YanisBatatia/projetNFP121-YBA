package XML;
import Framework.CLI;
import Framework.*;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;

public class SerialiseurXML {

    public static void main(String[] args) throws java.io.IOException {
        CLI cli = new CLI();
        cli.addOption(new Option('A', "Valeur de alpha", true));
        cli.addOption(new Option('K', "Valeur de indice", true));
        cli.addOption(new Option('E', "Valeur de la précision à atteindre", true));
        cli.addOption(new Option('P', "Mode matrice pleine", false));
        cli.addOption(new Option('C', "Mode matrice creuse", false));

        Element racine = new Element("cli");

        for (Option option : cli.getOptions()) {
            Element argument = new Element("argument").setAttribute("acces", String.valueOf(option.getAccess()));
            if (option.isNeedValue()) argument.setAttribute("param", "1");
            argument.setText(option.getDescription());
            racine.addContent(argument);
        }

        Document document = new Document(racine, new DocType("cli", "cli.dtd"));

        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream("cli.xml"));
    }

}
