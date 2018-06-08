package com.learning.ads.datastructure.heap;

import com.learning.ads.datastructure.heap.element.MultiaryHeapHolder;

public class MultiaryMaxHeap<T extends Comparable<T>> {

	private MultiaryHeapHolder<T> multiaryHeapHolder;
	
	
	public MultiaryMaxHeap(T[] array, int cardinality) {
		MultiaryHeapHolder<T> heap = new MultiaryHeapHolder<>();
		heap.array = array;
		heap.heapSize = array.length;
		heap.cardinality = cardinality;
		this.multiaryHeapHolder = heap;
		for (int i = array.length / cardinality - 1; i >= 0; i--) {
			this.heapify(i);
		}
	}

	public int parent(int index) {
		int cardinality = multiaryHeapHolder.cardinality;
		return index == 0 ? index : (index % cardinality == 0 ? index / cardinality - 1 : index / cardinality);
	}

	public int child(int index, int position) {
		int cardinality = multiaryHeapHolder.cardinality;
		if (position > cardinality) {
			throw new RuntimeException("Any node in this heap can have only " + cardinality + " children");
		}
		return cardinality * index + position;
	}

	public void heapify(int index) {
		int heapSize = multiaryHeapHolder.heapSize;
		T[] array = multiaryHeapHolder.array;
		int cardinality = multiaryHeapHolder.cardinality;
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
	
	public MultiaryHeapHolder<T> getHeap() {
		return multiaryHeapHolder;
	}

}
