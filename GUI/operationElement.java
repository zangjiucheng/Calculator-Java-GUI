package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;

import javax.management.Query;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Calculator.Formula;

public class operationElement {
    public static void operationElementEdit(JPanel panel) {
        panel.setLayout(new GridLayout(5, 4));
        // panel.setBackground(Color.lightGray);
        int numberIndex = 1;
        for (int numebrOfGrid = 0; numebrOfGrid < 20; numebrOfGrid++) {
            if ((numebrOfGrid % 4 != 3) && (numebrOfGrid > 3) && (numebrOfGrid < 16)) {
                JPanel tempPanel = basicElementEdit();
                JButton numberIndexGrid = new JButton(String.valueOf(numberIndex));
                final int numberCount = numberIndex;
                numberIndexGrid.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // System.out.println(numberCount);
                        inputString = inputString += String.valueOf(numberCount);
                        displayElement.refreshData(inputString);
                    }
                });
                numberIndexGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                tempPanel.add(numberIndexGrid);
                tempPanel.setBackground(Color.green);
                panel.add(tempPanel);
                numberIndex++;
            } else {
                JPanel tempPanel = basicElementEdit();
                JButton functionGrid;
                switch (numebrOfGrid) {
                    case 0: // Clear
                        functionGrid = new JButton("AC");
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputString = "";
                                displayElement.refreshData(inputString);
                            }
                        });
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        tempPanel.add(functionGrid);
                        tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;
                    case 1:
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
                    case 2:
                        functionGrid = new JButton("⬅");
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (inputString.length() != 0)
                                    inputString = inputString.substring(0, inputString.length() - 1);
                                displayElement.refreshData(inputString);
                            }
                        });
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        tempPanel.add(functionGrid);
                        tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;

                    case 3: // / sign
                        functionGrid = new JButton("➗");
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputString = inputString += "/";
                                displayElement.refreshData(inputString);
                            }
                        });
                        tempPanel.add(functionGrid);
                        tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;
                    case 7: // x sign
                        functionGrid = new JButton("x");
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputString = inputString += "*";
                                displayElement.refreshData(inputString);
                            }
                        });
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        tempPanel.add(functionGrid);
                        tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;
                    case 11: // - sign
                        functionGrid = new JButton("-");
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputString = inputString += "-";
                                displayElement.refreshData(inputString);
                            }
                        });
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        tempPanel.add(functionGrid);
                        tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;
                    case 15: // + sign
                        functionGrid = new JButton("+");
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputString = inputString += "+";
                                displayElement.refreshData(inputString);
                            }
                        });
                        tempPanel.add(functionGrid);
                        tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;
                    case 16: // number 0
                        functionGrid = new JButton("0");
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputString = inputString += "0";
                                displayElement.refreshData(inputString);
                            }
                        });
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        tempPanel.add(functionGrid);
                        tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;
                    case 17:
                        functionGrid = new JButton("10^n");
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        tempPanel.add(functionGrid);
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputString = inputString += "*10^";
                                displayElement.refreshData(inputString);
                            }
                        });
                        tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;

                    case 18: // point
                        functionGrid = new JButton(".");
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        tempPanel.add(functionGrid);
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputString = inputString += ".";
                                displayElement.refreshData(inputString);
                            }
                        });
                        tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;
                    case 19: // equal
                        functionGrid = new JButton("=");
                        functionGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Formula f1 = new Formula(inputString);
                                try {
                                    inputString = String.valueOf(f1.process());
                                    displayElement.refreshData(inputString);
                                    // System.out.println(f1.process());
                                } catch (IllegalArgumentException ex) {
                                    System.out.println(ex);
                                }
                            }
                        });
                        functionGrid.setFont(new Font("Arial", Font.PLAIN, 25));
                        tempPanel.add(functionGrid);
                        // tempPanel.setBackground(Color.green);
                        panel.add(tempPanel);
                        break;
                    default:
                        tempPanel.setBackground(Color.blue);
                        panel.add(tempPanel);
                        break;
                }

            }
        }
        // ArrayList<Color> colorList = new ArrayList() { new Color.blue
        // };
    }

    protected static String inputString = "";

    private static JPanel basicElementEdit() {

        JPanel panel = new JPanel();
        Utiles.transparentPanel(panel);
        panel.setLayout(new GridLayout(0, 1));
        return panel;

    }
}
