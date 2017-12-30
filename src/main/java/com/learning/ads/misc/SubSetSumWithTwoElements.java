package com.learning.ads.misc;

import com.learning.ads.sort.heap.BinaryHeapSort;

public class SubSetSumWithTwoElements {
	public boolean isSubsetPresentWithSum(Integer[] array, int sum) {
		BinaryHeapSort<Integer> hs = new BinaryHeapSort<>();
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
