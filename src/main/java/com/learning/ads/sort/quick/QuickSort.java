package com.learning.ads.sort.quick;

import com.learning.ads.sort.quick.partition.Partition;

public class QuickSort<T extends Comparable<T>, P extends Partition<T>> {

	private QSort<T, P> qSort;

	public QuickSort(QSort<T, P> qSort) {
		this.qSort = qSort;
	}

	public void sort(T[] array) {
		qSort.sort(array);
	}

	public void sortDescending(T[] array) {
		qSort.sortDescending(array);
	}

}
