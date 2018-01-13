package com.learning.ads.datastructure.list.problems.linkedlist;

/**
 * https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 * 
 * @author Arun Rahul
 *
 */

public class SegregateEvenOdd {
	public ListNode segregate(ListNode head) {
		ListNode first = new ListNode(-1), second = new ListNode(-1), fTail = first, sTail = second;
		ListNode current = head;
		while (current != null) {
			ListNode next = current.next;
			if ((current.value & 1) != 1) {// even
				fTail.next = current;
				fTail = fTail.next;
				fTail.next = null;
			} else {
				sTail.next = current;
				sTail = sTail.next;
				sTail.next = null;
			}
			current = next;
		}
		fTail.next = second.next;
		return first.next;
	}
}
