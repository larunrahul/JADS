package com.learning.ads.datastructures;

import java.util.Arrays;

import com.learning.ads.element.Heap;
import com.learning.ads.sort.heap.BottomUpHeap;

public class MaxPriorityQueue {
	
	public Heap heap;
	
	public MaxPriorityQueue(int[] array){
		this.heap = BottomUpHeap.buildMaxHeap(array);
	}
	
	public int maximum(){
		return heap.array[0];
	}
	
	public int extratMaximum(){
		if(heap.heapSize < 0){
			throw new RuntimeException("Underflow");
		}
		int[] array = heap.array;
		int max = array[0];
		array[0] = array[heap.heapSize];
		heap.heapSize -= 1;
		BottomUpHeap.maxHeapify(heap, 0);
		return max;
	}
	
	public void increaseKey(Heap heap, int key){
		int[] array = heap.array;
		int i = heap.heapSize;
		if(key < array[i]){
			throw new RuntimeException("New key is less than existing key");
		}
		array[i] = key;
		while(i > 0 && array[BottomUpHeap.parent(i)] < array[i]){
			int temp = array[BottomUpHeap.parent(i)];
			array[BottomUpHeap.parent(i)] = array[i];
			array[i] = temp;
			i = BottomUpHeap.parent(i);
		}
	}
	
	public void heapInsert(Heap heap, int key){
		heap.heapSize += 1;
		heap.array[heap.heapSize] = Integer.MIN_VALUE;
		increaseKey(heap, key);
	}
	
	

	public static void main(String[] args) {
		int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		System.out.println(Arrays.toString(array));
		MaxPriorityQueue queue = new MaxPriorityQueue(array);
		System.out.println(Arrays.toString(array));
		System.out.println(queue.extratMaximum());
		System.out.println(Arrays.toString(array));
		queue.heapInsert(queue.heap, 15);
		System.out.println(Arrays.toString(array));
	}
	
	

}
