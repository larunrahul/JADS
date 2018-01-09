package com.learning.ads.sort.quick;

public interface Partition<T extends Comparable<T>> {
	public int part(T[] array, int start, int end);

	public default void swap(T[] array, int start, int end) {
		T temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}
}
