package com.learning.ads.sort.quick;

import com.learning.ads.sort.quick.partition.Partition;

/**
 * The partition method used in this, are nothing but Dutch National Flag
 * problem popularized by Dijkstra.
 * 
 * https://github.com/larunrahul/JADS/blob/master/src/main/java/com/learning/ads/misc/DutchNationalFlagProblem.java
 * 
 * @author Arun Rahul
 *
 * @param <T>
 * @param <P>
 */
public class PartitionWithEqualElementsDNF<T extends Comparable<T>, P extends Partition<T>> extends QSort<T, P> {

	public PartitionWithEqualElementsDNF(P partition) {
		super(partition);
	}

	/**
	 * If lot of elements in array are same, then this sort performs well
	 * Complexity: O(n)
	 */
	protected void sort(T[] array, int start, int end) {
		if (start < end) {
			int low = start, mid = start, high = end;
			T pivot = array[start];
			while (mid <= high) {
				int result = array[mid].compareTo(pivot);
				if (result < 0) {
					swap(array, mid, low);
					mid++;
					low++;
				} else if (result == 0) {
					mid++;
				} else {
					swap(array, mid, high);
					high--;
				}
			}
			sort(array, start, low - 1);
			sort(array, high + 1, end);
		}
	}

	/**
	 * If lot of elements in array are same, then this sort performs well
	 * Complexity: O(n)
	 */
	protected void sortDescending(T[] array, int start, int end) {
		if (start < end) {
			if (start < end) {
				int low = start, mid = start, high = end;
				T pivot = array[start];
				while (mid <= high) {
					int result = array[mid].compareTo(pivot);
					if (result > 0) {
						swap(array, mid, low);
						mid++;
						low++;
					} else if (result == 0) {
						mid++;
					} else {
						swap(array, mid, high);
						high--;
					}
				}
				sortDescending(array, start, low - 1);
				sortDescending(array, high + 1, end);
			}
		}
	}

}
