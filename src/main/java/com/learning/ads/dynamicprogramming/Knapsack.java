package com.learning.ads.dynamicprogramming;

public class Knapsack {

	public int binaryRec(int[] values, int[] weights, int capacity) {
		return binaryRecr(values, weights, capacity, 0, 0);
	}

	private int binaryRecr(int[] values, int[] weights, int capacity, int currentValue, int index) {
		if (capacity == 0) {
			return currentValue;
		}
		if (index >= weights.length) {
			return 0;
		}
		return Math.max(binaryRecr(values, weights, capacity - weights[index], currentValue + values[index], index + 1),
				binaryRecr(values, weights, capacity, currentValue, index + 1));
	}

}
