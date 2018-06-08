package com.learning.ads.sort.heap;

import com.learning.ads.datastructure.heap.MultiaryMaxHeap;
import com.learning.ads.datastructure.heap.MultiaryMinHeap;
import com.learning.ads.datastructure.heap.element.MultiaryHeapHolder;

public class MultiaryHeapSort<T extends Comparable<T>> {
	
	private int cardinality;
	
	public MultiaryHeapSort(int cardinality) {
		this.cardinality = cardinality;
	}

	public void sort(T[] array) {
		MultiaryMaxHeap<T> maxHeap = new MultiaryMaxHeap<>(array, cardinality);
		MultiaryHeapHolder<T> heap = maxHeap.getHeap();
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
		MultiaryMinHeap<T> minHeap = new MultiaryMinHeap<>(array, cardinality);
		MultiaryHeapHolder<T> heap = minHeap.getHeap();
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
