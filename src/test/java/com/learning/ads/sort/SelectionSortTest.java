package com.learning.ads.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SelectionSortTest {

	private SelectionSort selectionSort = new SelectionSort();

	@Test
	public void sort() {
		int[] actualArray = { 2, 5, 2, 37, 3, 1, 7, 4, 9, 6, 10 };
		int[] expectedArray = { 1, 2, 2, 3, 4, 5, 6, 7, 9, 10, 37 };
		selectionSort.sort(actualArray);
		assertArrayEquals(expectedArray, actualArray);
	}

}
