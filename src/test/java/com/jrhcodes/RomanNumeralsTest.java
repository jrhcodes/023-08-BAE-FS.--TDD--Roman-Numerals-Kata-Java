package com.jrhcodes;

import com.jrhcodes.roman.RomanNumerals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;


public class RomanNumeralsTest {

    @ParameterizedTest
    @CsvFileSource(resources = "testRomanNumerals.csv")
    public void testFromRomanNumeralsAsString(String roman, int value) {
        assertEquals(value, RomanNumerals.fromRomanNumeralsAsString(roman));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "testRomanNumerals.csv")
    public void testToRomanNumeralsAsString(String roman, int value) {
        assertEquals(roman, RomanNumerals.toRomanNumeralsAsString(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4000, -1, 32767, -32767})
    public void testToRomanNumeralsAsStringInvalidArgs(int value) {
        assertThrowsExactly(IllegalArgumentException.class, () -> RomanNumerals.toRomanNumeralsAsString(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    ", "MCHAMMER", "M M", "ABCD", "123"})
    public void testFromRomanNumeralsAsStringInvalidArgs(String value) {
        assertThrowsExactly(IllegalArgumentException.class, () -> RomanNumerals.fromRomanNumeralsAsString(value));
    }

    @Test
    public void testFromRomanNumeralsAsStringNullArg() {
        assertThrowsExactly(IllegalArgumentException.class, () -> RomanNumerals.fromRomanNumeralsAsString(null));
    }

}