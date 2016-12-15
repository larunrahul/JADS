package com.learning.ads.sort;

public class InsertionSortDemo {
	
	public int[] array;
	
	private InsertionSortDemo(int[] array){
		this.array = array;
	}
	
	public void insertionSort(){
		for(int index = 1; index < array.length; index++){
			int key = array[index];
			int sortedIndex = index-1; 
			while(sortedIndex >= 0 && array[sortedIndex] > key){
				array[sortedIndex+1] = array[sortedIndex];
				sortedIndex-= 1;
			}
			array[sortedIndex+1] = key;
		}
	}
	
	public void print(){
		for(int i : array){
			System.out.print(i+"\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = {2,5,2,37,3,1,7,4,9,6,10};
		InsertionSortDemo insertionSortDemo = new InsertionSortDemo(array);
		insertionSortDemo.print();
		insertionSortDemo.insertionSort();
		insertionSortDemo.print();
	}

}
