package GUI;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import GUI.Utiles;

public class mainGUI {

    public static void setAbsPATH() {
        File directory = new File("");// Set current folder\
        try { // Reference: https://developer.aliyun.com/article/623772
            absPATH = directory.getAbsolutePath();// getAbsPATH
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

    // Color:

}