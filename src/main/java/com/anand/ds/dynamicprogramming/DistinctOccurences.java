package com.anand.ds.dynamicprogramming;

/**
 * You are given two strings txt and pat, find the count of distinct occurrences of pat as a subsequence in txt.
 * Note: It is guaranteed that the ans will fit within a 32-bit integer.
 * Examples:
 * Input: txt = "abba", pat = "aba"
 * Output: 2
 * Explanation: There are 2 sub-sequences: [abba], [abba].
 * Input: txt = "banana", pat = "ban"
 * Output: 3
 * Explanation: There are 3 sub-sequences: [banana], [banana], [banana].
 * Constraints:
 * 1 ≤ txt.size(), pat.size() ≤ 103
 * txt contains: [a-z].
 * pat contains: [a-z].
 */

/**
 * MATCH → TAKE + SKIP
 * If txt[i] == pat[j] THEN dp[i][j] = TAKE + SKIP i.e.  dp[i-1][j-1] + dp[i-1][j]
 * If the last characters of both strings match, we have two options:
 * 1. Take the last character of both strings and count the occurrences of the remaining strings
 * 2. Skip the last character of the text and count the occurrences of the pattern in the remaining text
 * If the last characters of both strings do not match, we can only skip the last character of the text and count the occurrences of the pattern in the remaining text.
 *
 * Empty pattern = 1
 * Empty text + non-empty pattern = 0
 * "Nothing can always make nothing."
 * DP Table :
 *         ""   a   b   a
 *       ----------------
 * ""     | 1   0   0   0
 * a      | 1   1   0   0
 * b      | 1   1   1   0
 * b      | 1   1   2   0
 * a      | 1   2   2   2
 *
 * dp[4][3] = 2
 */
public class DistinctOccurences {
    /**
     * Empty pattern = 1
     * Empty text + non-empty pattern = 0
     * @param txt
     * @param pat
     * @return
     */
    public int subsequenceCount(String txt, String pat) {
        int m = txt.length();
        int n = pat.length();
        int[][] dp = new int[m + 1][n + 1];

        // If pat is empty, there is one subsequence of txt that matches it (the empty subsequence)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // If txt is empty and pat is not, there are no subsequences of txt that match pat
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (txt.charAt(i - 1) == pat.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        DistinctOccurences distinctOccurences = new DistinctOccurences();
        String txt = "banana";
        String pat = "ban";
        int count = distinctOccurences.subsequenceCount(txt, pat);
        System.out.println("Count of distinct occurrences of '" + pat + "' in '" + txt + "' is: " + count);
    }
}
