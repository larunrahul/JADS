package com.learning.ads.sort;

public class SelectionSort {

	public void sort(int[] array) {
		/*
		 * we don't need to iterate the last element. That must be the shortest
		 * of remaining(just kidding, no elements were left), that is largest of
		 * all.
		 */
		for (int i = 0; i < array.length - 1; i++) {
			int smallestIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[smallestIndex]) {
					smallestIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[smallestIndex];
			array[smallestIndex] = temp;
		}
	}
}
