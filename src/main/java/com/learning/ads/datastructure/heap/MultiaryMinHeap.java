package com.learning.ads.datastructure.heap;

import com.learning.ads.element.MultiaryHeapNode;

public class MultiaryMinHeap<T extends Comparable<T>> {

private MultiaryHeapNode<T> multiaryHeapNode;
	
	
	public MultiaryMinHeap(T[] array, int cardinality) {
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
	
	public MultiaryHeapNode<T> getHeap(){
		return multiaryHeapNode;
	}
	
}
