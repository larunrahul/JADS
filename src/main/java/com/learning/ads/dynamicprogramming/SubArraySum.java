package com.learning.ads.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Find if there is any subarray with given sum
 * 
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * 
 * @author Arun Rahul
 */
public class SubArraySum {

    /**
     * Time Complexity: O(2^n) where n is length of array
     * 
     * @param array
     * @param sum
     * @return
     */
    public boolean subsetSum(int[] array, int sum) {
        return subsetSumRec(array, 0, sum, 0);
    }

    private boolean subsetSumRec(int[] array, int csum, int sum, int index) {
        if (csum == sum)
            return true;
        if (index >= array.length)
            return false;
        return subsetSumRec(array, csum + array[index], sum, index + 1) || subsetSumRec(array, csum, sum, index + 1);
    }

    /**
     * Time Complexity: O(n^2) where n is length of array
     * 
     * Space Complexity: O(n^2) where n is lenght of array
     * 
     * @param array
     * @param sum
     * @return
     */
    public boolean subsetSumTopDown(int[] array, int sum) {

        int[][] dp = new int[IntStream.of(array).sum()][array.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return subsetSumTopDownRec(array, dp, 0, sum, 0);
    }

    private boolean subsetSumTopDownRec(int[] array, int[][] dp, int csum, int sum, int index) {
        if (csum == sum)
            return true;
        if (csum > sum || index >= array.length)
            return false;
        if (dp[csum][index] >= 0) {
            return dp[csum][index] == 1;
        }
        boolean with = subsetSumTopDownRec(array, dp, csum + array[index], sum, index + 1);
        boolean without = subsetSumTopDownRec(array, dp, csum, sum, index + 1);
        dp[csum][index] = with || without ? 1 : 0;
        return dp[csum][index] == 1;
    }

}