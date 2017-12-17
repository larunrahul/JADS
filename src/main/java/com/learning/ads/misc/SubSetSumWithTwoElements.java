package com.learning.ads.misc;

import com.learning.ads.sort.HeapSort;

public class SubSetSumWithTwoElements {
	public boolean isSubsetPresentWithSum(Integer[] array, int sum) {
		HeapSort<Integer> hs = new HeapSort<>();
		hs.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int add = array[first] + array[last];
			if (add == sum) {
				return true;
			} else if (add < sum) {
				first++;
			} else {
				last--;
			}
		}
		return false;
	}
}
