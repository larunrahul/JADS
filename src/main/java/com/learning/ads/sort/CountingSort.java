package com.learning.ads.sort;

public class CountingSort {
	public int[] ascendingSort(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			max = Math.max(array[i], max);
		}
		int[] result = new int[array.length], countHolder = new int[max + 1];
		for (int i = 0; i < array.length; i++) {
			countHolder[array[i]] += 1;
		}
		for (int i = 1; i <= max; i++) {
			countHolder[i] += countHolder[i - 1];
		}
		for (int i = 0; i < array.length; i++) {
			result[countHolder[array[i]] - 1] = array[i];
			countHolder[array[i]]--;
		}
		return result;
	}
}
