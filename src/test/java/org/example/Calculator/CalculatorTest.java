package org.example.Calculator;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jiucheng
 */
public class CalculatorTest {

    @Test
    void CalculatorTest1() {
        Formula formula = new Formula("1+1");
        double actual = formula.process();
        double expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void CalculatorTest2() {
        Formula formula = new Formula("1+5*2-6/2");
        double actual = formula.process();
        double expected = 8;
        assertEquals(expected, actual);
    }

     @Test
    void CalculatorTest3() {
        Formula formula = new Formula("1+5*(2-6)/2");
        double actual = formula.process();
        double expected = -9;
        assertEquals(expected, actual);
    }

}
