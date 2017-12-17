package com.learning.ads.sort;

import com.learning.ads.datastructure.heap.MaxHeap;
import com.learning.ads.datastructure.heap.MinHeap;
import com.learning.ads.element.Heap;

public class HeapSort<T extends Comparable<T>> {

	public void sort(T[] array) {
		MaxHeap<T> maxHeap = new MaxHeap<>(array);
		Heap<T> heap = maxHeap.getHeap();
		array = heap.array;
		for (int i = array.length - 1; i >= 1; i--) {
			T temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			heap.heapSize -= 1;
			maxHeap.heapify(0);
		}
	}

	public void sortDescending(T[] array) {
		MinHeap<T> minHeap = new MinHeap<>(array);
		Heap<T> heap = minHeap.getHeap();
		array = heap.array;
		for (int i = array.length - 1; i >= 1; i--) {
			T temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			heap.heapSize -= 1;
			minHeap.heapify(0);
		}
	}

}
