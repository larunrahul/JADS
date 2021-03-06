package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoinChangeTest {

	CoinChange coinChange = new CoinChange();

	@Test
	public void countRec() {
		assertEquals(5, coinChange.countRec(new int[] { 2, 5, 3, 6 }, 10));
		assertEquals(4, coinChange.countRec(new int[] { 1, 2, 3 }, 4));
		assertEquals(5, coinChange.countRec(new int[] { 1, 2, 3 }, 5));
	}

	@Test
	public void countRecTD() {
		assertEquals(5, coinChange.countRecTD(new int[] { 2, 5, 3, 6 }, 10));
		assertEquals(4, coinChange.countRecTD(new int[] { 1, 2, 3 }, 4));
		assertEquals(5, coinChange.countRecTD(new int[] { 1, 2, 3 }, 5));
		assertEquals(1, coinChange.countRecTD(new int[] {}, 0));
	}

	@Test
	public void countBU() {
		assertEquals(5, coinChange.countBU(new int[] { 2, 5, 3, 6 }, 10));
		assertEquals(4, coinChange.countBU(new int[] { 1, 2, 3 }, 4));
		assertEquals(5, coinChange.countBU(new int[] { 1, 2, 3 }, 5));
		assertEquals(1, coinChange.countBU(new int[] {}, 0));
	}

	@Test
	public void countBetterBU() {
		assertEquals(5, coinChange.countBetterBU(new int[] { 2, 5, 3, 6 }, 10));
		assertEquals(4, coinChange.countBetterBU(new int[] { 1, 2, 3 }, 4));
		assertEquals(5, coinChange.countBetterBU(new int[] { 1, 2, 3 }, 5));
		assertEquals(1, coinChange.countBetterBU(new int[] {}, 0));
	}

}
