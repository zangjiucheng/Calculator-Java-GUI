package GUI;

import javax.swing.JOptionPane;

import Calculator.Formula;

/**
 * This interface define the function of the button.
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-06-08
 */

public abstract interface Function {
    public void run();
}

class Clear implements Function {
    public void run() {
        operationElement.inputString = "";
        displayElement.refreshData(operationElement.inputString);
    }
}

class Backspace implements Function {
    public void run() {
        if (operationElement.inputString.length() > 0) {
            operationElement.inputString = operationElement.inputString.substring(0,
                    operationElement.inputString.length() - 1);
            displayElement.refreshData(operationElement.inputString);
        }
    }
}

class Divide implements Function {
    public void run() {
        if (operationElement.inputString.length() > 0) {
            operationElement.inputString += "/";
            displayElement.refreshData(operationElement.inputString);
        }
    }
}

class Mutiple implements Function {
    public void run() {
        if (operationElement.inputString.length() > 0) {
            operationElement.inputString += "*";
            displayElement.refreshData(operationElement.inputString);
        }
    }
}

class Minus implements Function {
    public void run() {
        if (operationElement.inputString.length() > 0) {
            operationElement.inputString += "-";
            displayElement.refreshData(operationElement.inputString);
        }
    }
}

class Plus implements Function {
    public void run() {
        if (operationElement.inputString.length() > 0) {
            operationElement.inputString += "+";
            displayElement.refreshData(operationElement.inputString);
        }
    }
}

class Zero implements Function {
    public void run() {
        operationElement.inputString += "0";
        displayElement.refreshData(operationElement.inputString);
    }
}

class Multiplier implements Function {
    public void run() {
        operationElement.inputString += "*10^";
        displayElement.refreshData(operationElement.inputString);
    }
}

class Point implements Function {
    public void run() {
        operationElement.inputString += ".";
        displayElement.refreshData(operationElement.inputString);
    }
}

class Equal implements Function {
    public void run() {
        Formula f1 = new Formula(operationElement.inputString);
        try {
            operationElement.inputString = String.valueOf(f1.process());
            displayElement.refreshData(operationElement.inputString);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }
}