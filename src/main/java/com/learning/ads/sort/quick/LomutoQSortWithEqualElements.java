package com.learning.ads.sort.quick;

import com.learning.ads.sort.quick.partition.LomutoPartition;
import com.learning.ads.sort.quick.partition.Partition;

public class LomutoQSortWithEqualElements<T extends Comparable<T>, P extends Partition<T>> extends QSort<T, P> {

	private Partition<T> lomutoPartition = new LomutoPartition<>();

	public LomutoQSortWithEqualElements(P partition) {
		super(partition);
	}

	/**
	 * If lot of elements in array are same, then this sort performs well
	 * Complexity: O(n)
	 */
	protected void sort(T[] array, int start, int end) {
		if (start < end) {
			int mid = lomutoPartition.part(array, start, end);
			int k = mid - 1, i = mid;
			while (k >= start) {
				if (array[k].compareTo(array[mid]) == 0) {
					i--;
					swap(array, i, k);
				}
				k--;
			}
			sort(array, start, i - 1);
			sort(array, mid + 1, end);
		}
	}

	/**
	 * If lot of elements in array are same, then this sort performs well
	 * Complexity: O(n)
	 */
	protected void sortDescending(T[] array, int start, int end) {
		if (start < end) {
			int mid = partition.partDescending(array, start, end);
			int k = mid - 1, i = mid;
			while (k >= start) {
				if (array[k].compareTo(array[mid]) == 0) {
					i--;
					swap(array, i, k);
				}
				k--;
			}
			sortDescending(array, start, i - 1);
			sortDescending(array, mid + 1, end);
		}
	}

}
