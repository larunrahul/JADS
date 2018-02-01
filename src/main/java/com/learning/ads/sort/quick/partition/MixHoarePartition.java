package com.learning.ads.sort.quick.partition;

/**
 * This partition uses the same idea as that of the Hoare Partition, but unlike
 * Hoare partition and like Lomuto partition by the end of partition pivot is
 * placed at correct position
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class MixHoarePartition<T extends Comparable<T>> implements Partition<T> {

	@Override
	public int part(T[] array, int start, int end) {
		T pivot = array[start];
		int i = start;
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
				break;
			}
		}
		swap(array, start, j);
		return j;
	}

	@Override
	public int partDescending(T[] array, int start, int end) {
		T pivot = array[start];
		int i = start;
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
				break;
			}
		}
		swap(array, start, j);
		return j;
	}

}
