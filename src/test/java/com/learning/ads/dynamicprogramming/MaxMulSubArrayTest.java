package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxMulSubArrayTest {

	MaxMulSubArray mss = new MaxMulSubArray();

	@Test
	public void kadaneMultiplyOddNegatives() {
		int[] array = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		assertArrayEquals(new int[] { 1, 7, 360 }, mss.maxMultiply(array));
		assertEquals(360, mss.kadaneMultiply(array));
	}

	@Test
	public void kadaneMultiplyEvenNegatives() {
		int[] array = new int[] { -2, -3, 4, -1, -2, 1, 5, 3 };
		assertArrayEquals(new int[] { 0, 7, 720 }, mss.maxMultiply(array));
		assertEquals(720, mss.kadaneMultiply(array));
		array = new int[] { 2, 3, 4, -1, -2, 1, 5, 3, 6, 7, 8 };
		assertEquals(241920, mss.kadaneMultiply(array));
	}

	@Test
	public void kadaneMultiplyAllNegativesEvenCount() {
		int[] array = new int[] { -2, -3, -4, -1, -2, -1, -5, -3 };
		assertArrayEquals(new int[] { 0, 7, 720 }, mss.maxMultiply(array));
		assertEquals(720, mss.kadaneMultiply(array));
	}

	@Test
	public void kadaneMultiplyAllNegativesOddCount() {
		int[] array = new int[] { -2, -3, -4, -1, -2, -1, -5, -3, -7 };
		assertArrayEquals(new int[] { 1, 8, 2520 }, mss.maxMultiply(array));
		assertEquals(2520, mss.kadaneMultiply(array));
	}

	@Test
	public void kadaneMultiplySingleNegative() {
		int[] array = new int[] { 2, 3, 4, 1, -2, 1, 5, 3, 7 };
		assertArrayEquals(new int[] { 5, 8, 105 }, mss.maxMultiply(array));
		assertEquals(105, mss.kadaneMultiply(array));
	}

	@Test
	public void kadaneMultiplyMore() {
		int[] array = new int[] { -2, 0, -1 };
		assertEquals(0, mss.kadaneMultiply(array));
		array = new int[] { -2, -3, 4 };
		assertEquals(24, mss.kadaneMultiply(array));
	}

}
