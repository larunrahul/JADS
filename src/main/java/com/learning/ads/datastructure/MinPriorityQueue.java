package com.learning.ads.datastructure;

import java.util.Arrays;

import com.learning.ads.element.Heap;

public class MinPriorityQueue {

	private MinHeap minHeap;

	public MinPriorityQueue(int[] array) {
		this.minHeap = new MinHeap(array);
	}

	public int minimum() {
		return minHeap.getHeap().array[0];
	}

	public int extratMinimum() {
		Heap heap = minHeap.getHeap();
		if (heap.heapSize < 0) {
			throw new RuntimeException("Underflow");
		}
		int[] array = heap.array;
		int min = array[0];
		array[0] = array[heap.heapSize];
		heap.heapSize -= 1;
		minHeap.heapify(0);
		return min;
	}

	public void increaseKey(int key) {
		Heap heap = minHeap.getHeap();
		int[] array = heap.array;
		int i = heap.heapSize;
		if (key < array[i]) {
			throw new RuntimeException("New key is less than existing key");
		}
		array[i] = key;
		while (i > 0 && array[minHeap.parent(i)] > array[i]) {
			int temp = array[minHeap.parent(i)];
			array[minHeap.parent(i)] = array[i];
			array[i] = temp;
			i = minHeap.parent(i);
		}
	}

	public void heapInsert(int key) {
		Heap heap = minHeap.getHeap();
		heap.heapSize += 1;
		heap.array[heap.heapSize] = Integer.MIN_VALUE;
		increaseKey(key);
	}

	public static void main(String[] args) {
		int[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		System.out.println(Arrays.toString(array));
		MinPriorityQueue queue = new MinPriorityQueue(array);
		System.out.println(Arrays.toString(array));
		System.out.println(queue.extratMinimum());
		System.out.println(Arrays.toString(array));
		queue.heapInsert(1);
		System.out.println(Arrays.toString(array));
	}

}
