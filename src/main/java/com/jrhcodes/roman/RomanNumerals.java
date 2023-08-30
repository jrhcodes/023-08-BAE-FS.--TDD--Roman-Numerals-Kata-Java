package com.jrhcodes.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {

    static final String[][] decimalToRomanMap = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM", "MMMM"}
    };
    private static final Map<Character, Integer> romanToDecimalMap = new HashMap<>();

    static {
        romanToDecimalMap.put('I', 1);
        romanToDecimalMap.put('V', 5);
        romanToDecimalMap.put('X', 10);
        romanToDecimalMap.put('L', 50);
        romanToDecimalMap.put('C', 100);
        romanToDecimalMap.put('D', 500);
        romanToDecimalMap.put('M', 1000);
    }

    public static int fromRomanNumeralsAsString(String romanNumerals) {

        if (romanNumerals.isBlank()) {
            throw new IllegalArgumentException("Empty string passed.");
        }


        if (!romanNumerals.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            throw new IllegalArgumentException("Value contains characters other than Roman numerals. ");
        }

        int result = 0;

        for (int i = 0; i < romanNumerals.length(); i++) {

            int currentNumeralValue = romanToDecimalMap.get(romanNumerals.charAt(i));

            final int lastNumeralIndex = romanNumerals.length() - 1;

            if (i < lastNumeralIndex) {
                int nextValue = romanToDecimalMap.get(romanNumerals.charAt(i + 1));

                if (currentNumeralValue < nextValue) {
                    result -= currentNumeralValue;
                } else {
                    result += currentNumeralValue;
                }
            } else {
                result += currentNumeralValue;
            }
        }

        return result;
    }

    public static String toRomanNumeralsAsString(int value) {

        if (value < 1 || value > 3999) {
            throw new IllegalArgumentException("Value supplied is out of range 0...3999");
        }

        StringBuilder romanValue = new StringBuilder();
        // String romanValue = "";
        int powerOf10 = 0;

        do {
            int digit = value % 10;
            romanValue.insert(0, decimalToRomanMap[powerOf10][digit]);
            // romanValue = mapToRoman[powerOf10][digit] + romanValue;
            value /= 10;
            powerOf10 += 1;
        } while (value > 0);

        return String.valueOf(romanValue);
    }
}



