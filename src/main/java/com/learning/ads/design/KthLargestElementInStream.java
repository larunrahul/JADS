package com.learning.ads.design;

import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/
 * 
 * 
 * @author Arun Rahul
 *
 */
public class KthLargestElementInStream {

	/**
	 * Complexity: O(n)
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public int[] find(int[] array, int k) {
		int c = Integer.MIN_VALUE;
		int[] result = new int[array.length];
		int resultCounter = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(k);
		for (int i = 0; i < array.length; i++) {
			if (i < k - 1) {
				pq.add(array[i]);
				result[resultCounter++] = -1;
			} else {
				int a = array[i];
				if (a >= c) {
					if (!pq.isEmpty()) {
						pq.add(a);
						c = pq.poll();
					} else {
						c = a;
					}
				}
				result[resultCounter++] = c;
			}
		}
		return result;
	}

}
