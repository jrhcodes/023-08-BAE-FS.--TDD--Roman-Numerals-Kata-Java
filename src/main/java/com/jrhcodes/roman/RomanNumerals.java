package com.jrhcodes.roman;

public class RomanNumerals {
    public static int fromRomanNumeralsAsString(String romanNumerals) { return 0; };
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

