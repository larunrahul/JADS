package com.learning.ads.datastructure.stack.problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * @author Arun Rahul
 *
 */
public class NextGreaterElementWithinSameArray {
	/**
	 * Time complexity: O(N) where N is the size of array
	 * 
	 * Space complexity: O(N) where N is the size of array
	 * 
	 * Idea is to use stack. Instead of elements, we store the index of element.
	 * 
	 * On every iteration, remove the elements from stack which are less than the
	 * current element. For all those removed elements, current element is the next
	 * greater element. Now add the current element to stack.
	 * 
	 * After all the iterations, if there are any elements left in stack, it means
	 * for each of those element there is no element bigger than that in the
	 * remaining array.
	 * 
	 * @param T
	 * @return
	 */
	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> pos = new Stack<>();
		int[] result = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			while (!pos.isEmpty() && T[i] > T[pos.peek()]) {
				int c = pos.pop();
				result[c] = i - c;
			}
			pos.push(i);
		}
		while (!pos.isEmpty()) {
			result[pos.pop()] = 0;
		}
		return result;
	}
}
