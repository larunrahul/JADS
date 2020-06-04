package com.learning.ads.dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * https://en.wikipedia.org/wiki/Edit_distance
 * 
 * Given two words, find minimum cost required to transform word1 to word2
 * 
 * Allowed operations are
 * 
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 * 
 * Cost of each operation is assumed to be 1
 * 
 * This is called Levenshtein distance with each operation costs 1
 * 
 */
public class EditDistance {

    /**
     * Time Complexity: O(3^len(m))
     * @param m
     * @param n
     * @return
     */
    public int findDistance(String m, String n) {
        return findDistanceRec(m, n, m.length() - 1, n.length() - 1);
    }

    private int findDistanceRec(String m, String n, int i, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (m.charAt(i) == n.charAt(j))
            return findDistanceRec(m, n, i - 1, j - 1);

        return 1 + Math.min(Math.min(findDistanceRec(m, n, i, j - 1), findDistanceRec(m, n, i - 1, j)),
                findDistanceRec(m, n, i - 1, j - 1));
    }

    /**
     * Time Complexity: O(lne(m) * len(n))
     * Spece Complexity: O(lne(m) * len(n))
     * @param m
     * @param n
     * @return
     */
    public int findDistanceTopDown(String m, String n) {
        int[][] dp = new int[m.length()][n.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return findDistanceTopDownRec(dp, m, n, m.length() - 1, n.length() - 1);
    }

    private int findDistanceTopDownRec(int[][] dp, String m, String n, int i, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if(dp[i][j] != -1) return dp[i][j];
        if (m.charAt(i) == n.charAt(j))
            return dp[i][j] = findDistanceTopDownRec(dp, m, n, i - 1, j - 1);

        return dp[i][j] = 1 + Math.min(
                Math.min(findDistanceTopDownRec(dp, m, n, i, j - 1), findDistanceTopDownRec(dp, m, n, i - 1, j)),
                findDistanceTopDownRec(dp, m, n, i - 1, j - 1));
    }

    /**
     * Time Complexity: O(lne(m) * len(n))
     * Spece Complexity: O(lne(m) * len(n))
     * @param m
     * @param n
     * @return
     */
    public int findDistanceBottomUp(String m, String n) {
        int fl = m.length(), sl = n.length();
        int[][] dp = new int[fl + 1][sl + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0) dp[i][j] = j; 
                else if(j == 0) dp[i][j] = i;
                else if(m.charAt(i - 1) == n.charAt(j - 1)) dp[i][j] = dp[i-1][j- 1];
                else dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
            }
        }
        return dp[fl][sl];
    }
}