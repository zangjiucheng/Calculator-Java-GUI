package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class include numberLabel and displayElementEdit.
 * 
 * @author Jiucheng Zang
 * @version 1.1
 * @since 2023-06-07
 */

public class displayElement {

    /**
     * @param panel
     */
    public static void displayElementEdit(JPanel panel) {
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(Color.white);
        numberLabel = new JLabel();
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 45));
        panel.add(numberLabel);
    }

    /**
     * @param value
     */
    public static void refreshData(String value) {
        if (value.length() > 42) {
            JOptionPane.showMessageDialog(null, "Warning: Too Long For Display!");
            value = value.substring(0, 42);
        } else if (value.length() > 32)
            numberLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        else if (value.length() > 18)
            numberLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        else if (value.length() > 10)
            numberLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        numberLabel.setText(value);
    }

    protected static JLabel numberLabel;
}
