package com.learning.ads.sort;

import java.util.Arrays;

/**
 * Selection sort
 * Complexity : O(n^2)
 * @author rahul
 *
 */
public class SelectionSort {
	
	/**
	 * Selection sort
	 * @param array
	 */
	public static void sort(int[] array){
		/*
		 * we don't need to iterate the last element. 
		 * That must be the shortest of remaining(just kidding, no elements were left) that is longest of all.
		 */
		for(int i = 0; i < array.length-1; i++){
			int smallestIndex = i;
			for(int j = i+1; j < array.length; j++){
				if(array[j] < array[smallestIndex]){
					smallestIndex = j;
				}
			}
			/*
			 * If we use temp variable to swap the elements, then we don't need to check below condition
			 * If we chose XOR(as below), if smallest element is the current element (which is array[i]), then XOR makes it 0.
			 * Hence we need to check the below condition.
			 */
			if(smallestIndex != i){
				array[i] = array[i] ^ array[smallestIndex];
				array[smallestIndex] = array[i] ^ array[smallestIndex];
				array[i] = array[i] ^ array[smallestIndex];
			}
		}
	}
	

	public static void main(String[] args) {
		int[] array = {2,5,2,37,3,1,7,4,9,6,10};
		System.out.println("unsorted array \t\t\t: "+Arrays.toString(array));
		sort(array);
		System.out.println("ascendingly sorted array \t: "+Arrays.toString(array));
	}

}
