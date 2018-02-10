package com.learning.ads.search;

public class BinarySearch<T extends Comparable<T>> {

	public int search(T[] array, T element) {
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

	/**
	 * Get the first element which is bigger than or equal to element
	 * 
	 * @param array
	 * @param element
	 * @return
	 */
	public int getFirstBig(T[] array, T element) {
		int first = 0, last = array.length - 1;
		while (first < last) {
			int mid = (first + last) / 2;
			int r = element.compareTo(array[mid]);
			if (r > 0) {
				first = mid + 1;
			} else {
				last = mid;
			}
		}
		if (array[first].compareTo(element) < 0) {
			return -1;
		}
		return first;
	}

	/**
	 * Get the last element which is smaller than element
	 * 
	 * @param array
	 * @param element
	 * @return
	 */
	public int getLastSmall(T[] array, T element) {
		int first = 0, last = array.length - 1;
		while (first < last) {
			// this is a fix needed to avoid unlimited loop for 2 element array
			int mid = ((first + last) / 2) + 1;
			int r = array[mid].compareTo(element);
			if (r >= 0) {
				last = mid - 1;
			} else {
				first = mid;
			}
		}
		if (array[first].compareTo(element) >= 0) {
			return -1;
		}
		return first;
	}

}
