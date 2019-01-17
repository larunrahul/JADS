package com.learning.ads.datastructure.stack.problems;

import java.util.HashMap;
import java.util.Map;

import com.learning.ads.datastructure.stack.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * 
 * @author Arun Rahul
 *
 */
public class NextGreaterElement {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums2.length; i++) {
			while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
				map.put(nums2[stack.pop()], nums2[i]);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			map.put(nums2[stack.pop()], -1);
		}
		for (int i = 0; i < nums1.length; i++) {
			result[i] = map.get(nums1[i]);
		}
		return result;
	}
}
