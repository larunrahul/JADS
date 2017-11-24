package com.learning.ads.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class HeapSortTest {
	
	private HeapSort heapSort = new HeapSort();

	@Test
	public void sortInAscendingOrder() {
		int[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		heapSort.sort(array);
		assertArrayEquals(new int[] {1, 2, 3, 4, 7, 8, 9, 10, 14, 16}, array);
	}

	@Test
	public void sortInDescendingOrder() {
		int[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		heapSort.sortDescending(array);
		assertArrayEquals(new int[] {16, 14, 10, 9, 8, 7, 4, 3, 2, 1}, array);
	}
}
