package com.learning.ads.sort.heap;

import com.learning.ads.datastructure.element.heap.BinaryHeapNode;
import com.learning.ads.datastructure.heap.BinaryMaxHeap;
import com.learning.ads.datastructure.heap.BinaryMinHeap;

public class BinaryHeapSort<T extends Comparable<T>> {

	public void sort(T[] array) {
		BinaryMaxHeap<T> maxHeap = new BinaryMaxHeap<>(array);
		BinaryHeapNode<T> heap = maxHeap.getHeap();
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
		BinaryMinHeap<T> minHeap = new BinaryMinHeap<>(array);
		BinaryHeapNode<T> heap = minHeap.getHeap();
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
