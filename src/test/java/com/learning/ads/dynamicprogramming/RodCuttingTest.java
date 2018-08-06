package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.learning.ads.dynamicprogramming.RodCutting.Result;

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
	public void cutTopDownWithPath() {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		Result result = rodCutting.cutTopDownWithPath(prices, 10);
		assertEquals(30, result.finalPrice);
		assertArrayEquals(new Integer[] { 10 }, result.cuts.toArray(new Integer[1]));
		result = rodCutting.cutTopDownWithPath(prices, 7);
		assertEquals(18, result.finalPrice);
		assertArrayEquals(new Integer[] { 1, 6 }, result.cuts.toArray(new Integer[2]));
	}

	@Test
	public void cutBottomUp() {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		assertEquals(30, rodCutting.cutBottomUp(prices, 10));
	}

	@Test
	public void cutBottomUpWithPath() {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		Result result = rodCutting.cutBottomUpWithPath(prices, 10);
		assertEquals(30, result.finalPrice);
		assertArrayEquals(new Integer[] { 10 }, result.cuts.toArray(new Integer[1]));
		result = rodCutting.cutBottomUpWithPath(prices, 7);
		assertEquals(18, result.finalPrice);
		assertArrayEquals(new Integer[] { 1, 6 }, result.cuts.toArray(new Integer[2]));
	}
}
