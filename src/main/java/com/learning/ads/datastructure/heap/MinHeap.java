package com.learning.ads.datastructure.heap;

import com.learning.ads.element.Heap;

public class MinHeap<T extends Comparable<T>> {
	
	private Heap<T> heap;
	
	/*
	 * Bottom up construction of heap. Elements from half to end are all leaves
	 * of heap tree. Hence we need to start from the parent of last leaf(which
	 * is the element before mid element) and construct in upward fashion
	 */
	public MinHeap(T[] array) {
		Heap<T> heap = new Heap<>();
		heap.array = array;
		heap.heapSize = array.length - 1;
		this.heap = heap;
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			this.heapify(i);
		}
	}
	/*
	 * If it is zeroth node, it is the parent for itself. If it is even node,
	 * its parent is one before its division by 2, else its division by 2 
	 * Example	:	parent(0) = 0
	 *  			parent(1) = 1/2 = 0 
	 *  			parent(2) = 2/2 - 1 = 0 
	 *  			parent(3) = 3/2 = 1
	 *  			parent(4) = 4/2 -1 = 1 parent(5) = 5/2 = 2 parent(6) = 6/2 - 1 = 2
	 */
	public int parent(int index) {
		return index == 0 ? index : (index % 2 == 0 ? index / 2 - 1 : index / 2);
	}

	/*
	 * Left child can be found at exactly one more than twice the index
	 */
	public int leftChild(int index) {
		return 2 * index + 1;
	}

	/*
	 * Left child can be found at exactly two more than twice the index
	 */
	public int rightChild(int index) {
		return 2 * index + 2;
	}

	/*
	 * This runs so long as the height of the heap tree. As height is O(lg n) it
	 * is O(h) where n is number of elements and h is height of heap tree The
	 * above is not tight bound. Tight bound is O(n) - For more information,
	 * look in CLRS
	 */
	public void heapify(int index) {
		int heapSize = heap.heapSize;
		T[] array = heap.array;
		int leftChild = leftChild(index);
		int rightChild = rightChild(index);
		int smallest = index;
		if (leftChild <= heapSize && array[leftChild].compareTo(array[index]) < 0) {
			smallest = leftChild;
		}
		if (rightChild <= heapSize && array[rightChild].compareTo(array[smallest]) < 0) {
			smallest = rightChild;
		}
		if (smallest != index) {
			T temp = array[index];
			array[index] = array[smallest];
			array[smallest] = temp;
			heapify(smallest);
		}
	}
	
	public Heap<T> getHeap() {
		return heap;
	}
	
}
