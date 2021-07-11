package IHM;

import javax.swing.*;
import java.awt.*;

public class IHM_CLI {

    public IHM_CLI() {

        //window initialisation
        JFrame window = new JFrame("IHM pour CLI");
        window.setLayout(new BorderLayout());

        //Boutons premiere ligne
        JButton ButtonCreuse = new JButton("Creuse (C)");
        JButton ButtonPleine = new JButton("Pleine (P)");
        JPanel buttons = new JPanel();
        window.add(buttons, BorderLayout.NORTH);
        buttons.add(ButtonCreuse);
        buttons.add(ButtonPleine);

        //Initialisation de la Grid des Lignes
        JPanel options = new JPanel();
        options.setLayout(new GridLayout(3,3));

        // Ligne Indice (K)
        JLabel LabelIndice = new JLabel("Valeur de l'indice (K)");
        JTextField TextFieldIndice = new JTextField();
        JButton ButtonIndice = new JButton("+");
        options.add(LabelIndice);
        options.add(TextFieldIndice);
        options.add(ButtonIndice);

        // Ligne Alpha (A)
        JLabel LabelAlpha = new JLabel("Valeur de alpha (A)");
        JTextField TextFieldAlpha = new JTextField();
        JButton ButtonAlpha = new JButton("+");
        options.add(LabelAlpha);
        options.add(TextFieldAlpha);
        options.add(ButtonAlpha);

        // Ligne Epsilon (E)
        JLabel LabelEpsilon = new JLabel("Valeur de epsilon (E)");
        JTextField TextFieldEpsilon = new JTextField();
        JButton ButtonEpsilon = new JButton("+");
        options.add(LabelEpsilon);
        options.add(TextFieldEpsilon);
        options.add(ButtonEpsilon);

        window.add(options, BorderLayout.CENTER);

        //Ligne cumulative
        JTextArea arguments = new JTextArea();
        arguments.setEditable(false);
        window.add(arguments, BorderLayout.SOUTH);

        // Action Listeners
        ButtonCreuse.addActionListener(e -> arguments.append("-C "));

        ButtonPleine.addActionListener(e -> arguments.append("-P "));

        ButtonIndice.addActionListener(e -> arguments.append("-K " + TextFieldIndice.getText() + " "));

        ButtonAlpha.addActionListener(e -> arguments.append("-A " + TextFieldAlpha.getText() + " "));

        ButtonEpsilon.addActionListener(e -> arguments.append("-E " + TextFieldEpsilon.getText() + " "));

        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        IHM_CLI ihm_cli = new IHM_CLI();
    }
}
