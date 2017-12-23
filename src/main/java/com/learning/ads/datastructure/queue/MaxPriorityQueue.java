package com.learning.ads.datastructure.queue;

import java.util.Arrays;

import com.learning.ads.datastructure.heap.BinaryMaxHeap;
import com.learning.ads.element.BinaryHeapNode;

public class MaxPriorityQueue<T extends Comparable<T>> {

	private BinaryMaxHeap<T> binaryMaxHeap;

	private final T minValue;

	public MaxPriorityQueue(T[] array, T minValue) {
		this.binaryMaxHeap = new BinaryMaxHeap<T>(array);
		this.minValue = minValue;
	}

	public T maximum() {
		return binaryMaxHeap.getHeap().array[0];
	}

	public T extratMaximum() {
		BinaryHeapNode<T> heap = binaryMaxHeap.getHeap();
		if (heap.heapSize < 0) {
			throw new RuntimeException("Underflow");
		}
		T[] array = heap.array;
		T max = array[0];
		array[0] = array[heap.heapSize];
		heap.heapSize -= 1;
		binaryMaxHeap.heapify(0);
		return max;
	}

	public void increaseKey(int node, T key) {
		BinaryHeapNode<T> heap = binaryMaxHeap.getHeap();
		T[] array = heap.array;
		if (key.compareTo(array[node]) < 0) {
			throw new RuntimeException("New key is less than existing key");
		}
		array[node] = key;
		while (node > 0 && array[binaryMaxHeap.parent(node)].compareTo(array[node]) < 0) {
			T temp = array[binaryMaxHeap.parent(node)];
			array[binaryMaxHeap.parent(node)] = array[node];
			array[node] = temp;
			node = binaryMaxHeap.parent(node);
		}
	}

	public void heapInsert(T key) {
		BinaryHeapNode<T> heap = binaryMaxHeap.getHeap();
		heap.heapSize += 1;
		heap.array[heap.heapSize] = minValue;
		increaseKey(heap.heapSize, key);
	}

	public void heapDelete(int position) {
		BinaryHeapNode<T> heap = binaryMaxHeap.getHeap();
		T[] array = heap.array;
		T temp = array[position];
		array[position] = array[heap.heapSize];
		array[heap.heapSize] = temp;
		heap.heapSize -= 1;
		if (array[position].compareTo(array[binaryMaxHeap.parent(position)]) > 0) {
			increaseKey(position, array[position]);
		} else {
			binaryMaxHeap.heapify(position);
		}
	}

	public static void main(String[] args) {
		Integer[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		System.out.println(Arrays.toString(array));
		MaxPriorityQueue<Integer> queue = new MaxPriorityQueue<>(array, Integer.MIN_VALUE);
		System.out.println(Arrays.toString(array));
		System.out.println(queue.extratMaximum());
		System.out.println(Arrays.toString(array));
		queue.heapInsert(15);
		System.out.println(Arrays.toString(array));
		Integer[] a1 = { 25, 20, 16, 10, 18, 9, 13, 1, 2, 17 };
		queue = new MaxPriorityQueue<Integer>(a1, Integer.MIN_VALUE);
		System.out.println(queue.binaryMaxHeap.getHeap().heapSize);
		queue.heapDelete(0);
		System.out.println(Arrays.toString(queue.binaryMaxHeap.getHeap().array));
		System.out.println(queue.binaryMaxHeap.getHeap().heapSize);
		queue.heapInsert(35);
		System.out.println(Arrays.toString(queue.binaryMaxHeap.getHeap().array));
		System.out.println(queue.binaryMaxHeap.getHeap().heapSize);
	}

}
