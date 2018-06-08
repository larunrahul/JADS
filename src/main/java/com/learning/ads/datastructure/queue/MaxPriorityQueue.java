package com.learning.ads.datastructure.queue;

import com.learning.ads.datastructure.heap.BinaryMaxHeap;
import com.learning.ads.datastructure.heap.element.BinaryHeapHolder;

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
		BinaryHeapHolder<T> heap = binaryMaxHeap.getHeap();
		if (heap.heapSize <= 0) {
			throw new RuntimeException("Underflow");
		}
		T[] array = heap.array;
		T max = array[0];
		array[0] = array[heap.heapSize - 1];
		heap.heapSize -= 1;
		binaryMaxHeap.heapify(0);
		return max;
	}

	public void increaseKey(int node, T key) {
		BinaryHeapHolder<T> heap = binaryMaxHeap.getHeap();
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
		BinaryHeapHolder<T> heap = binaryMaxHeap.getHeap();
		heap.heapSize += 1;
		heap.array[heap.heapSize - 1] = minValue;
		increaseKey(heap.heapSize - 1, key);
	}

	public void heapDelete(int position) {
		BinaryHeapHolder<T> heap = binaryMaxHeap.getHeap();
		T[] array = heap.array;
		T temp = array[position];
		array[position] = array[heap.heapSize - 1];
		array[heap.heapSize - 1] = temp;
		heap.heapSize -= 1;
		if (array[position].compareTo(array[binaryMaxHeap.parent(position)]) > 0) {
			increaseKey(position, array[position]);
		} else {
			binaryMaxHeap.heapify(position);
		}
	}

	public int getQueueLength() {
		return binaryMaxHeap.getHeap().heapSize;
	}

}
