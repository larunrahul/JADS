package com.learning.ads.datastructure.heap.element;

public class BinaryHeapHolder<T extends Comparable<T>> {
	public T[] array;
	public int heapSize;

	public BinaryHeapHolder(T[] array) {
		this.array = array;
		this.heapSize = array.length;
	}

	public T[] getArray() {
		return array;
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}
}
