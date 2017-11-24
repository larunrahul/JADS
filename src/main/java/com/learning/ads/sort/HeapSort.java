package com.learning.ads.sort;

import com.learning.ads.datastructure.heap.MaxHeap;
import com.learning.ads.datastructure.heap.MinHeap;
import com.learning.ads.element.Heap;

public class HeapSort {

	public void sort(int[] array) {
		MaxHeap maxHeap = new MaxHeap(array);
		Heap heap = maxHeap.getHeap();
		array = heap.array;
		for (int i = array.length - 1; i >= 1; i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			heap.heapSize -= 1;
			maxHeap.heapify(0);
		}
	}

	public void sortDescending(int[] array) {
		MinHeap minHeap = new MinHeap(array);
		Heap heap = minHeap.getHeap();
		array = heap.array;
		for (int i = array.length - 1; i >= 1; i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			heap.heapSize -= 1;
			minHeap.heapify(0);
		}
	}

}
