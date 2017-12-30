package com.learning.ads.datastructure.heap;

import com.learning.ads.element.heap.MultiaryHeapNode;

public class MultiaryMaxHeap<T extends Comparable<T>> {

	private MultiaryHeapNode<T> multiaryHeapNode;
	
	
	public MultiaryMaxHeap(T[] array, int cardinality) {
		MultiaryHeapNode<T> heap = new MultiaryHeapNode<>();
		heap.array = array;
		heap.heapSize = array.length;
		heap.cardinality = cardinality;
		this.multiaryHeapNode = heap;
		for (int i = array.length / cardinality - 1; i >= 0; i--) {
			this.heapify(i);
		}
	}

	public int parent(int index) {
		int cardinality = multiaryHeapNode.cardinality;
		return index == 0 ? index : (index % cardinality == 0 ? index / cardinality - 1 : index / cardinality);
	}

	public int child(int index, int position) {
		int cardinality = multiaryHeapNode.cardinality;
		if (position > cardinality) {
			throw new RuntimeException("Any node in this heap can have only " + cardinality + " children");
		}
		return cardinality * index + position;
	}

	public void heapify(int index) {
		int heapSize = multiaryHeapNode.heapSize;
		T[] array = multiaryHeapNode.array;
		int cardinality = multiaryHeapNode.cardinality;
		int largest = index;
		for (int position = 1; position <= cardinality; position++) {
			int childIndex = child(index, position);
			if (childIndex < heapSize && array[childIndex].compareTo(array[largest]) > 0) {
				largest = childIndex;
			}
		}
		if (largest != index) {
			T temp = array[index];
			array[index] = array[largest];
			array[largest] = temp;
			heapify(largest);
		}
	}
	
	public MultiaryHeapNode<T> getHeap() {
		return multiaryHeapNode;
	}

}
