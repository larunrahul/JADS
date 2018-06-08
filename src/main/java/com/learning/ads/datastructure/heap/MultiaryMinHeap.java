package com.learning.ads.datastructure.heap;

import com.learning.ads.datastructure.heap.element.MultiaryHeapHolder;

public class MultiaryMinHeap<T extends Comparable<T>> {

private MultiaryHeapHolder<T> multiaryHeapHolder;
	
	
	public MultiaryMinHeap(T[] array, int cardinality) {
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
		int smallest = index;
		for(int position = 1; position <= cardinality; position++) {
			int child = child(index, position);
			if(child < heapSize && array[child].compareTo(array[smallest]) < 0) {
				smallest = child;
			}
		}
		if (smallest != index) {
			T temp = array[index];
			array[index] = array[smallest];
			array[smallest] = temp;
			heapify(smallest);
		}
	}
	
	public MultiaryHeapHolder<T> getHeap(){
		return multiaryHeapHolder;
	}
	
}
