package com.learning.ads.datastructure.list.problems;

/**
 * https://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 * 
 * @author Arun Rahul
 *
 */

public class DeleteSmallNodesOnRight {

	ReverseLinkedList rll = new ReverseLinkedList();

	public ListNode delete(ListNode head) {
		ListNode reversed = rll.reverse(head);
		int max = Integer.MIN_VALUE;
		ListNode prev = reversed, current = reversed;
		while (current != null) {
			if (current.value < max) {
				prev.next = current.next;
			} else {
				max = current.value;
				prev = current;
			}
			current = current.next;
		}
		return rll.reverse(reversed);
	}

}
