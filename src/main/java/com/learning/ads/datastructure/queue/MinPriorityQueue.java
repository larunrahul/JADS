package com.learning.ads.datastructure.queue;

import java.util.Arrays;

import com.learning.ads.datastructure.heap.MinHeap;
import com.learning.ads.element.Heap;

public class MinPriorityQueue<T extends Comparable<T>> {

	private MinHeap<T> minHeap;

	private final T maxValue;

	public MinPriorityQueue(T[] array, T maxValue) {
		this.minHeap = new MinHeap<T>(array);
		this.maxValue = maxValue;
	}

	public T minimum() {
		return minHeap.getHeap().array[0];
	}

	public T extratMinimum() {
		Heap<T> heap = minHeap.getHeap();
		if (heap.heapSize < 0) {
			throw new RuntimeException("Underflow");
		}
		T[] array = heap.array;
		T min = array[0];
		array[0] = array[heap.heapSize];
		heap.heapSize -= 1;
		minHeap.heapify(0);
		return min;
	}

	public void decreaseKey(int node, T key) {
		Heap<T> heap = minHeap.getHeap();
		T[] array = heap.array;
		if (key.compareTo(array[node]) > 0) {
			throw new RuntimeException("New key is greater than existing key");
		}
		array[node] = key;
		while (node > 0 && array[minHeap.parent(node)].compareTo(array[node]) > 0) {
			T temp = array[minHeap.parent(node)];
			array[minHeap.parent(node)] = array[node];
			array[node] = temp;
			node = minHeap.parent(node);
		}
	}

	public void heapInsert(T key) {
		Heap<T> heap = minHeap.getHeap();
		heap.heapSize += 1;
		heap.array[heap.heapSize] = maxValue;
		decreaseKey(heap.heapSize, key);
	}

	public void heapDelete(int position) {
		Heap<T> heap = minHeap.getHeap();
		T[] array = heap.array;
		T temp = array[position];
		array[position] = array[heap.heapSize];
		array[heap.heapSize] = temp;
		heap.heapSize -= 1;
		if (array[position].compareTo(array[minHeap.parent(position)]) < 0) {
			decreaseKey(position, array[position]);
		} else {
			minHeap.heapify(position);
		}
	}

	public static void main(String[] args) {
		Integer[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		System.out.println(Arrays.toString(array));
		MinPriorityQueue<Integer> queue = new MinPriorityQueue<>(array, Integer.MAX_VALUE);
		System.out.println(Arrays.toString(array));
		System.out.println(queue.extratMinimum());
		System.out.println(Arrays.toString(array));
		queue.heapInsert(1);
		System.out.println(Arrays.toString(array));
		Integer[] a1 = { 25, 20, 16, 10, 18, 9, 13, 1, 2, 17 };
		queue = new MinPriorityQueue<>(a1, Integer.MAX_VALUE);
		System.out.println(queue.minHeap.getHeap().heapSize);
		queue.heapDelete(0);
		System.out.println(Arrays.toString(queue.minHeap.getHeap().array));
		System.out.println(queue.minHeap.getHeap().heapSize);
		queue.heapInsert(3);
		System.out.println(Arrays.toString(queue.minHeap.getHeap().array));
		System.out.println(queue.minHeap.getHeap().heapSize);
	}

}
