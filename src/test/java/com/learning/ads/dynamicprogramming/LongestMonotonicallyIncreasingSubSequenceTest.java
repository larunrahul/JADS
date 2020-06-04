package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestMonotonicallyIncreasingSubSequenceTest {

	LongestMonotonicallyIncreasingSubSequence lis = new LongestMonotonicallyIncreasingSubSequence();


	@Test
	public void lengthOfLIS() {
		assertEquals(5, lis.lengthOfLIS(new int[] { 1, 2, 3, 8, 6, 7 }));
		assertEquals(6, lis.lengthOfLIS(new int[] { 1, 2, 3, 4, 8, 6, 5, 7 }));
		assertEquals(6, lis.lengthOfLIS(new int[] { 1, 2, 3, 4, 8, -1, 5, 7 }));
		assertEquals(7, lis.lengthOfLIS(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }));
		assertEquals(1, lis.lengthOfLIS(new int[] { 1 }));
		assertEquals(1, lis.lengthOfLIS(new int[] { 1, 1 }));
		assertEquals(2, lis.lengthOfLIS(new int[] { 1, 2 }));
		assertEquals(2, lis.lengthOfLIS(new int[] { 2, 1, 2 }));
		assertEquals(2, lis.lengthOfLIS(new int[] { 2, 1, 3 }));
		assertEquals(1, lis.lengthOfLIS(new int[] { 3, 2, 1 }));
		assertEquals(4, lis.lengthOfLIS(new int[] { 9, 9, 9, 9, 2, 1, 6, 4, 8, 4, 4, 4, 10, 10, 10 }));
		assertEquals(6, lis.lengthOfLIS(new int[] { 15, 27, 14, 38, 26, 55, 46, 65, 85 }));
	}

	@Test
	public void lengthOfLISTopDown() {
		assertEquals(5, lis.lengthOfLISTopDown(new int[] { 1, 2, 3, 8, 6, 7 }));
		assertEquals(6, lis.lengthOfLISTopDown(new int[] { 1, 2, 3, 4, 8, 6, 5, 7 }));
		assertEquals(6, lis.lengthOfLISTopDown(new int[] { 1, 2, 3, 4, 8, -1, 5, 7 }));
		assertEquals(7, lis.lengthOfLISTopDown(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }));
		assertEquals(1, lis.lengthOfLISTopDown(new int[] { 1 }));
		assertEquals(1, lis.lengthOfLISTopDown(new int[] { 1, 1 }));
		assertEquals(2, lis.lengthOfLISTopDown(new int[] { 1, 2 }));
		assertEquals(2, lis.lengthOfLISTopDown(new int[] { 2, 1, 2 }));
		assertEquals(2, lis.lengthOfLISTopDown(new int[] { 2, 1, 3 }));
		assertEquals(1, lis.lengthOfLISTopDown(new int[] { 3, 2, 1 }));
		assertEquals(4, lis.lengthOfLISTopDown(new int[] { 9, 9, 9, 9, 2, 1, 6, 4, 8, 4, 4, 4, 10, 10, 10 }));
		assertEquals(6, lis.lengthOfLISTopDown(new int[] { 15, 27, 14, 38, 26, 55, 46, 65, 85 }));
	}

	@Test
	public void lengthOfLISBottomUp() {
		assertEquals(5, lis.lengthOfLISBottomUp(new int[] { 1, 2, 3, 8, 6, 7 }));
		assertEquals(6, lis.lengthOfLISBottomUp(new int[] { 1, 2, 3, 4, 8, 6, 5, 7 }));
		assertEquals(6, lis.lengthOfLISBottomUp(new int[] { 1, 2, 3, 4, 8, -1, 5, 7 }));
		assertEquals(7, lis.lengthOfLISBottomUp(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }));
		assertEquals(1, lis.lengthOfLISBottomUp(new int[] { 1 }));
		assertEquals(1, lis.lengthOfLISBottomUp(new int[] { 1, 1 }));
		assertEquals(2, lis.lengthOfLISBottomUp(new int[] { 1, 2 }));
		assertEquals(2, lis.lengthOfLISBottomUp(new int[] { 2, 1, 2 }));
		assertEquals(2, lis.lengthOfLISBottomUp(new int[] { 2, 1, 3 }));
		assertEquals(1, lis.lengthOfLISBottomUp(new int[] { 3, 2, 1 }));
		assertEquals(4, lis.lengthOfLISBottomUp(new int[] { 9, 9, 9, 9, 2, 1, 6, 4, 8, 4, 4, 4, 10, 10, 10 }));
		assertEquals(6, lis.lengthOfLISBottomUp(new int[] { 15, 27, 14, 38, 26, 55, 46, 65, 85 }));
	}

	@Test
	public void lengthOfLISEfficient() {
		assertEquals(5, lis.lengthOfLISEfficient(new int[] { 1, 2, 3, 8, 6, 7 }));
		assertEquals(6, lis.lengthOfLISEfficient(new int[] { 1, 2, 3, 4, 8, 6, 5, 7 }));
		assertEquals(6, lis.lengthOfLISEfficient(new int[] { 1, 2, 3, 4, 8, -1, 5, 7 }));
		assertEquals(7, lis.lengthOfLISEfficient(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }));
		assertEquals(1, lis.lengthOfLISEfficient(new int[] { 1 }));
		assertEquals(1, lis.lengthOfLISEfficient(new int[] { 1, 1 }));
		assertEquals(2, lis.lengthOfLISEfficient(new int[] { 1, 2 }));
		assertEquals(2, lis.lengthOfLISEfficient(new int[] { 2, 1, 2 }));
		assertEquals(2, lis.lengthOfLISEfficient(new int[] { 2, 1, 3 }));
		assertEquals(1, lis.lengthOfLISEfficient(new int[] { 3, 2, 1 }));
		assertEquals(4, lis.lengthOfLISEfficient(new int[] { 9, 9, 9, 9, 2, 1, 6, 4, 8, 4, 4, 4, 10, 10, 10 }));
		assertEquals(6, lis.lengthOfLISEfficient(new int[] { 15, 27, 14, 38, 26, 55, 46, 65, 85 }));
	}

}
