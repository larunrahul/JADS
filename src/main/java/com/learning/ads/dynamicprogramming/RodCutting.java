package com.learning.ads.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCutting {

	/**
	 * Complexity :O(2^n)
	 * 
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
	 * 
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
	 * 
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

	public List<Integer> cutBottomUpWithPath(int[] prices, int size) {
		int[] dp = new int[size + 1];
		int[] paths = new int[size + 1];
		List<Integer> result = new ArrayList<>();
		dp[0] = 0;
		for (int i = 1; i <= size; i++) {
			int q = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				int val = prices[j] + dp[i - j];
				if (q < val) {
					q = val;
					paths[i] = j;
				}
			}
			dp[i] = q;
		}
		while (size != 0) {
			result.add(paths[size]);
			size = size - paths[size];
		}
		return result;
	}

}
