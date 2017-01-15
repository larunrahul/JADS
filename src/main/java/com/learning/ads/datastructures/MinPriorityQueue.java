package com.learning.ads.datastructures;

import java.util.Arrays;

import com.learning.ads.element.Heap;
import com.learning.ads.sort.heap.BottomUpHeap;

public class MinPriorityQueue {
	
	public Heap heap;
	
	public MinPriorityQueue(int[] array){
		this.heap = BottomUpHeap.buildMinHeap(array);
	}
	
	public int minimum(){
		return heap.array[0];
	}
	
	public int extratMinimum(){
		if(heap.heapSize < 0){
			throw new RuntimeException("Underflow");
		}
		int[] array = heap.array;
		int min = array[0];
		array[0] = array[heap.heapSize];
		heap.heapSize -= 1;
		BottomUpHeap.minHeapify(heap, 0);
		return min;
	}
	
	public void increaseKey(Heap heap, int key){
		int[] array = heap.array;
		int i = heap.heapSize;
		if(key < array[i]){
			throw new RuntimeException("New key is less than existing key");
		}
		array[i] = key;
		while(i > 0 && array[BottomUpHeap.parent(i)] > array[i]){
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
		MinPriorityQueue queue = new MinPriorityQueue(array);
		System.out.println(Arrays.toString(array));
		System.out.println(queue.extratMinimum());
		System.out.println(Arrays.toString(array));
		queue.heapInsert(queue.heap, 1);
		System.out.println(Arrays.toString(array));
		
	}
	
	

}
