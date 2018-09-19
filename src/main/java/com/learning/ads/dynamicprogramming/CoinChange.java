package com.learning.ads.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

	/**
	 * Naive recursive solution
	 * 
	 * Complexity: O(2^val)
	 * 
	 * @param den
	 * @param val
	 * @return
	 */
	public int countRec(int[] den, int val) {
		return countRec(den, 0, val);
	}

	private int countRec(int[] den, int index, int val) {
		if (val == 0) {
			return 1;
		}
		if (val < 0 || (index >= den.length && val >= 1)) {
			return 0;
		}
		return countRec(den, index, val - den[index]) + countRec(den, index + 1, val);
	}

	/**
	 * Recursive top down approach (memoization)
	 * 
	 * Complexity: O(val*n) where n is the length of den array
	 * 
	 * This algorithm uses O(val*n) auxiliary space
	 * 
	 * @param den
	 * @param val
	 * @return
	 */
	public int countRecTD(int[] den, int val) {
		int[][] dp = new int[den.length + 1][val + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return countRecTD(den, dp, 0, val);
	}

	private int countRecTD(int[] den, int[][] dp, int index, int val) {
		if (val == 0) {
			return dp[index][val] = 1;
		}
		if (val < 0 || (index >= den.length && val >= 1)) {
			return 0;
		}
		if (dp[index][val] != -1) {
			return dp[index][val];
		}
		dp[index][val] = countRecTD(den, dp, index, val - den[index]) + countRecTD(den, dp, index + 1, val);
		return dp[index][val];
	}

	/**
	 * Bottom up approach
	 * 
	 * Complexity: O(val*n) where n is the length of den array. clearly visible from
	 * the following code
	 * 
	 * This algorithm uses O(val*n) auxiliary space
	 * 
	 * @param den
	 * @param val
	 * @return
	 */
	public int countBU(int[] den, int val) {
		int[][] dp = new int[den.length + 1][val + 1];

		// when val eventually reaches 0, that means we were able to find 1 way of
		// denomination for
		// given initial val
		for (int i = 0; i <= den.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= val; i++) {
			for (int j = den.length; j > 0; j--) {
				if (i - den[j - 1] >= 0) {
					dp[j][i] = dp[j][i - den[j - 1]];
				}
				if (j + 1 <= den.length) {
					dp[j][i] += dp[j + 1][i];
				}
			}
		}
		/*
		 * for (int i = 0; i < dp.length; i++) {
		 * System.out.println(Arrays.toString(dp[i])); }
		 */
		return dp[den.length == 0 ? 0 : 1][val];
	}

	/**
	 * Bottom up approach with better auxiliary space
	 * 
	 * Complexity: O(val*n) where n is the length of den array. clearly visible from
	 * the following code
	 * 
	 * This algorithm uses O(val) auxiliary space
	 * 
	 * @param den
	 * @param val
	 * @return
	 */
	public int countBetterBU(int[] den, int val) {
		int[] dp = new int[val + 1];
		dp[0] = 1;
		// fill the elements row by row from bottom to top
		for (int j = den.length; j > 0; j--) {
			for (int i = 1; i <= val; i++) {
				dp[i] += i - den[j - 1] >= 0 ? dp[i - den[j - 1]] : 0;
			}
		}
		return dp[val];
	}

}
