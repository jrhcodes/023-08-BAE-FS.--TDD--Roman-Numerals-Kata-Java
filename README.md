Readme for 2023-08-BAE-FS.--TDD--Roman-Numerals-Kata-Java

Author - Julian Hirst

This repository contains the utility class RomanNumerals and its tests.
RomanNumerals implements two static public member functions:

- fromRomanNumeralsAsString, which converts a String containing roman numerals into an int
- toRomanNumeralsAsString, which converts an int into a String containing roman numerals.

Tests are implemented as follows:

- testFromRomanNumeralsAsString tests the function fromRomanNumeralsAsString for expected values given in the file "testRomanNumerals.csv"
- testToRomanNumeralsAsString tests the function toRomanNumeralsAsString for expected values given in the file "testRomanNumerals.csv"
- testToRomanNumeralsAsStringInvalidArgs - tests toRomanNumeralsAsString with a series of values outside the range 1...3999
- testFromRomanNumeralsAsStringInvalidArgs - tests the function testFromRomanNumeralsAsStringInvalidArgs with a series of invalid strings
- testFromRomanNumeralsAsStringNullArg - tests testFromRomanNumeralsAsStringNullArg when a null is passed, instead of a string

fromRomanNumeralsAsString basic algorithm:

Basic checks for a valid argument are processed first:
- non-null string passed
- empty or blank string passed
- any string which does not conform to the regular expression shown is rejected. 
  - starts with 0-3 Ms
  - then, optionally, CM, CD, D or 0-3 Cs  
  - then, optionally, XC, XL, L or 0-3 Xs
  - then, optionally, the next characters can be either IX, IV, V or 0-3 Is - or nothing.

The decoding algorithm is basically this:
- starting with a result of 0
- a digit will either be added to the result, if the value of that digit is more than the value of the next or if it's the last digit
- otherwise it is subtracted

Roman digit values are held in the HashMap romanToDecimalMap.

The string is processed in this way character by character and the result returned.

toRomanNumeralsAsString basic algorithm:

A basic check that the value to be converted is in the range 1-3999 is performed first, raising an exception if not.

A StringBuilder object is used to contruct the output string of roman numerals, initially empty.

Roman numerals are taken from the array decimalToRomanMap. 
- Each element of this array contains the roman numeral value for a single decimal digit
- the element decimalToRomanMap[powerof10][digit] contains the roman numeral of a decimal digit in the value to be converted
  - powerof10 is:
    - 0, if the digit is in 'units' 
    - 1 if the digit is in the '10s' column
    - 2 if the digit is in the '100s' column
    - 3 if the digit is in '1000s' column
    - using the 'hundreds 10s and units' notation you learned in primary school
  - digit is just the value digit itself
  - Example: the digit 9 in the number 891 is in the '10s' column, and has a digit value of 9, so it's roman numeral equivalent is given by decimalToRomanMap[1][9], i.e. "XC".

I have left an earlier version of the function which uses division and remainder maths to extract the digits one by one, but have also implemented a second version which might be easier to understand which converts the original number to a string and then converts that string into an array of strings called digits, using .split("").
Each element of the array digits contains a single decimal digit.
The power of 10 of the first digit is given by the length of the string.
Each subsequent digit has a power of 10 one less than the last.

A for loop then cycles through the array of digits, appending the appropriate roman numerals from the array decimalToRomanMap to the return value, given the digits power of 10 and the value of the digit, as described above.

The resultant string is returned.

