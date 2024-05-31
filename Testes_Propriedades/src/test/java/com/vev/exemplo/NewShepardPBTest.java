package com.vev.exemplo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

public class NewShepardPBTest {
    @Provide
    public Arbitrary<Float> validWeight() {
        return Arbitraries
            .floats()
            .between(NewShepard.MIN_WEIGHT, NewShepard.MAX_WEIGHT);
    }

    @Provide
    public Arbitrary<Float> invalidWeight() {
        return Arbitraries
            .floats()
            .between(Float.MIN_VALUE, Float.MAX_VALUE)
            .filter(weight -> weight < NewShepard.MIN_WEIGHT || weight > NewShepard.MAX_WEIGHT);
    }

    @Provide
    public Arbitrary<Float> validHeight() {
        return Arbitraries
            .floats()
            .between(NewShepard.MIN_HEIGHT, NewShepard.MAX_HEIGHT);
    }

    @Provide
    public Arbitrary<Float> invalidHeight() {
        return Arbitraries
            .floats()
            .between(Float.MIN_VALUE, Float.MAX_VALUE)
            .filter(height -> height < NewShepard.MIN_HEIGHT || height > NewShepard.MAX_HEIGHT);
    }

    @Provide
    public Arbitrary<Float> validTime() {
        return Arbitraries
            .floats()
            .between(NewShepard.MIN_TIME, NewShepard.MAX_TIME);
    }

    @Provide
    public Arbitrary<Float> invalidTime() {
        return Arbitraries
            .floats()
            .between(Float.MIN_VALUE, Float.MAX_VALUE)
            .filter(time -> time < NewShepard.MIN_TIME || time > NewShepard.MAX_TIME);
    }

    @Property
    public void newShepardShouldReturnSuccessForValidWeightHeightAndTime(
        @ForAll("validWeight") float weight,
        @ForAll("validHeight") float height,
        @ForAll("validTime") float time
    ) {
        boolean authorized = NewShepard.autoriza(weight, height, time);
        assertTrue(authorized);
    }
}
