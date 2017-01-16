package com.learning.ads.sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void sort(int[] array){
		sort(array, 0, array.length - 1);
	}
	
	public static void sort(int[] array, int start, int end){
		if(start < end){
			int mid = LomutoPartition(array, start, end);
			sort(array, start, mid-1);
			sort(array, mid+1, end);
		}
	}
	
	public static int LomutoPartition(int[] array, int start, int end){
		int pivot = array[end];
		int i = start - 1;
		for(int j = start;j < end; j++){
			if(array[j] <= pivot){
				i += 1;
				swap(array, i, j);
			}
		}
		swap(array, i+1, end);
		return i+1;
	}
	
	private static void swap(int[] array, int start, int end){
		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}

	public static void main(String[] args) {
		int[] array = {2, 8, 7, 1, 3, 5, 6, 4};
		System.out.println(Arrays.toString(array));
		sort(array);
		System.out.println(Arrays.toString(array));
	}

}
