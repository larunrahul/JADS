package com.learning.ads.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
	
	private BinarySearch bs = new BinarySearch();

	@Test
	public void searchStart() {
		assertEquals(0, bs.search(new Integer[] { 2, 3, 4, 5, 6, 7, 8 }, 2));
	}
	
	@Test
	public void searchMid() {
		assertEquals(3, bs.search(new Integer[] { 2, 3, 4, 5, 6, 7, 8 }, 5));
	}
	
	@Test
	public void searchEnd() {
		assertEquals(6, bs.search(new Integer[] { 2, 3, 4, 5, 6, 7, 8 }, 8));
	}
	
	@Test
	public void searchAnyLeftHalf() {
		assertEquals(1, bs.search(new Integer[] { 2, 3, 4, 5, 6, 7, 8 }, 3));
	}
	
	@Test
	public void searchAnyRightHalf() {
		assertEquals(5, bs.search(new Integer[] { 2, 3, 4, 5, 6, 7, 8 }, 7));
	}
	
	@Test
	public void searchUnknown() {
		assertEquals(-1, bs.search(new Integer[] { 2, 3, 4, 5, 6, 7, 8 }, 56));
	}
}
