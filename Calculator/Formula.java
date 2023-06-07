package Calculator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class create a formula object with function process the formula.
 * 
 * @auther Jiucheng Zang
 * @version 1.1
 * @since 2022-12-20
 */

public class Formula {
    private String formula;

    public Formula() {
        formula = "";
    }

    public Formula(String formula) {
        this.formula = formula;
    }

    /**
     * @return ArrayList<String>
     */
    private ArrayList<String> formula_pop() {
        ArrayList<String> popformula = new ArrayList<String>();
        String[] formula_space = this.formula.split(" ");
        String new_String = "";
        for (String x : formula_space) {
            new_String += x;
        }
        String[] temp_formula = new_String.split("");
        popformula.addAll(Arrays.asList(temp_formula));
        return popformula;
    }

    /**
     * @return ArrayList<String>
     */
    public ArrayList<String> formula_format() {
        ArrayList<String> input_formula = formula_pop();
        ArrayList<String> formula_format = new ArrayList<String>();
        String temp_number = "";
        boolean symbol_status = false;
        int temp_number_chr = -1;
        for (String x : input_formula) {
            char chr = x.charAt(0);
            int number_chr = (int) chr;
            if (((number_chr >= 48) && (number_chr <= 57)) || (number_chr == 46)) {
                symbol_status = false;
                temp_number += (char) number_chr;
            } else {
                if ((symbol_status) && (number_chr != 40) && (number_chr != 41) && (temp_number_chr != 40)
                        && (temp_number_chr != 41)) {
                    throw new IllegalArgumentException("Can't be two symbol together");
                }
                temp_number_chr = number_chr;
                symbol_status = true;
                if (temp_number.length() != 0) {
                    formula_format.add(temp_number);
                }
                temp_number = "";
                formula_format.add(x);
            }
        }
        if (!temp_number.equals("")) {
            formula_format.add(temp_number);
        }
        return formula_format;
    }

    /**
     * @return double
     */
    public double process() {
        ArrayList<String> format = formula_format();
        Operator ff1 = new Operator(format);
        return ff1.process();
    }

    /**
     * @return String
     */
    public String toString() {
        return String.format("%s", formula_format());
    }

    /**
     * @return String
     */
    public String getFormula() {
        return this.formula;
    }

    /**
     * @param formula
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * @param formula
     * @return Formula
     */
    public Formula formula(String formula) {
        setFormula(formula);
        return this;
    }

}
