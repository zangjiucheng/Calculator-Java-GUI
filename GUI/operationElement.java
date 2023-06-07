package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class include operationElementEdit.
 * 
 * @author Jiucheng Zang
 * @version 1.2
 * @since 2023-06-07
 * @see Calculator.Formula
 */

public class operationElement {
    public static void operationElementEdit(JPanel panel) {
        panel.setLayout(new GridLayout(5, 4));
        int numberIndex = 1;
        for (int numebrOfGrid = 0; numebrOfGrid < 20; numebrOfGrid++) {
            if ((numebrOfGrid % 4 != 3) && (numebrOfGrid > 3) && (numebrOfGrid < 16)) {
                JPanel tempPanel = basicElementEdit();
                JButton numberIndexGrid = new JButton(String.valueOf(numberIndex));
                final int numberCount = numberIndex;
                numberIndexGrid.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        inputString += String.valueOf(numberCount);
                        displayElement.refreshData(inputString);
                    }
                });
                numberIndexGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                tempPanel.add(numberIndexGrid);
                tempPanel.setBackground(Color.green);
                panel.add(tempPanel);
                numberIndex++;
            } else {

                switch (numebrOfGrid) {
                    case 0: // Clear
                        panel.add(functionElementEdit("AC", new Clear()));
                        break;

                    case 1: // ( )
                        JPanel tempPanel = basicElementEdit();
                        JButton functionGrid;
                        tempPanel.setLayout(new GridLayout(0, 2));
                        functionGrid = new JButton("(");
                        JButton functionGrid2 = new JButton(")");
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputString += "(";
                                displayElement.refreshData(inputString);
                            }
                        });
                        functionGrid2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputString += ")";
                                displayElement.refreshData(inputString);
                            }
                        });
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        functionGrid2.setFont(new Font("Arial", Font.PLAIN, 25));
                        tempPanel.add(functionGrid);
                        tempPanel.add(functionGrid2);
                        tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;

                    case 2: // Backspace
                        panel.add(functionElementEdit("⬅", new Backspace()));
                        break;

                    case 3: // divide
                        panel.add(functionElementEdit("➗", new Divide()));
                        break;

                    case 7: // multiply
                        panel.add(functionElementEdit("x", new Mutiple()));
                        break;

                    case 11: // minus
                        panel.add(functionElementEdit("-", new Minus()));
                        break;

                    case 15: // plus
                        panel.add(functionElementEdit("+", new Plus()));
                        break;

                    case 16: // number 0
                        panel.add(functionElementEdit("0", new Zero()));
                        break;

                    case 17: // 10^n
                        panel.add(functionElementEdit("10^n", new Multiplier()));
                        break;

                    case 18: // point
                        panel.add(functionElementEdit(".", new Point()));
                        break;

                    case 19: // equal
                        panel.add(functionElementEdit("=", new Equal()));
                        break;

                    default:
                        JPanel BlackPanel = basicElementEdit();
                        panel.add(BlackPanel);
                        break;
                }

            }
        }
    }

    private static JPanel basicElementEdit() {
        JPanel panel = new JPanel();
        Utiles.transparentPanel(panel);
        panel.setLayout(new GridLayout(0, 1));
        return panel;

    }

    private static JPanel functionElementEdit(String functionName, Function function) {
        JPanel tempPanel = basicElementEdit();
        JButton functionGrid;
        functionGrid = new JButton(functionName);
        functionGrid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                function.run();
            }
        });
        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
        tempPanel.add(functionGrid);
        return tempPanel;
    }

    protected static String inputString = "";

}
