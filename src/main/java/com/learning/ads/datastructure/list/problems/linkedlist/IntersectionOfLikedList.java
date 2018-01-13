package com.learning.ads.datastructure.list.problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
 * 
 * @author Arun Rahul
 *
 */
public class IntersectionOfLikedList {

	/**
	 * The following code assumes there are no duplicates in each list
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public ListNode intersection(ListNode first, ListNode second) {
		ListNode result = new ListNode(-1), tail = result;
		/*
		 * we can use HashSet instead of HashMap, but java internally uses HashMap to
		 * implement HashSet
		 */
		Map<Integer, Integer> map = new HashMap<>();
		while (first != null) {
			map.put(first.value, 1);
			first = first.next;
		}
		while (second != null) {
			if (map.containsKey(second.value)) {
				tail.next = new ListNode(second.value);
				tail = tail.next;
			}
			second = second.next;
		}
		return result.next;
	}
}
