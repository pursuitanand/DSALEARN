package com.anand.ds.string;

/**
 * Given a positive integer n, convert it into its equivalent Roman numeral representation.
 *
 * Roman numerals are formed using the following symbols:
 * I : 1
 * V : 5
 * X : 10
 * L : 50
 * C : 100
 * D : 500
 * M : 1000
 *
 * Roman numerals also use the following subtractive combinations:
 * IV : 4 (5 - 1)
 * IX : 9 (10 - 1)
 * XL : 40 (50 - 10)
 * XC : 90 (100 - 10)
 * CD : 400 (500 - 100)
 * CM : 900 (1000 - 100)
 *
 *
 * Return the Roman numeral representation of the given integer.
 *
 * Examples :
 *
 * Input: n = 9
 * Output: IX
 * Explanation: 9 is represented as IX (10 - 1).
 * Input: n = 493
 * Output: CDXCIII
 * Explanation: 493 = 400 + 90 + 3, which is represented as CD + XC + III = CDXCIII.
 *
 * Expected Complexities
 * Time Complexity: O(log n)
 * Auxiliary Space: O(log n)
 *
 * 2. The Big Idea (Greedy Approach) :
 * "Roman numbers are greedy: always grab the biggest stone you can carry."
 * Because Roman numerals are designed from largest to smallest values.
 * Number = biggest possible Roman value + remaining number
 *
 * Suppose:
 *
 * n = 2944
 *
 * Ask:
 *
 * "What is the biggest Roman value I can subtract right now?"
 *
 * The biggest value ≤ 2944 is:
 *
 * 1000 = M
 *
 * Subtract:
 *
 * 2944 - 1000 = 1944
 *
 * Again:
 *
 * 1000 = M
 *
 * Now:
 *
 * 944
 *
 * Again:
 *
 * 900 = CM
 *
 * Now:
 *
 * 44
 *
 * Again:
 *
 * 40 = XL
 *
 * Now:
 *
 * 4
 *
 * Again:
 *
 * 4 = IV
 *
 * Answer:
 *
 * MMCMXLIV
 *
 * use a greedy approach and keep Roman numeral values and symbols in descending order,
 * including special subtractive cases like 900 and 4.
 * Repeatedly choose the largest value less than or equal to the number, append its symbol, subtract it, and continue until the number becomes zero."
 */
public class DecimalToRoman {
    /**
     * Algorithm Steps
     * Step 1: Create two arrays:
     * values = [1000,900,500,400,...,1]
     * symbols = ["M","CM","D","CD",...,"I"]
     * Step 2: Start from the largest value. Can n use this value?
     *  If yes:
     *  Add the symbol
     *  Subtract the value
     *  Stay at the same index
     * Step 3 : Move to the next smaller value. Repeat until: n == 0
     * @param n
     * @return romanNumeral
     */
    public String convertToRoman(int n) {
        int [] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder romanNumeral = new StringBuilder();
        for(int i=0; i<values.length; i++) {
            while (n >= values[i]) {
                romanNumeral.append(symbols[i]);
                n -= values[i];
            }
        }
        return romanNumeral.toString();
    }

    public static void main(String[] args) {
        DecimalToRoman decimalToRoman = new DecimalToRoman();
        int n = 2944;
        String romanNumeral = decimalToRoman.convertToRoman(n);
        System.out.println("The Roman numeral representation of " + n + " is: " + romanNumeral);
    }
}
