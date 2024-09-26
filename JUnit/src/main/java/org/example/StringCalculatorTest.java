package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void testAddEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testAddSingleNumber() {
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void testAddTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
        assertEquals(10, calculator.add("4,6"));
    }

    @Test
    public void testAddWithNewlines() {
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(10, calculator.add("5\n2,3"));
    }

    @Test
    public void testAddNumbersGreaterThanThousand() {
        assertEquals(2, calculator.add("1001,2"));
        assertEquals(1000, calculator.add("1000,1001"));
    }

    @Test
    public void testAddMultipleNumbers() {
        assertEquals(15, calculator.add("1,2,3,4,5"));
        assertEquals(10, calculator.add("2\n3,5"));
    }

    @Test
    public void testAddNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3");
        });
        assertEquals("Negatives not allowed: -2", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,-3");
        });
        assertEquals("Negatives not allowed: -2, -3", exception.getMessage());
    }
}
