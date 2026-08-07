package com.anand.ds.string;

/**
 * Given a string s in Roman number format, your task is to convert it to an integer. Various symbols and their values are given below.
 * Note: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
 *
 * Examples:
 *
 * Input: s = "IX"
 * Output: 9
 * Explanation: IX is a Roman symbol which represents 10 – 1 = 9.
 * Input: s = "XL"
 * Output: 40
 * Explanation: XL is a Roman symbol which represents 50 – 10 = 40.
 * Input: s = "MCMIV"
 * Output: 1904
 * Explanation: M is 1000, CM is 1000 – 100 = 900, and IV is 4. So we have total as 1000 + 900 + 4 = 1904.
 * Constraints:
 * 1 ≤ roman number ≤ 3999
 * s[i] belongs to [I, V, X, L, C, D, M]
 *
 * For Integer → Roman, we asked: "What is the biggest value I can take?"
 * For Roman → Integer, we ask: "Should I add this symbol, or subtract it?"
 * Golden Rule : "Small before big means subtract. Otherwise add."
 *  Normal Order : VI = 5 + 1 = 6
 *  Subtract Order : IV = 5 - 1 = 4
 *
 *  Algorithm :
 *  Get its value.
 * Compare it with the next symbol.
 * If current value < next value:
 * subtract current value.
 * Otherwise:
 * add current value.
 */
public class RomanToInteger {

    public int romanToInteger(String s) {
        int answer = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int current = romanValue(s.charAt(i));
            if(i+1 < length && current < romanValue(s.charAt(i + 1))) {
                answer -= current; // Subtract if the next value is greater
            } else {
                answer += current; // Add otherwise
            }
        }
        return answer;
    }

    private int romanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Invalid Roman numeral: " + c);
        }
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        String romanNumeral = "MMCMXLIV";
        int integerValue = romanToInteger.romanToInteger(romanNumeral);
        System.out.println("Roman numeral: " + romanNumeral + " => Integer value: " + integerValue);
    }
}
