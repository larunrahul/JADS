package com.learning.ads.misc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubSetSumWithTwoElementsTest {
	
	SubSetSumWithTwoElements ss = new SubSetSumWithTwoElements();

	@Test
	public void isSubsetPresentWithSumWhenTrue() {
		assertEquals(true, ss.isSubsetPresentWithSum(new Integer[] { 5, 8, 3, 0, 2, 6 }, 9));
	}
	
	@Test
	public void isSubsetPresentWithSumWhenFalse() {
		assertEquals(false, ss.isSubsetPresentWithSum(new Integer[] { 5, 8, 3, 0, 2, 6 }, 19));
	}
}
