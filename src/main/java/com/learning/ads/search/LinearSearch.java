package com.learning.ads.search;

/**
 * Simple linear search algorithm
 * @author rahul
 *
 */
public class LinearSearch {
	
	public int search(int[] array, int element){
		for(int i = 0; i < array.length; i++){
			if(array[i] == element){
				return i+1;
			}
		}
		throw new RuntimeException("Element not found exception");
	}

}
