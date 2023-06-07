package org.example.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * This class show the mainGUI of the calculator.
 *
 * @author Jiucheng Zang
 * @version 1.1
 * @since 2023-06-07
 */

public class mainGUI {

    public static void setAbsPATH() {
        File directory = new File("");// Set current folder
        try { // Reference: https://developer.aliyun.com/article/623772
            absPATH = directory.getAbsolutePath().concat("/src/main/java/org/example");// getAbsPATH
            System.out.println(absPATH);
        } catch (Exception e) {
        }
    }

    public static void GUI() {
        /**
         * Creating instance of JFrame
         */
        mainFrame = new JFrame("Calculator");
        mainFrame.setLayout(null);
        mainFrame.setSize(widthFrameX + LeftFrameX * 2, mainFrameY);
        mainFrame.setResizable(false);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",
                        "Exit Program Message Box", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        mainFrame.setContentPane(new JLabel(
                Utiles.readImage(absPATH.concat("/GUI/Pics/matrix-high.jpg"), 300,
                        400, 150)));

        displayPanel = new JPanel(null);
        displayPanel.setBounds(LeftFrameX, topFrameY, widthFrameX, 80);
        displayElement.displayElementEdit(displayPanel);
        mainFrame.add(displayPanel);

        operationPanel = new JPanel(null);
        int operationPanelstartY = (displayPanel.getHeight() + topFrameY + 10);
        operationPanel.setBounds(LeftFrameX, operationPanelstartY,
                widthFrameX,
                endFrameY - (operationPanelstartY + 10));
        Utiles.transparentPanel(operationPanel);
        operationElement.operationElementEdit(operationPanel);
        mainFrame.add(operationPanel);
        mainFrame.setVisible(true);
    }

    private static JFrame mainFrame;
    private static JPanel displayPanel;
    private static JPanel operationPanel;

    private static int LeftFrameX = 15; // For side
    private static int widthFrameX = 300 - LeftFrameX * 2;
    private static int topFrameY = 10;
    private static int mainFrameY = 400;
    private static int endFrameY = mainFrameY - 30;

    protected static String absPATH;

}