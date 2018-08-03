package com.learning.ads.dynamicprogramming;

import java.util.Arrays;

public class RodCutting {

	/**
	 * Complexity :O(2^n)
	 * @param prices
	 * @param size
	 * @return
	 */
	public int cut(int[] prices, int size) {
		if (size == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= size; i++) {
			max = Math.max(max, prices[i] + cut(prices, size - i));
		}
		return max;
	}

	/**
	 * Complexity: O(n^2)
	 * @param prices
	 * @param size
	 * @return
	 */
	public int cutTopDown(int[] prices, int size) {
		int[] dp = new int[size + 1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		return cutTopDown(prices, size, dp);
	}

	private int cutTopDown(int[] prices, int size, int[] dp) {
		if (dp[size] >= 0) {
			return dp[size];
		}
		int result = 0;
		if (size != 0) {
			int max = Integer.MIN_VALUE;
			for (int i = 1; i <= size; i++) {
				max = Math.max(max, prices[i] + cut(prices, size - i));
			}
			result = max;
		}
		dp[size] = result;
		return dp[size];
	}

	/**
	 * Complexity: O(n^2)
	 * @param prices
	 * @param size
	 * @return
	 */
	public int cutBottomUp(int[] prices, int size) {
		int[] dp = new int[size + 1];
		dp[0] = 0;
		for (int i = 1; i <= size; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				max = Math.max(max, prices[j] + dp[i - j]);
			}
			dp[i] = max;
		}
		return dp[size];
	}
	
}
