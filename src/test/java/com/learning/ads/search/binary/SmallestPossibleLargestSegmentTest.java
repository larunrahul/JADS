package com.learning.ads.search.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmallestPossibleLargestSegmentTest {

	SmallestPossibleLargestSegment spls = new SmallestPossibleLargestSegment();

	@Test
	public void getSmall() {
		assertEquals(19, spls.getSmall(new int[] { 4, 7, 12, 5, 3, 16 }, 3));
		assertEquals(25, spls.getSmall(new int[] { 3, 13, 5, 7, 18, 8, 20, 1 }, 4));
	}

}
