package com.learning.ads.dynamicprogramming;

import java.util.Arrays;

/**
 * Standard binary (0/1) knapsack problem
 * 
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * 
 * @author Arun Rahul
 *
 */
public class Knapsack {

	/**
	 * Complexity: O(2^N) where N is the number of weights
	 * 
	 * @param values
	 * @param weights
	 * @param capacity
	 * @return
	 */
	public int binaryRec(int[] values, int[] weights, int capacity) {
		return binaryRec(values, weights, capacity, 0);
	}

	private int binaryRec(int[] values, int[] weights, int capacity, int index) {
		if (index == weights.length || capacity == 0) {
			return 0;
		}
		if (weights[index] > capacity) {
			return binaryRec(values, weights, capacity, index + 1);
		}
		return Math.max(values[index] + binaryRec(values, weights, capacity - weights[index], index + 1),
				binaryRec(values, weights, capacity, index + 1));
	}

	/**
	 * Complexity: O(2^N) where N is the number of weights
	 * 
	 * @param values
	 * @param weights
	 * @param capacity
	 * @return
	 */
	public int binaryRecAnother(int[] values, int[] weights, int capacity) {
		return binaryRecAnother(values, weights, capacity, 0);
	}

	private int binaryRecAnother(int[] values, int[] weights, int capacity, int index) {
		if (capacity < 0) {
			return -1;
		}

		int result;
		if (index == weights.length || capacity == 0) {
			result = 0;
		} else {
			int left = binaryRecAnother(values, weights, capacity - weights[index], index + 1);
			if (left != -1) {
				left += values[index];
			}
			int right = binaryRecAnother(values, weights, capacity, index + 1);
			result = Math.max(left, right);
		}
		return result;

	}

	/**
	 * Complexity: O(N*C) where N is number of weights and C is the capacity of
	 * knapsack
	 * 
	 * @param values
	 * @param weights
	 * @param capacity
	 * @return
	 */
	public int binaryRecTopDown(int[] values, int[] weights, int capacity) {
		int[][] dp = new int[weights.length + 1][capacity + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return binaryRecTopDown(values, weights, dp, capacity, 0);
	}

	private int binaryRecTopDown(int[] values, int[] weights, int[][] dp, int capacity, int index) {
		if (dp[index][capacity] != -1) {
			return dp[index][capacity];
		}
		int result;
		if (index == weights.length || capacity == 0) {
			result = 0;
		} else if (weights[index] > capacity) {
			result = binaryRecTopDown(values, weights, dp, capacity, index + 1);
		} else {
			result = Math.max(
					values[index] + binaryRecTopDown(values, weights, dp, capacity - weights[index], index + 1),
					binaryRecTopDown(values, weights, dp, capacity, index + 1));
		}
		return dp[index][capacity] = result;
	}

	/**
	 * Complexity: O(N*C) where N is number of weights and C is the capacity of
	 * knapsack
	 * 
	 * @param values
	 * @param weights
	 * @param capacity
	 * @return
	 */
	public int binaryRecBottomUp(int[] values, int[] weights, int capacity) {
		int[][] dp = new int[weights.length + 1][capacity + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= capacity; j++) {

			}
		}
		return dp[0][capacity];
	}

}
