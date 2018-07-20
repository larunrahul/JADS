package com.learning.ads.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CountingSortTest {

	CountingSort countingSort = new CountingSort();

	@Test
	public void sortAscending() {
		assertArrayEquals(new int[] { 2, 2, 3, 3, 4, 5, 5, 5, 6, 8, 8, 9, 9, 10 },
				countingSort.ascendingSort(new int[] { 4, 5, 2, 8, 5, 3, 9, 10, 3, 8, 5, 2, 9, 6 }));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 },
				countingSort.ascendingSort(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
	}

}
