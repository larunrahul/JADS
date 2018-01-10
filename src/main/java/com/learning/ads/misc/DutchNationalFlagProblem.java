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
				swap(array, low, high);
				high--;
			}
		}
	}

	public void triColor(int[] array) {
		int low = 0, mid = 0, high = array.length - 1;
		while (mid <= high) {
			if (array[mid] == 0) {
				swap(array, mid, low);
				low++;
				mid++;
			} else if (array[mid] == 1) {
				mid++;
			} else if (array[mid] == 2) {
				swap(array, mid, high);
				high--;
			}
		}
	}

	private void swap(int[] array, int first, int second) {
		if (array[first] != array[second]) {
			int temp = array[second];
			array[second] = array[first];
			array[first] = temp;
		}
	}

}
