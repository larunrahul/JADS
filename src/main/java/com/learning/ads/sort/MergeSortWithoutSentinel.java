package com.learning.ads.sort;

import java.util.Arrays;

public class MergeSortWithoutSentinel {

	public static void sort(int[] array){
		mergeSort(array,0,array.length-1);
	}
	
	private static void mergeSort(int[] array, int start, int end){
		if(start < end){
			int mid = (start+end)/2; 
			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			merge(array, start, mid, end);
		}
	}
	
	
	private static void merge(int[] array, int start, int mid, int end){
		int left = mid-start+1;
		int right = end-mid;
		int[] leftPile = new int[left];
		int[] rightPile = new int[right];
		int i,j;
		for(i = 0; i < left; i++){
			leftPile[i] = array[start+i];
		}
		for(j = 0; j < right; j++){
			rightPile[j] = array[mid+j+1];
		}
		i = 0;
		j = 0;
		int count = start;
		//iterate until both left and right pile didn't reach end. If at least one reaches the end, this loop terminates
		while(i < leftPile.length && j < rightPile.length){
			if(leftPile[i] <= rightPile[j]){
				array[count] = leftPile[i];
				i += 1;
			}else{
				array[count] = rightPile[j];
				j += 1;
			}
			count += 1;
		}
		//if left pile has reached the end, copy the remaining elements in right pile to array
		if(i == leftPile.length){
			while(j < rightPile.length){
				array[count] = rightPile[j];
				j += 1;
				count += 1;
			}
		}
		//if right pile has reached the end, copy the remaining elements in left pile to array
		else if(j == rightPile.length){
			while(i < leftPile.length){
				array[count] = leftPile[i];
				i += 1;
				count += 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{0,3,123,5,7,9,1,2,4,6,8,5,34,7};
		System.out.println("unsorted array \t\t\t: "+Arrays.toString(array));
		sort(array);
		System.out.println("sorted array \t\t\t: "+Arrays.toString(array));
		array = new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7, 2, 1};
		sort(array);
		System.out.println("sorted array \t\t\t: "+Arrays.toString(array));
	}

}
