package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSumSubArrayTest {

	MaxSumSubArray mss = new MaxSumSubArray();

	@Test
	public void kadaneAllPositive() {
		int[] array = new int[] { 1, 9, 2, 8, 3, 7, 4, 6, 5 };
		assertArrayEquals(new int[] { 0, array.length - 1, 45 }, mss.kadane(array));
	}

	@Test
	public void kadaneAllNegative() {
		int[] array = new int[] { -1, -9, -2, -8, -3, -7, -4, -6, -5 };
		assertArrayEquals(new int[] { 0, 0, -1 }, mss.kadane(array));
	}
	
	@Test
	public void kadaneAllNegativeWithMiddle() {
		int[] array = new int[] { -9, -2, -8, -3, -1, -7, -4, -6, -5 };
		assertArrayEquals(new int[] { 4, 4, -1 }, mss.kadane(array));
	}

	@Test
	public void kadaneMix() {
		int[] array = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		assertArrayEquals(new int[] { 2, 6, 7 }, mss.kadane(array));
	}

}
