package com.learning.ads.sort.heap;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.learning.ads.sort.heap.BinaryHeapSort;

public class BinaryHeapSortTest {
	
	private BinaryHeapSort<Integer> binaryHeapSort = new BinaryHeapSort<>();

	@Test
	public void sortInAscendingOrder() {
		Integer[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		binaryHeapSort.sort(array);
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 7, 8, 9, 10, 14, 16}, array);
	}

	@Test
	public void sortInDescendingOrder() {
		Integer[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		binaryHeapSort.sortDescending(array);
		assertArrayEquals(new Integer[] {16, 14, 10, 9, 8, 7, 4, 3, 2, 1}, array);
	}
}
