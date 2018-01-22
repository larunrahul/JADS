package com.learning.ads.sort.quick;

import com.learning.ads.sort.quick.partition.Partition;

public class HoareQSort<T extends Comparable<T>, P extends Partition<T>> extends QSort<T, P> {

	public HoareQSort(P partition) {
		super(partition);
	}

	protected void sort(T[] array, int start, int end) {
		if (start < end) {
			int mid = partition.part(array, start, end);
			sort(array, start, mid);
			sort(array, mid + 1, end);
		}
	}

	protected void sortDescending(T[] array, int start, int end) {
		if (start < end) {
			int mid = partition.partDescending(array, start, end);
			sortDescending(array, start, mid);
			sortDescending(array, mid + 1, end);
		}
	}

}
