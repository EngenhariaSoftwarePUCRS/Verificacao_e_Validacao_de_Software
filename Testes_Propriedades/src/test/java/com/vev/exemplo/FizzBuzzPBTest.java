package com.vev.exemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

public class FizzBuzzPBTest {
    @Provide
    Arbitrary<Integer> divisibleByThreeAndFive() {
        return Arbitraries
            .integers()
            .between(Integer.MIN_VALUE, Integer.MAX_VALUE)
            .filter(number -> number % 3 == 0 && number % 5 == 0);
    }

    @Property
    void fizzBuzzShouldReturnFizzBuzzForMultiplesOfThreeAndFive(
        @ForAll("divisibleByThreeAndFive") int number
    ) {
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals("FizzBuzz", result);
    }

    @Provide
    Arbitrary<Integer> divisibleByThreeAndNotFive() {
        return Arbitraries
            .integers()
            .between(Integer.MIN_VALUE, Integer.MAX_VALUE)
            .filter(number -> number % 3 == 0 && number % 5 != 0);
    }

    @Property
    void fizzBuzzShouldReturnFizzForMultiplesOfThreeAndNotFive(
        @ForAll("divisibleByThreeAndNotFive") int number
    ) {
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals("Fizz", result);
    }

    @Provide
    Arbitrary<Integer> divisibleByFiveAndNotThree() {
        return Arbitraries
            .integers()
            .between(Integer.MIN_VALUE, Integer.MAX_VALUE)
            .filter(number -> number % 3 != 0 && number % 5 == 0);
    }

    @Property
    void fizzBuzzShouldReturnBuzzForMultiplesOfFiveAndNotThree(
        @ForAll("divisibleByFiveAndNotThree") int number
    ) {
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals("Buzz", result);
    }

    @Provide
    Arbitrary<Integer> notDivisibleByThreeOrFive() {
        return Arbitraries
            .integers()
            .between(Integer.MIN_VALUE, Integer.MAX_VALUE)
            .filter(number -> number % 3 != 0 && number % 5 != 0);
    }

    @Property
    void fizzBuzzShouldReturnNumberForNumbersNotDivisibleByThreeOrFive(
        @ForAll("notDivisibleByThreeOrFive") int number
    ) {
        String result = FizzBuzz.fizzBuzz(number);
        String expected = String.valueOf(number) + "!";
        assertEquals(expected, result);
    }
}
