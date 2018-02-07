package com.learning.ads.dynamicprogramming;

import java.util.Arrays;

import org.junit.Test;

public class MaxMulSubArrayTest {

	MaxMulSubArray mss = new MaxMulSubArray();

	@Test
	public void kadaneMultiplyOddNegatives() {
		int[] array = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(Arrays.toString(mss.maxMultiply(array)));
	}

	@Test
	public void kadaneMultiplyEvenNegatives() {
		int[] array = new int[] { -2, -3, 4, -1, -2, 1, 5, 3 };
		System.out.println(Arrays.toString(mss.maxMultiply(array)));
	}

	@Test
	public void kadaneMultiplyAllNegativesEvenCount() {
		int[] array = new int[] { -2, -3, -4, -1, -2, -1, -5, -3 };
		System.out.println(Arrays.toString(mss.maxMultiply(array)));
	}

	@Test
	public void kadaneMultiplyAllNegativesOddCount() {
		int[] array = new int[] { -2, -3, -4, -1, -2, -1, -5, -3, -7 };
		System.out.println(Arrays.toString(mss.maxMultiply(array)));
	}

	@Test
	public void kadaneMultiplySingleNegative() {
		int[] array = new int[] { 2, 3, 4, 1, -2, 1, 5, 3, 7 };
		System.out.println(Arrays.toString(mss.maxMultiply(array)));
	}
}
