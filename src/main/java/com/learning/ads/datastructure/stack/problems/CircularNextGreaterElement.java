package com.learning.ads.datastructure.stack.problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * 
 * Extension to NextGreaterElementWithinSameArray.java
 * 
 * @author Arun Rahul
 *
 */
public class CircularNextGreaterElement {

	/**
	 * 
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
	 * remaining array. So, we start searching for bigger element from start of the
	 * array.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElements(int[] nums) {
		Stack<Integer> pos = new Stack<>();
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			while (!pos.isEmpty() && nums[i] > nums[pos.peek()]) {
				int c = pos.pop();
				result[c] = nums[i];
			}
			pos.push(i);
		}
		int index = 0;
		while (!pos.isEmpty()) {
			while (index < nums.length && nums[index] <= nums[pos.peek()]) {
				index++;
			}
			int k = pos.pop();
			if (index < nums.length) {
				result[k] = nums[index];
			} else {
				result[k] = -1;
			}
		}
		return result;
	}
}
