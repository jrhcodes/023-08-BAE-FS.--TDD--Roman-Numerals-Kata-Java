package com.jrhcodes.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {

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
        final String[][] mapToRoman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM", "MMMM"}
        };

        StringBuilder romanValue = new StringBuilder();
        // String romanValue = "";
        int powerOf10 = 0;

        do {
            int digit = value % 10;
            romanValue.insert(0, mapToRoman[powerOf10][digit]);
            // romanValue = mapToRoman[powerOf10][digit] + romanValue;
            value /= 10;
            powerOf10 += 1;
        } while (value > 0);

        return String.valueOf(romanValue);
    }
}



