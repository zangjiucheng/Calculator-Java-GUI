package Calculator;

import java.util.ArrayList;

/**
 * This class operator the formula.
 * 
 * @auther Jiucheng Zang
 * @version 1.1
 * @since 2022-12-20
 */

public class Operator {
    private ArrayList<String> formula_format;

    public Operator() {
        this.formula_format = new ArrayList<String>();
    }

    public Operator(ArrayList<String> formula_format) {
        this.formula_format = formula_format;
    }

    public double process() {
        double temp_result, result = 0;
        int length, start_position;
        ArrayList<String> temp_formula;
        while (formula_format.size() != 1) {
            temp_formula = split_block();
            start_position = Integer.parseInt(temp_formula.get(0));
            temp_formula.remove(0);
            length = temp_formula.size();
            // System.out.println(formula_format);
            temp_result = main_operator(temp_formula);
            try {
                for (int i = 0; i < length + 2; i++) {
                    formula_format.remove(start_position);
                }
            } catch (Exception ex) {
            }
            formula_format.add(start_position, String.format("%s", temp_result));
        }
        result = Double.parseDouble(formula_format.get(0));
        return result;
    }

    private ArrayList<String> split_block() {
        char temp;
        int start_position = 0, temp_app = 0, max_temp = 0, temp_start = 0;
        int end_position = formula_format.size();
        boolean status = false;
        ArrayList<String> piece_formula = new ArrayList<String>();
        for (int i = 0; i < formula_format.size(); i++) {
            try {
                temp = formula_format.get(i).charAt(0);
            } catch (Exception ex) {
                temp = ' ';
            }
            if (temp == ')') {
                if (temp_app > max_temp) {
                    max_temp = temp_app;
                    end_position = i;
                    start_position = temp_start;
                }
                temp_app = 0;
            }
            if (temp == '(') {
                status = true;
                temp_start = i;
                temp_app++;
            }
        }
        if (status) {
            piece_formula.addAll(formula_format.subList(start_position + 1, end_position));
        } else {
            piece_formula.addAll(formula_format.subList(start_position, end_position));
        }
        piece_formula.add(0, String.format("%s", start_position));
        return piece_formula;
    }

    private double main_operator(ArrayList<String> temp_formula) {
        double final_result;
        temp_formula = power(temp_formula);
        temp_formula = multi_divi(temp_formula);
        temp_formula = add_minu(temp_formula);
        final_result = Double.parseDouble(temp_formula.get(0));
        return final_result;
    }

    private ArrayList<String> power(ArrayList<String> temp_formula) {
        double temp_result = 0;
        int temp_size;
        while (true) {
            temp_size = temp_formula.size();
            for (int x = 0; x < temp_formula.size(); x++) {
                String temp = temp_formula.get(x);
                try {
                    Double.parseDouble(temp);
                } catch (Exception e) {
                    switch (temp) {
                        case "^":
                            temp_result = Math.pow(Double.parseDouble(temp_formula.get(x - 1)),
                                    Double.parseDouble(temp_formula.get(x + 1)));
                            temp_formula = single_operator(x, String.format("%.4f", temp_result), temp_formula);
                            break;
                        case "*":
                            break;
                        case "/":
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                        default:
                            throw new IllegalArgumentException(String.format("Symbol '%s' not reconize!", temp));
                    }
                }
            }
            if (temp_size == temp_formula.size()) {
                break;
            }
        }
        return temp_formula;
    }

    private ArrayList<String> multi_divi(ArrayList<String> temp_formula) {
        double temp_result = 0;
        int temp_size;
        while (true) {
            temp_size = temp_formula.size();
            for (int x = 0; x < temp_formula.size(); x++) {
                String temp = temp_formula.get(x);
                try {
                    Double.parseDouble(temp);
                } catch (Exception e) {
                    switch (temp) {
                        case "*":
                            temp_result = Double.parseDouble(temp_formula.get(x - 1))
                                    * Double.parseDouble(temp_formula.get(x + 1));
                            temp_formula = single_operator(x, String.format("%.4f", temp_result), temp_formula);
                            break;
                        case "/":
                            temp_result = Double.parseDouble(temp_formula.get(x - 1))
                                    / Double.parseDouble(temp_formula.get(x + 1));
                            temp_formula = single_operator(x, String.format("%.4f", temp_result), temp_formula);
                            break;
                        case "+":
                            break;
                        case "-":
                            break;
                        default:
                            throw new IllegalArgumentException(String.format("Symbol '%s' not reconize!", temp));
                    }
                }
            }
            if (temp_size == temp_formula.size()) {
                break;
            }
        }
        return temp_formula;
    }

    private ArrayList<String> add_minu(ArrayList<String> temp_formula) {
        double temp_result = 0;
        int temp_size;
        while (true) {
            temp_size = temp_formula.size();
            for (int x = 0; x < temp_formula.size(); x++) {
                String temp = temp_formula.get(x);
                try {
                    Double.parseDouble(temp);
                } catch (Exception e) {
                    switch (temp) {
                        case "+":
                            temp_result = Double.parseDouble(temp_formula.get(x - 1))
                                    + Double.parseDouble(temp_formula.get(x + 1));
                            temp_formula = single_operator(x, String.format("%.4f", temp_result), temp_formula);
                            break;
                        case "-":
                            temp_result = Double.parseDouble(temp_formula.get(x - 1))
                                    - Double.parseDouble(temp_formula.get(x + 1));
                            temp_formula = single_operator(x, String.format("%.4f", temp_result), temp_formula);
                            break;
                        default:
                            throw new IllegalArgumentException(String.format("Symbol '%s' not reconize!", temp));
                    }
                }
            }
            if (temp_size == temp_formula.size()) {
                break;
            }
        }
        return temp_formula;
    }

    private ArrayList<String> single_operator(int x, String temp, ArrayList<String> formula) {
        for (int a = 0; a < 3; a++) {
            formula.remove(x - 1);
        }
        formula.add(x - 1, temp);
        return formula;
    }

    public String toString() {
        return String.format("%s", formula_format);
    }

    public ArrayList<String> getFormula_format() {
        return this.formula_format;
    }

    public void setFormula_format(ArrayList<String> formula_format) {
        this.formula_format = formula_format;
    }

}
