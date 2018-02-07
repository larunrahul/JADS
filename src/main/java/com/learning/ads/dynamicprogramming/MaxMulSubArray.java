package com.learning.ads.dynamicprogramming;

public class MaxMulSubArray {
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

	public int[] kadaneMultiply(int[] array) {
		int max_ending_here = array[0], max_till_now = array[0], mul = array[0],
				first_neg_mul = array[0] < 0 ? array[0] : 1, first_neg_index = array[0] < 0 ? 0 : -1;
		int first_index = 0, last_index = 0;
		boolean first_neg_found = array[0] < 0;
		for (int i = 1; i < array.length; i++) {
			mul = mul * array[i];
			if (array[i] < 0) {
				if (!first_neg_found) {
					first_neg_found = true;
					first_neg_mul = max_ending_here * array[i];
					first_neg_index = i;
				}
				if (first_index != 0) {
					max_ending_here = mul * first_neg_mul;
				} else {
					max_ending_here = mul / first_neg_mul;
					first_index = first_neg_index + 1;
				}
			} else {
				int max_here = max_ending_here * array[i];
				if (array[i] > max_here) {
					first_index = i;
					max_ending_here = array[i];
				} else {
					max_ending_here = max_here;
				}
			}
			last_index = i;
			max_till_now = Math.max(max_till_now, max_ending_here);
			System.out.println(max_ending_here + ":" + max_till_now);
		}
		return new int[] { first_index, last_index, max_till_now };
	}
}
