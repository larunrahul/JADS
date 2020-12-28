package com.learning.ads.sort.heap;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MultiaryHeapSortTest {
	
	private final MultiaryHeapSort<Integer> heapSort = new MultiaryHeapSort<>(3);

	@Test
	public void sortInAscendingOrder() {
		final Integer[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		heapSort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 7, 8, 9, 10, 14, 16 }, array);
	}

	@Test
	public void sortInDescendingOrder() {
		final Integer[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		heapSort.sortDescending(array);
		assertArrayEquals(new Integer[] {16, 14, 10, 9, 8, 7, 4, 3, 2, 1}, array);
	}
}
