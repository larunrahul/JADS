package com.learning.ads.misc;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class DutchNationalFlagProblemTest {

	DutchNationalFlagProblem dnf = new DutchNationalFlagProblem();

	@Test
	public void biColor() {
		int[] array = { 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0 };
		dnf.biColor(array);
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, array);
	}

	@Test
	public void triColor() {
		int[] array = { 1, 0, 0, 2, 1, 0, 0, 2, 2, 1, 0, 1, 1, 2, 1, 1, 0, 0, 2, 0, 1, 0 };
		dnf.triColor(array);
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2 }, array);
	}

}
