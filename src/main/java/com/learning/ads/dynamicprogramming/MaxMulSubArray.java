package com.learning.ads.dynamicprogramming;

public class MaxMulSubArray {

	/**
	 * Own implementation based on number of negative numbers in the array
	 * 
	 * At any time prefer {@link #kadaneMultiply} over this due to complexity in
	 * implementing the algorithm
	 * 
	 * Complexity: O(n)
	 * 
	 * @param array
	 * @return
	 */
	public int[] maxMultiply(int[] array) {
		int max_ending_here = 1, neg_count = 0, first_neg_mul = 1, last_neg_mul = 1;
		int first_index = -1, last_index = -1;
		boolean first_neg_found = false, last_neg_found = false;
		for (int i = 0; i < array.length; i++) {
			max_ending_here *= array[i];
			if (array[i] < 0) {
				neg_count++;
				if (!first_neg_found) {
					first_neg_found = true;
					first_neg_mul = max_ending_here;
					first_index = i;
				}
				last_neg_found = true;
				last_neg_mul = array[i];
				last_index = i;
			} else if (last_neg_found) {
				last_neg_mul *= array[i];
			}
		}
		if ((neg_count & 1) != 1) {// even negative numbers
			return new int[] { 0, array.length - 1, max_ending_here };
		} else {
			int first = max_ending_here / first_neg_mul;
			int last = max_ending_here / last_neg_mul;
			if (first >= last) {
				return new int[] { first_index + 1, array.length - 1, first };
			} else {
				return new int[] { 0, last_index - 1, last };
			}
		}
	}

	/**
	 * Implemented based on Kadane's max contiguous sum sub array, but for product
	 * instead of sum.
	 * 
	 * For sum related implementation look at {@link MaxSumSubArray#kadane}}
	 * 
	 * @param array
	 * @return
	 */
	public int kadaneMultiply(int[] array) {
		int max_mul = array[0], max_mul_so_far = array[0], min_mul_so_far = array[0];
		for (int i = 1; i < array.length; i++) {
			int min_prod = min_mul_so_far * array[i];
			int max_prod = max_mul_so_far * array[i];
			min_mul_so_far = Math.min(Math.min(min_prod, max_prod), array[i]);
			max_mul_so_far = Math.max(Math.max(min_prod, max_prod), array[i]);
			max_mul = Math.max(max_mul_so_far, max_mul);
		}
		return max_mul;
	}

}
