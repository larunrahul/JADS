package com.learning.ads.sort;

import java.util.Arrays;

/**
 * Implementation of Insertion sort 
 * @author rahul
 *
 */
public class InsertionSort {
	
	/**
	 * Ascending sort
	 */
	public static void sort(int[] array){
		
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
	
	/**
	 * Descending sort
	 */
	public static void reverseSort(int[] array){
		
		for(int index = 1; index < array.length; index++){
			int key = array[index];
			int sortedIndex = index-1; 
			while(sortedIndex >= 0 && key > array[sortedIndex]){
				array[sortedIndex+1] = array[sortedIndex];
				sortedIndex-= 1;
			}
			array[sortedIndex+1] = key;
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] array = {2,5,2,37,3,1,7,4,9,6,10};
		System.out.println("unsorted array \t\t\t: "+Arrays.toString(array));
		sort(array);
		System.out.println("ascendingly sorted array \t: "+Arrays.toString(array));
		int[] array1 = {2,5,2,37,3,1,7,4,9,6,10};
		System.out.println("unsorted array \t\t\t: "+Arrays.toString(array1));
		reverseSort(array1);
		System.out.println("descendingly sorted array \t: "+Arrays.toString(array1));
		
	}

}
