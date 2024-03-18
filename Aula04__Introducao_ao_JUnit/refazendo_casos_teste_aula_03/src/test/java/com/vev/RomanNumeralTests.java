package com.vev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanNumeralTests {
    private static RomanNumeral romanNumeral = null;

    private String buildAssertString(Object value, Object expected) {
        return value + " should equal " + expected;
    }

    @BeforeAll
    static void setUp() {
        romanNumeral = new RomanNumeral();
    }

    @ParameterizedTest
    @CsvSource({
        "I, 1",
        "V, 5",
    })
    void convertsSingleCharacter(String romanCharacter, int numericExpectedResult) {
        assertEquals(numericExpectedResult, romanNumeral.convert(romanCharacter), buildAssertString(romanCharacter, numericExpectedResult));
    }

    @Test
    void convertsPairedCharacters() {
        assertEquals(4, romanNumeral.convert("IV"), buildAssertString("IV", 4));
    }

    @Test
    void doesNotConvertQuadrupleCharacters() {
        final String invalidRomanNumeral = "IIII";
        assertThrows(IllegalArgumentException.class, () -> romanNumeral.convert(invalidRomanNumeral), invalidRomanNumeral + " is not a valid Roman Numeral");
    }

    @Test
    void doesNotConvertMultipleCharacters() {
        final String invalidRomanNumeral = "IVVI";
        assertThrows(IllegalArgumentException.class, () -> romanNumeral.convert(invalidRomanNumeral), invalidRomanNumeral + " is not a valid Roman Numeral");
    }
}
