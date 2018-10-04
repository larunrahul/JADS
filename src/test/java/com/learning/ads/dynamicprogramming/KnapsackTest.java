package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class KnapsackTest {

	Knapsack knapsack;

	@Before
	public void setUp() throws Exception {
		knapsack = new Knapsack();
	}

	@Test
	public void binaryRec() {
		assertEquals(220, knapsack.binaryRec(new int[] { 60, 100, 120 }, new int[] { 10, 20, 30 }, 50));
		assertEquals(90, knapsack.binaryRec(new int[] { 10, 40, 30, 50 }, new int[] { 5, 4, 6, 3 }, 10));
		assertEquals(1827, knapsack.binaryRec(new int[] { 894, 260, 392, 281, 27 }, new int[] { 8, 6, 4, 0, 21 }, 30));
	}
	
	@Test
	public void binaryRecAnother() {
		assertEquals(220, knapsack.binaryRecAnother(new int[] { 60, 100, 120 }, new int[] { 10, 20, 30 }, 50));
		assertEquals(90, knapsack.binaryRecAnother(new int[] { 10, 40, 30, 50 }, new int[] { 5, 4, 6, 3 }, 10));
		assertEquals(1827, knapsack.binaryRecAnother(new int[] { 894, 260, 392, 281, 27 }, new int[] { 8, 6, 4, 0, 21 }, 30));
	}

	@Test
	public void binaryRecTopDown() {
		assertEquals(220, knapsack.binaryRecTopDown(new int[] { 60, 100, 120 }, new int[] { 10, 20, 30 }, 50));
		assertEquals(90, knapsack.binaryRecTopDown(new int[] { 10, 40, 30, 50 }, new int[] { 5, 4, 6, 3 }, 10));
		assertEquals(1827, knapsack.binaryRecTopDown(new int[] { 894, 260, 392, 281, 27 }, new int[] { 8, 6, 4, 0, 21 }, 30));
	}

}
