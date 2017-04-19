package com.learning.ads.sort;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class InsertionSortTest {

	public InsertionSort insertionSort = new InsertionSort();

	@Test
	public void ascendingSortWhenArrayIsRnadom() {
		int[] actualArray = { 2, 5, 2, 37, 3, 1, 7, 4, 9, 6, 10 };
		int[] expectedArray = { 1, 2, 2, 3, 4, 5, 6, 7, 9, 10, 37 };
		insertionSort.ascendingSort(actualArray);
		assertArrayEquals(expectedArray, actualArray);
	}

	@Test
	public void ascendingSortWhenArrayIsAlreadySorted() {
		int[] actualArray = { 1, 2, 2, 3, 4, 5, 6, 7, 9, 10, 37 };
		int[] expectedArray = { 1, 2, 2, 3, 4, 5, 6, 7, 9, 10, 37 };
		insertionSort.ascendingSort(actualArray);
		assertArrayEquals(expectedArray, actualArray);
	}
	
	@Test
	public void ascendingSortWhenArrayIsPartiallySorted() {
		int[] actualArray = { 1, 2, 2, 3, 4, 10, 6, 37, 9, 5, 7 };
		int[] expectedArray = { 1, 2, 2, 3, 4, 5, 6, 7, 9, 10, 37 };
		insertionSort.ascendingSort(actualArray);
		assertArrayEquals(expectedArray, actualArray);
	}

}
