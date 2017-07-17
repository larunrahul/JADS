package com.learning.ads.datastructure.queue;

import java.util.Arrays;

import com.learning.ads.datastructure.heap.MaxHeap;
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

	public void increaseKey(int node, int key) {
		Heap heap = maxHeap.getHeap();
		int[] array = heap.array;
		if (key < array[node]) {
			throw new RuntimeException("New key is less than existing key");
		}
		array[node] = key;
		while (node > 0 && array[maxHeap.parent(node)] < array[node]) {
			int temp = array[maxHeap.parent(node)];
			array[maxHeap.parent(node)] = array[node];
			array[node] = temp;
			node = maxHeap.parent(node);
		}
	}

	public void heapInsert(int key) {
		Heap heap = maxHeap.getHeap();
		heap.heapSize += 1;
		heap.array[heap.heapSize] = Integer.MIN_VALUE;
		increaseKey(heap.heapSize, key);
	}
	
	public void heapDelete(int position){
		Heap heap = maxHeap.getHeap();
		int[] array = heap.array;
		int temp = array[position];
		array[position] = array[heap.heapSize];
		array[heap.heapSize] = temp;
		heap.heapSize -= 1;
		if(array[position] > array[maxHeap.parent(position)]){
			increaseKey(position, array[position]);
		}else {
			maxHeap.heapify(position);
		}
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
		int[] a1 = {25,20,16,10,18,9,13,1,2,17};
		queue = new MaxPriorityQueue(a1);
		System.out.println(queue.maxHeap.getHeap().heapSize);
		queue.heapDelete(0);
		System.out.println(Arrays.toString(queue.maxHeap.getHeap().array));
		System.out.println(queue.maxHeap.getHeap().heapSize);
		queue.heapInsert(35);
		System.out.println(Arrays.toString(queue.maxHeap.getHeap().array));
		System.out.println(queue.maxHeap.getHeap().heapSize);
	}

}
