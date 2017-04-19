package com.learning.ads.sort;

import java.util.Arrays;

import com.learning.ads.datastructure.MaxHeap;
import com.learning.ads.datastructure.MinHeap;
import com.learning.ads.element.Heap;

public class HeapSort {

	public static void heapSort(int[] array) {
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

	public static void heapSortDescending(int[] array) {
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

	public static void main(String[] args) {
		int[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		System.out.println(Arrays.toString(array));
		heapSort(array);
		System.out.println(Arrays.toString(array));
		heapSortDescending(array);
		System.out.println(Arrays.toString(array));
	}

}
