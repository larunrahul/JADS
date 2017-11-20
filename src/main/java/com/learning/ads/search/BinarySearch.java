package com.learning.ads.search;

public class BinarySearch {

	public <T extends Comparable<T>> int search(T[] array, T element) {
		int first = 0, last = array.length - 1, position = -1;
		while (first <= last) {
			int mid = (first + last) / 2;
			int r = element.compareTo(array[mid]);
			if (r == 0) {
				position = mid;
				break;
			}
			if (r == -1) {
				last = mid - 1;
			} else if (r == 1) {
				first = mid + 1;
			}
		}
		return position;
	}

}
