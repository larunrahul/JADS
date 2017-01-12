package com.learning.ads.sort.heap;

import java.util.Arrays;

import com.learning.ads.element.Heap;

public class BottomUpHeap {
	
	/*
	 * If it is zeroth node, itself is the parent for it.
	 * If it is even node, its parent is one before its division by 2, else its division by 2
	 * Ex : 
	 * 		parent(0) = 0
	 * 		parent(1) = 1/2  = 0
	 * 		parent(2) = 2/2 - 1 = 0
	 * 		parent(3) = 3/2 = 1
	 * 		parent(4) = 4/2 -1 = 1
	 * 		parent(5) = 5/2 = 2
	 * 		parent(6) = 6/2 - 1 = 2 
	 * 
	 */
	public static int parent(int i){
		return i == 0 ? i : (i%2 == 0 ? i/2-1 : i/2);
	}
	
	/*
	 * Left child can be found at exactly one more than twice the index
	 */
	public static int leftChild(int i){
		return 2*i + 1;
	}
	
	/*
	 * Left child can be found at exactly two more than twice the index
	 */
	public static int rightChild(int i){
		return 2*i + 2;
	}
	
	/*
	 * This runs so long as the height of the heap tree.
	 * As height is O(lg n) it is O(h) where n is number of elements and h is height of heap tree
	 * The above is not tight bound.
	 * Tight bound is O(n) - For more information, look in CLRS 
	 */
	public static void maxHeapify(Heap heap, int i){
		int heapSize = heap.heapSize;
		int[] array = heap.array;
		int leftChild = leftChild(i);
		int rightChild = rightChild(i);
		int largest = i;
		if(leftChild <= heapSize && array[leftChild] > array[i]){
			largest = leftChild;
		}
		if(rightChild <= heapSize && array[rightChild] > array[largest]){
			largest = rightChild;
		}
		if(largest != i){
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			maxHeapify(heap, largest);
		}
	}
	
	/*
	 * Bottom up construction of heap.
	 * Elements from half to end are all leaves of heap tree.
	 * Hence we need to start from the parent of last leaf(which is the element before mid element) and construct in upward fashion
	 */
	public static Heap buildMaxHeap(int[] array){
		Heap heap = new Heap();
		heap.array = array;
		heap.heapSize = array.length - 1;
		for(int i = array.length/2 - 1; i >= 0; i--){
			maxHeapify(heap, i);
		}
		return heap;
	}
	
	public static void heapSort(int[] array){
		Heap heap = buildMaxHeap(array);
		array = heap.array;
		for(int i = array.length - 1; i >= 1; i--){
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			heap.heapSize -= 1;
			maxHeapify(heap, 0);
		}
	}
	
	/*
	 * This runs so long as the height of the heap tree.
	 * As height is O(lg n) it is O(h) where n is number of elements and h is height of heap tree
	 * The above is not tight bound.
	 * Tight bound is O(n) - For more information, look in CLRS 
	 */
	public static void minHeapify(Heap heap, int i){
		int heapSize = heap.heapSize;
		int[] array = heap.array;
		int leftChild = leftChild(i);
		int rightChild = rightChild(i);
		int smallest = i;
		if(leftChild <= heapSize && array[leftChild] < array[i]){
			smallest = leftChild;
		}
		if(rightChild <= heapSize && array[rightChild] < array[smallest]){
			smallest = rightChild;
		}
		if(smallest != i){
			int temp = array[i];
			array[i] = array[smallest];
			array[smallest] = temp;
			minHeapify(heap, smallest);
		}
	}
	
	/*
	 * Bottom up construction of heap.
	 * Elements from half to end are all leaves of heap tree.
	 * Hence we need to start from the parent of last leaf(which is the element before mid element) and construct in upward fashion
	 */
	public static Heap buildMinHeap(int[] array){
		Heap heap = new Heap();
		heap.array = array;
		heap.heapSize = array.length - 1;
		for(int i = array.length/2 - 1; i >= 0; i--){
			minHeapify(heap, i);
		}
		return heap;
	}
	
	public static void heapSortDescending(int[] array){
		Heap heap = buildMinHeap(array);
		array = heap.array;
		for(int i = array.length - 1; i >= 1; i--){
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			heap.heapSize -= 1;
			minHeapify(heap, 0);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		System.out.println(Arrays.toString(array));
		heapSort(array);
		System.out.println(Arrays.toString(array));
		heapSortDescending(array);
		System.out.println(Arrays.toString(array));
	}
	
}
