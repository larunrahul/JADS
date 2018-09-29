package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KnapsackTest {

	Knapsack knapsack;

	@Before
	public void setUp() throws Exception {
		knapsack = new Knapsack();
	}

	@Test
	public void binaryRecr() {
		System.out.println(knapsack.binaryRec(new int[] { 60, 100, 120 }, new int[] { 10, 20, 30 }, 50));
	}

}
