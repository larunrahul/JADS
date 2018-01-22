package com.learning.ads.sort.quick;

import com.learning.ads.sort.quick.partition.Partition;

public class QSort<T extends Comparable<T>, P extends Partition<T>> {

	protected P partition;

	public QSort(P partition) {
		this.partition = partition;
	}

	public void sort(T[] array) {
		sort(array, 0, array.length - 1);
	}

	public void sortDescending(T[] array) {
		sortDescending(array, 0, array.length - 1);
	}

	protected void sort(T[] array, int start, int end) {
		if (start < end) {
			int mid = partition.part(array, start, end);
			sort(array, start, mid - 1);
			sort(array, mid + 1, end);
		}
	}

	protected void sortDescending(T[] array, int start, int end) {
		if (start < end) {
			int mid = partition.partDescending(array, start, end);
			sortDescending(array, start, mid - 1);
			sortDescending(array, mid + 1, end);
		}
	}

	protected void swap(T[] array, int start, int end) {
		T temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}
}
