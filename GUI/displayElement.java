package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class displayElement {
    public static void displayElementEdit(JPanel panel) {
        panel.setLayout(new GridLayout(0, 1));
        // Utiles.transparentPanel(panel);
        panel.setBackground(Color.white);

        numberLabel = new JLabel();
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 45));
        // numberLabel.
        // numberLabel.setText("12345");
        panel.add(numberLabel);
        // refreshData(0);
    }

    public static void refreshData(String value) {
        if (value.length() > 32)
            numberLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        else if (value.length() > 18)
            numberLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        else if (value.length() > 10)
            numberLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        numberLabel.setText(value);
    }

    protected static JLabel numberLabel;
}
