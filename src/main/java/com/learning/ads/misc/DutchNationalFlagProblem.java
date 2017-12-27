package com.learning.ads.misc;

/**
 * http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
 * 
 * @author Arun Rahul
 *
 */
public class DutchNationalFlagProblem {
	public void biColor(int[] array) {
		int low = 0, high = array.length - 1;
		while (low < high) {
			if (array[low] == 0) {
				low++;
			} else {
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
				high--;
			}
		}
	}

	public void triColor(int[] array) {
		int low = 0, mid = 0, high = array.length - 1;
		while (mid <= high) {
			if (array[mid] == 1) {
				mid++;
			} else if (array[mid] == 0) {
				int temp = array[mid];
				array[mid] = array[low];
				array[low] = temp;
				low++;
				mid++;
			} else if (array[mid] == 2) {
				int temp = array[high];
				array[high] = array[mid];
				array[mid] = temp;
				high--;
			}
		}
	}
}
