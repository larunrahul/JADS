package com.learning.ads.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

	/**
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
	 * Complexity: O(val*n) where n is the length of den array
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

}
