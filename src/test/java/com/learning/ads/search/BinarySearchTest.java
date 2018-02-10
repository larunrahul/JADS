package com.learning.ads.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {

	private BinarySearch<Integer> bs = new BinarySearch<>();

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

	@Test
	public void getLastSmallAtMid() {
		assertEquals(6, bs.getLastSmall(new Integer[] { 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2 }, 2));
	}

	@Test
	public void getLastSmallAtEnd() {
		assertEquals(7, bs.getLastSmall(new Integer[] { 1, 1, 1, 1, 1, 1, 1, 2 }, 3));
	}

	@Test
	public void getLastSmallAtFirst() {
		assertEquals(0, bs.getLastSmall(new Integer[] { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, 2));
	}

	@Test
	public void getLastSmallAtLeftHalf() {
		assertEquals(5, bs.getLastSmall(new Integer[] { 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 }, 3));
	}

	@Test
	public void getLastSmallAtrightHalf() {
		assertEquals(10, bs.getLastSmall(new Integer[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3 }, 3));
	}

	@Test
	public void getLastSmallUnequal() {
		assertEquals(3, bs.getLastSmall(new Integer[] { 1, 1, 1, 1, 3, 3, 3 }, 2));
	}

	@Test
	public void getLastSmallNotPresent() {
		assertEquals(6, bs.getLastSmall(new Integer[] { 1, 1, 1, 1, 3, 3, 3 }, 5));
	}

	@Test
	public void getLastSmallSmallArray() {
		assertEquals(0, bs.getLastSmall(new Integer[] { 1, 3 }, 2));
		assertEquals(1, bs.getLastSmall(new Integer[] { 2, 3 }, 4));
	}
	
	@Test
	public void getFirstBigAtMid() {
		assertEquals(7, bs.getFirstBig(new Integer[] { 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2 }, 2));
	}

	@Test
	public void getFirstBigAtEnd() {
		assertEquals(7, bs.getFirstBig(new Integer[] { 1, 1, 1, 1, 1, 1, 1, 2 }, 2));
	}

	@Test
	public void getFirstBigAtFirst() {
		assertEquals(0, bs.getFirstBig(new Integer[] { 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, 1));
	}

	@Test
	public void getFirstBigAtLeftHalf() {
		assertEquals(4, bs.getFirstBig(new Integer[] { 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 }, 2));
	}

	@Test
	public void getFirstBigAtrightHalf() {
		assertEquals(11, bs.getFirstBig(new Integer[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3 }, 3));
	}

	@Test
	public void getFirstBigUnequal() {
		assertEquals(4, bs.getFirstBig(new Integer[] { 1, 1, 1, 1, 3, 3, 3 }, 2));
	}

	@Test
	public void getFirstBigNotPresent() {
		assertEquals(-1, bs.getFirstBig(new Integer[] { 1, 1, 1, 1, 3, 3, 3 }, 5));
	}

	@Test
	public void getFirstBigSmallArray() {
		assertEquals(1, bs.getFirstBig(new Integer[] { 1, 3 }, 2));
		assertEquals(0, bs.getFirstBig(new Integer[] { 2, 3 }, 1));
	}
	
}
