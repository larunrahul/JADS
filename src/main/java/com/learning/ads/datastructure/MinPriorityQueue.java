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

	public void decreaseKey(int node, int key) {
		Heap heap = minHeap.getHeap();
		int[] array = heap.array;
		if (key > array[node]) {
			throw new RuntimeException("New key is greater than existing key");
		}
		array[node] = key;
		while (node > 0 && array[minHeap.parent(node)] > array[node]) {
			int temp = array[minHeap.parent(node)];
			array[minHeap.parent(node)] = array[node];
			array[node] = temp;
			node = minHeap.parent(node);
		}
	}

	public void heapInsert(int key) {
		Heap heap = minHeap.getHeap();
		heap.heapSize += 1;
		heap.array[heap.heapSize] = Integer.MAX_VALUE;
		decreaseKey(heap.heapSize, key);
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
