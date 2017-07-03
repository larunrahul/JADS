package com.learning.ads.datastructure;

import java.util.Arrays;

import com.learning.ads.element.Heap;

public class MaxPriorityQueue {

	private MaxHeap maxHeap;

	public MaxPriorityQueue(int[] array) {
		this.maxHeap = new MaxHeap(array);
	}

	public int maximum() {
		return maxHeap.getHeap().array[0];
	}

	public int extratMaximum() {
		Heap heap = maxHeap.getHeap();
		if (heap.heapSize < 0) {
			throw new RuntimeException("Underflow");
		}
		int[] array = heap.array;
		int max = array[0];
		array[0] = array[heap.heapSize];
		heap.heapSize -= 1;
		maxHeap.heapify(0);
		return max;
	}

	public void increaseKey(int key) {
		Heap heap = maxHeap.getHeap();
		int[] array = heap.array;
		int i = heap.heapSize;
		if (key < array[i]) {
			throw new RuntimeException("New key is less than existing key");
		}
		array[i] = key;
		while (i > 0 && array[maxHeap.parent(i)] < array[i]) {
			int temp = array[maxHeap.parent(i)];
			array[maxHeap.parent(i)] = array[i];
			array[i] = temp;
			i = maxHeap.parent(i);
		}
	}

	public void heapInsert(int key) {
		Heap heap = maxHeap.getHeap();
		heap.heapSize += 1;
		heap.array[heap.heapSize] = Integer.MIN_VALUE;
		increaseKey(key);
	}

	public static void main(String[] args) {
		int[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		System.out.println(Arrays.toString(array));
		MaxPriorityQueue queue = new MaxPriorityQueue(array);
		System.out.println(Arrays.toString(array));
		System.out.println(queue.extratMaximum());
		System.out.println(Arrays.toString(array));
		queue.heapInsert(15);
		System.out.println(Arrays.toString(array));
	}

}