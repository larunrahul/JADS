package com.learning.ads.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Problem statement as given in CLRS
 * 
 * Given a rod of length n inches and a table of prices prices[i] for i = 1,2,3,...n, determine the maximum revenue r[n]
 * obtainable by cutting up the rod and selling the pieces. Note that if the price prices[n] for a rod of length n is large
 * enough, an optimal solution may require no cutting at all.
 * 
 * @author rahul.lakkapragada
 *
 */
public class RodCutting {

	public class Result {
		int finalPrice;
		List<Integer> cuts;
	}

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
	 * 
	 * Rod cutting with extra cost incurred for each cut. Same cost for any cut made.
	 * 
	 * Complexity :O(2^n)
	 * 
	 * @param prices
	 * @param size
	 * @return
	 */
	public int cutWitCutCost(int[] prices, int size, int cutCost) {
		if (size == 0) {
			return 0;
		}
		// when we do not cut the rod i.e., when we sell entire rod as-it-is, we do not subtract the cutCost.
		// Hence, we took price of entire rod (without cutCost) and compare it with other lengths which involve cut
		int max = prices[size];
		for (int i = 1; i < size; i++) {
			max = Math.max(max, prices[i] + cut(prices, size - i) - cutCost);
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
				max = Math.max(max, prices[i] + cutTopDown(prices, size - i, dp));
			}
			result = max;
		}
		dp[size] = result;
		return dp[size];
	}

	public Result cutTopDownWithPath(int[] prices, int size) {
		int[] dp = new int[size + 1];
		int[] paths = new int[size + 1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		int finalPrice = cutTopDownWithPath(prices, size, dp, paths);
		List<Integer> cuts = new ArrayList<>();
		while (size != 0) {
			cuts.add(paths[size]);
			size = size - paths[size];
		}
		Result result = new Result();
		result.cuts = cuts;
		result.finalPrice = finalPrice;
		return result;
	}

	private int cutTopDownWithPath(int[] prices, int size, int[] dp, int[] paths) {
		if (dp[size] >= 0) {
			return dp[size];
		}
		int result = 0;
		if (size != 0) {
			int q = Integer.MIN_VALUE;
			for (int i = 1; i <= size; i++) {
				int val = prices[i] + cutTopDownWithPath(prices, size - i, dp, paths);
				if (q < val) {
					q = val;
					paths[size] = i;
				}
			}
			result = q;
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

	/**
	 * Complexity: O(n^2)
	 * 
	 * @param prices
	 * @param size
	 * @return
	 */
	public Result cutBottomUpWithPath(int[] prices, int size) {
		int[] dp = new int[size + 1];
		int[] paths = new int[size + 1];
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

		int finalPrice = dp[size];
		List<Integer> cuts = new ArrayList<>();
		while (size != 0) {
			cuts.add(paths[size]);
			size = size - paths[size];
		}
		Result result = new Result();
		result.cuts = cuts;
		result.finalPrice = finalPrice;
		return result;
	}

	/**
	 * 
	 * Rod cutting with extra cost incurred for each cut. Same cost for any cut made.
	 * 
	 * Complexity: O(n^2)
	 * 
	 * @param prices
	 * @param size
	 * @return
	 */
	public Result cutBottomUpWithCostForCut(int[] prices, int size, int cutCost) {
		int[] dp = new int[size + 1];
		int[] paths = new int[size + 1];
		dp[0] = 0;
		for (int i = 1; i <= size; i++) {
			// when we do not cut the rod i.e., when we sell entire rod as-it-is, we do not subtract the cutCost.
			// Hence, we took price of entire rod (without cutCost) and compare it with other lengths which involve cut
			int q = prices[i];
			paths[i] = i;
			for (int j = 1; j < i; j++) {
				int val = prices[j] + dp[i - j] - cutCost;
				if (q < val) {
					q = val;
					paths[i] = j;
				}
			}
			dp[i] = q;
		}

		int finalPrice = dp[size];
		List<Integer> cuts = new ArrayList<>();
		while (size != 0) {
			cuts.add(paths[size]);
			size = size - paths[size];
		}
		Result result = new Result();
		result.cuts = cuts;
		result.finalPrice = finalPrice;
		return result;
	}

}
