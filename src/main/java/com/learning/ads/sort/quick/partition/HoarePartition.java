package com.learning.ads.sort.quick.partition;

public class HoarePartition<T extends Comparable<T>> implements Partition<T> {

	@Override
	public int part(T[] array, int start, int end) {
		T pivot = array[start];
		int i = start - 1;
		int j = end + 1;
		while (true) {
			do {
				j--;
			} while (pivot.compareTo(array[j]) < 0);

			do {
				i++;
			} while (pivot.compareTo(array[i]) > 0);

			if (i < j) {
				swap(array, i, j);
			} else {
				return j;
			}
		}
	}

	@Override
	public int partDescending(T[] array, int start, int end) {
		T pivot = array[start];
		int i = start - 1;
		int j = end + 1;
		while (true) {
			do {
				j--;
			} while (pivot.compareTo(array[j]) > 0);

			do {
				i++;
			} while (pivot.compareTo(array[i]) < 0);

			if (i < j) {
				swap(array, i, j);
			} else {
				return j;
			}
		}
	}

}
