package com.learning.ads.divideandconquer;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MaximumSubarrayTest {

	@Test
	public void maxSubarrayWithnlognSolution() {
		int[] array = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		MaximumSubarray maximumSubarray = new MaximumSubarray(array);
		int[] result = maximumSubarray.findMaximumSubarray();
		assertArrayEquals(new int[] { 7, 10, 43 }, result);
	}
	
	@Test
	public void maxSubarrayWithnsquaredSolution() {
		int[] array = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		MaximumSubarray maximumSubarray = new MaximumSubarray(array);
		int[] result = maximumSubarray.findMaximumSubarrayInefficient();
		assertArrayEquals(new int[] { 7, 10, 43 }, result);
	}

}
