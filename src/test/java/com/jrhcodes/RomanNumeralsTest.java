package com.jrhcodes;

import com.jrhcodes.roman.RomanNumerals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {
    @ParameterizedTest
    @CsvSource({"I,1",
            "XII,12",
            "CXXIII,123",
            "MCCXXXIV,1234",
            "MMCCCXLV,2345",
            "MMMCDLVI,3456",
            "DLXVII,567",
            "DCLXXVIII,678",
            "DCCLXXXIX,789",
            "DCCCXC,890",
            "CM,900",
            "DCCCXI,811",
            "DLVI,556",
            "DCXIV,614",
            "CMXXXIX,939",
            "CCLXV,265",
            "CCCXCIX,399",
            "CMLXXIII,973",
            "CDLXXXIII,483",
            "DCCLII,752",
            "CCCXXX,330",
            "DCLXXXI,681",
            "CXLVII,147",
            "CCLXXXVI,286",
            "CCCLX,360",
            "DXXII,522",
            "DCCLVIII,758",
            "MMMDCCCLXXXVIII,3888",
            "CXIV,114",
            "CDXCVI,496",
            "CMLVII,957",
            "DCCXCII,792",
            "DCXXXVI,636",
            "DCCLXXVI,776",
            "CCC,300",
            "CXXXII,132",
            "DCCCLXV,865",
            "CCCXXVI,326",
            "DCCVII,707",
            "CLXII,162",
            "MMCMIII,2903",
            "MMMCMXCIX,3999"})

    public void testFromRomanNumeralsAsString(String roman, int value) {
        assertEquals(value, RomanNumerals.fromRomanNumeralsAsString(roman));
    }

    @ParameterizedTest
    @CsvSource({"I,1",
            "XII,12",
            "CXXIII,123",
            "MCCXXXIV,1234",
            "MMCCCXLV,2345",
            "MMMCDLVI,3456",
            "DLXVII,567",
            "DCLXXVIII,678",
            "DCCLXXXIX,789",
            "DCCCXC,890",
            "CM,900",
            "DCCCXI,811",
            "DLVI,556",
            "DCXIV,614",
            "CMXXXIX,939",
            "CCLXV,265",
            "CCCXCIX,399",
            "CMLXXIII,973",
            "CDLXXXIII,483",
            "DCCLII,752",
            "CCCXXX,330",
            "DCLXXXI,681",
            "CXLVII,147",
            "CCLXXXVI,286",
            "CCCLX,360",
            "DXXII,522",
            "DCCLVIII,758",
            "MMMDCCCLXXXVIII,3888",
            "CXIV,114",
            "CDXCVI,496",
            "CMLVII,957",
            "DCCXCII,792",
            "DCXXXVI,636",
            "DCCLXXVI,776",
            "CCC,300",
            "CXXXII,132",
            "DCCCLXV,865",
            "CCCXXVI,326",
            "DCCVII,707",
            "CLXII,162",
            "MMCMIII,2903",
            "MMMCMXCIX,3999"})
    public void testToRomanNumeralsAsString(String roman, int value) {
        assertEquals(roman, RomanNumerals.toRomanNumeralsAsString(value));
    }

};