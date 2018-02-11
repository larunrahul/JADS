package com.learning.ads.search.binary;

import java.util.Arrays;

/*
 
 	https://stackoverflow.com/questions/28095662/algorithm-help-how-to-divide-array-into-n-segments-with-least-possible-largest
 	
	You have an array with N positive integers, you need to divide it into M contiguous segments, 
	so that the total of the largest segment is the smallest possible value. 
	By segment's total, we mean the sum of all its integers. 
	In other words, we want a well-balanced array segmentation, where you don't want a single segment to be too large.
	Example:
		Array: [4, 7, 12, 5, 3, 16]
		M = 3, meaning that we need to divide my array into 3 sub-arrays.
		Solution would be: [4,7] [12, 5] [3, 16] so that the largest segment is [3, 16] = 19 and no other segmentation variant can produce the largest segment with smaller total.
	Another example:
		Array [3, 13, 5, 7, 18, 8, 20, 1]
		M = 4
		Solution: [3, 13, 5] [7, 18] [8] [20, 1], the "fattest" segment is [7, 18] = 25
		
  The following algorithm uses Binary Search
*/
public class SmallestPossibleLargestSegment {

	public long getSmall(int[] array, int m) {
		// Any one of the segment must be assigned the largest value in the array.
		// If so, that must be the lowest possible partition value
		long low = Arrays.stream(array).max().getAsInt();
		// Sum of all the elements is the highest possible partition value
		long high = Arrays.stream(array).sum();
		while (low < high) {
			long mid = low + (high - low) / 2;
			if (predicate(array, mid, m)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	// greedy algorithm
	public boolean predicate(int[] array, long mid, int m) {
		int count = 1, sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (sum + array[i] <= mid) {
				sum += array[i];
			} else {
				count++;
				sum = array[i];
			}
		}
		return count <= m;
	}
}
