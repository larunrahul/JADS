package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class RodCuttingTest {

	RodCutting rodCutting = new RodCutting();

	@Test
	public void cut() {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		assertEquals(30, rodCutting.cut(prices, 10));
	}

	@Test
	public void cutTopDown() {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		assertEquals(30, rodCutting.cutTopDown(prices, 10));
	}

	@Test
	public void cutBottomUp() {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		assertEquals(30, rodCutting.cutBottomUp(prices, 10));
	}

	@Test
	public void cutBottomUpWithPath() {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		assertArrayEquals(new Integer[] { 10 }, rodCutting.cutBottomUpWithPath(prices, 10).toArray(new Integer[1]));
		assertArrayEquals(new Integer[] { 1, 6 }, rodCutting.cutBottomUpWithPath(prices, 7).toArray(new Integer[2]));
	}
}
