package com.learning.ads.sort;

public class MergeSort {

	public void sort(int[] array){
		mergeSort(array,0,array.length-1);
	}
	
	private void mergeSort(int[] array, int start, int end){
		if(start < end){
			int mid = (int)Math.floor((start+end)/2);
			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			merge(array, start, mid, end);
		}
	}
	
	private void merge(int[] array, int start, int mid, int end){
		int left = mid-start+1;
		int right = end-mid;
		int[] leftPile = new int[left+1];
		int[] rightPile = new int[right+1];
		int i,j;
		for(i = 0; i < left; i++){
			leftPile[i] = array[start+i];
		}
		leftPile[i] = Integer.MAX_VALUE;
		for(j = 0; j < right; j++){
			rightPile[j] = array[mid+j+1];
		}
		rightPile[j] = Integer.MAX_VALUE;
		i = 0;
		j = 0;
		for(int k = start; k <= end; k++){
			if(leftPile[i] <= rightPile[j]){
				array[k] = leftPile[i];
				i += 1;
			}else{
				array[k] = rightPile[j];
				j += 1;
			}
		}
	}

	public void print(int[] array){
		for(int i : array){
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] array = new int[]{9,8,7,6,5,4,3,2,1};
		mergeSort.print(array);
		mergeSort.sort(array);
		mergeSort.print(array);
	}

}
