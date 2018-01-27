package com.learning.ads.sort.quick;

import com.learning.ads.sort.quick.partition.Partition;

/**
 * This algorithm uses insertion sort when array is "almost" sorted.
 * 
 * Procedure: In quick sort, for each recursive / top-level(when array size is
 * less than "k") call which is running on sub-array with size less than "k", we
 * return it instead of sorting. Once top-level call to quick sort (public sort,
 * public sortDescending methods in below code) is returned, we run insertion
 * sort on the "whole array".
 * 
 * Complexity: Since we return quick sort when the sub array size is less than
 * or equal to "k", our recursion tree contains log(n)-log(k) levels and each
 * level consumes O(n) time for partition. Hence, it amounts to O(n log(n/k)).
 * Now, after this process is done, we are applying insertion sort in which
 * outer loop runs for n times and inner loop runs at max k for each outer loop
 * iteration. Hence, it amounts to O(nk).
 * 
 * Total time complexity : O(nk + nlog(n/k))
 * 
 * @author Arun Rahul
 *
 * @param <T>
 * @param <P>
 */
public class QuickSortWithInsertionSort<T extends Comparable<T>, P extends Partition<T>> extends QSort<T, P> {

	private static final int THRESHOLD = 4; // This could be any integer based on situation

	public QuickSortWithInsertionSort(P partition) {
		super(partition);
	}

	public void sort(T[] array) {
		sort(array, 0, array.length - 1);
		insertionSort(array, 0, array.length - 1);
	}

	protected void sort(T[] array, int start, int end) {
		if (start < end) {
			if (end - start > THRESHOLD) {
				int mid = partition.part(array, start, end);
				sort(array, start, mid - 1);
				sort(array, mid + 1, end);
			}
		}
	}

	private void insertionSort(T[] array, int start, int end) {
		for (int index = start + 1; index <= end; index++) {
			T key = array[index];
			int sortedIndex = index - 1;
			while (sortedIndex >= start && array[sortedIndex].compareTo(key) > 0) {
				array[sortedIndex + 1] = array[sortedIndex];
				sortedIndex -= 1;
			}
			array[sortedIndex + 1] = key;
		}
	}

	public void sortDescending(T[] array) {
		sortDescending(array, 0, array.length - 1);
		insertionSortDescending(array, 0, array.length - 1);
	}

	protected void sortDescending(T[] array, int start, int end) {
		if (start < end) {
			if (end - start > THRESHOLD) {
				int mid = partition.partDescending(array, start, end);
				sortDescending(array, start, mid);
				sortDescending(array, mid + 1, end);
			}
		}
	}

	private void insertionSortDescending(T[] array, int start, int end) {
		for (int index = start + 1; index <= end; index++) {
			T key = array[index];
			int sortedIndex = index - 1;
			while (sortedIndex >= start && array[sortedIndex].compareTo(key) < 0) {
				array[sortedIndex + 1] = array[sortedIndex];
				sortedIndex -= 1;
			}
			array[sortedIndex + 1] = key;
		}
	}

}
