package com.vev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTests {
    private static Calculator calculator = null;

    private String buildAssertString(Object value, Object expected) {
        return value + " should equal " + expected;
    }

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
        "54 + 22 + 32 + 4 + 105 + 2, 219",
        "1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10, 55",
    })
    void addsRandomNumbers(String sumExpression, int expectedResult) {
        assertEquals(expectedResult, calculator.evaluate(sumExpression), buildAssertString(sumExpression, expectedResult));
    }

    @Test
    void addsSingleNumber() {
        final String sumExpression = "1";
        final int EXPECTED_RESULT = 1;
        assertEquals(EXPECTED_RESULT, calculator.evaluate(sumExpression), buildAssertString(sumExpression, EXPECTED_RESULT));
    }

    @Test
    void addsMaxInteger() {
        final String MAX_INTEGER = Integer.toString(Integer.MAX_VALUE);
        final String sumExpression = MAX_INTEGER + " + 1";
        // Must be a string because the result is bigger than the max integer value
        final String EXPECTED_RESULT = "2147483648";
        assertEquals(EXPECTED_RESULT, calculator.evaluate(sumExpression), buildAssertString(sumExpression, EXPECTED_RESULT));
    }

    @Test
    void addsNoSpaces() {
        final String sumExpression = "1+23+345";
        final int EXPECTED_RESULT = 369;
        assertEquals(EXPECTED_RESULT, calculator.evaluate(sumExpression), buildAssertString(sumExpression, EXPECTED_RESULT));
    }
}
