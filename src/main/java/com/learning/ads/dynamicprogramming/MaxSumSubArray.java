package com.learning.ads.dynamicprogramming;

public class MaxSumSubArray {
	/**
	 * Kadane's algorithm to find maximum sub array. Complexity: O(n)
	 * 
	 * @return
	 */
	public int[] kadane(int[] array) {
		int max_sum = array[0], max_sum_so_far = array[0], first = 0, last = 0;
		for (int i = 1; i < array.length; i++) {
			max_sum_so_far = Math.max(max_sum_so_far + array[i], array[i]);
			max_sum = Math.max(max_sum, max_sum_so_far);
			if (max_sum == max_sum_so_far) {
				last = i;
			}
			if (max_sum == array[i]) {
				first = i;
				last = i;
			}
		}
		return new int[] { first, last, max_sum };
	}
	
}
