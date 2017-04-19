package com.learning.ads.sort;

public class InsertionSort{

	/**
	 * Ascending sort
	 */
	public void ascendingSort(int[] array) {
		for (int index = 1; index < array.length; index++) {
			int key = array[index];
			int sortedIndex = index - 1;
			while (sortedIndex >= 0 && array[sortedIndex] > key) {
				array[sortedIndex + 1] = array[sortedIndex];
				sortedIndex -= 1;
			}
			array[sortedIndex + 1] = key;
		}
	}

	/**
	 * Descending sort
	 */
	public void descendingSort(int[] array) {
		for (int index = 1; index < array.length; index++) {
			int key = array[index];
			int sortedIndex = index - 1;
			while (sortedIndex >= 0 && key > array[sortedIndex]) {
				array[sortedIndex + 1] = array[sortedIndex];
				sortedIndex -= 1;
			}
			array[sortedIndex + 1] = key;
		}
	}

}
