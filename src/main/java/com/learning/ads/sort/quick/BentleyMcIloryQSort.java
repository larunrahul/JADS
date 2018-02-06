package com.learning.ads.sort.quick;

import com.learning.ads.sort.quick.partition.Partition;

/**
 * This algorithm is used prior to Java6.
 * 
 * Official publication:
 * http://pauillac.inria.fr/~maranget/X/421/09/bentley93engineering.pdf
 * 
 * Basic idea is to throw the elements equal to pivot to both ends of the array
 * and once partition is done, copy them back to the mid
 * 
 * @author Arun Rahul
 *
 * @param <T>
 * @param <P>
 */
public class BentleyMcIloryQSort<T extends Comparable<T>, P extends Partition<T>> extends QSort<T, P> {

	public BentleyMcIloryQSort(P partition) {
		super(partition);
	}

	protected void sort(T[] array, int start, int end) {
		if (start < end) {
			int a = start, b = start;
			int c = end, d = end;
			// chose the middle one as pivot. There are many other ways to chose pivot like
			// Turkey's Ninther.
			T pivot = array[(start + end) / 2];
			while (true) {
				int result = 0;
				while (b <= c && (result = array[b].compareTo(pivot)) <= 0) {
					if (result == 0) {
						swap(array, a++, b);
					}
					b++;
				}
				while (c >= b && (result = array[c].compareTo(pivot)) >= 0) {
					if (result == 0) {
						swap(array, d--, c);
					}
					c--;
				}
				if (b > c) {
					break;
				}
				swap(array, b++, c--);
			}
			int low = c;
			for (int i = start; i < a; i++) {
				swap(array, i, low--);
			}
			int high = b;
			for (int j = end; j > d; j--) {
				swap(array, high++, j);
			}
			sort(array, start, low);
			sort(array, high, end);
		}
	}

	protected void sortDescending(T[] array, int start, int end) {
		if (start < end) {
			int a = start, b = start;
			int c = end, d = end;
			// chose the middle one as pivot. There are many other ways to chose pivot like
			// Turkey's Ninther.
			T pivot = array[(start + end) / 2];
			while (true) {
				int result = 0;
				while (b <= c && (result = array[b].compareTo(pivot)) >= 0) {
					if (result == 0) {
						swap(array, a++, b);
					}
					b++;
				}
				while (c >= b && (result = array[c].compareTo(pivot)) <= 0) {
					if (result == 0) {
						swap(array, d--, c);
					}
					c--;
				}
				if (b > c) {
					break;
				}
				swap(array, b++, c--);
			}
			int low = c;
			for (int i = start; i < a; i++) {
				swap(array, i, low--);
			}
			int high = b;
			for (int j = end; j > d; j--) {
				swap(array, high++, j);
			}
			sortDescending(array, start, low);
			sortDescending(array, high, end);
		}
	}

}
