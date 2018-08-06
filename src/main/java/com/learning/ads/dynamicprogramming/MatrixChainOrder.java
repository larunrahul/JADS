package com.learning.ads.dynamicprogramming;

public class MatrixChainOrder {

	public class Result {
		int finalScalarMuls;
		String parenthesizedChain;
	}

	/**
	 * Complexity: O(n^3)
	 * 
	 * @param sizes
	 * @return
	 */
	public Result calculateMultiplications(int[] sizes) {
		int n = sizes.length - 1;
		int[][] dp = new int[n + 1][n + 1];
		int[][] paths = new int[n + 1][n + 1];
		Result result = new Result();
		calculateMultiplications(sizes, dp, paths);
		StringBuilder s = new StringBuilder();
		prepareOptimalChain(paths, 1, n, s);
		result.finalScalarMuls = dp[1][n];
		result.parenthesizedChain = s.toString();
		return result;
	}

	/**
	 * Complexity: O(n^3)
	 * 
	 * @param sizes
	 * @return
	 */
	public Result calculateMultiplicationsRec(int[] sizes) {
		int n = sizes.length - 1;
		int[][] dp = new int[n + 1][n + 1];
		int[][] paths = new int[n + 1][n + 1];
		Result result = new Result();
		calculateMultiplicationsRec(sizes, dp, paths, 1, n);
		StringBuilder s = new StringBuilder();
		prepareOptimalChain(paths, 1, n, s);
		result.finalScalarMuls = dp[1][n];
		result.parenthesizedChain = s.toString();
		return result;
	}

	private int calculateMultiplicationsRec(int[] sizes, int[][] dp, int[][] paths, int i, int j) {
		if (i == j) {
			return 0;
		}
		dp[i][j] = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int q = calculateMultiplicationsRec(sizes, dp, paths, i, k)
					+ calculateMultiplicationsRec(sizes, dp, paths, k + 1, j) + sizes[i - 1] * sizes[k] * sizes[j];
			if (q < dp[i][j]) {
				dp[i][j] = q;
				paths[i][j] = k;
			}
		}
		return dp[i][j];
	}

	private void calculateMultiplications(int[] sizes, int[][] dp, int[][] paths) {
		int n = sizes.length - 1;
		for (int length = 2; length <= n; length++) {
			for (int i = 1; i <= n - length + 1; i++) {
				int j = i + length - 1;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					int q = dp[i][k] + dp[k + 1][j] + sizes[i - 1] * sizes[k] * sizes[j];
					if (q < dp[i][j]) {
						dp[i][j] = q;
						paths[i][j] = k;
					}
				}
			}
		}
	}

	private void prepareOptimalChain(int[][] paths, int i, int j, StringBuilder s) {
		if (i == j) {
			s.append("A" + i);
		} else {
			s.append("(");
			prepareOptimalChain(paths, i, paths[i][j], s);
			prepareOptimalChain(paths, paths[i][j] + 1, j, s);
			s.append(")");
		}
	}
}
