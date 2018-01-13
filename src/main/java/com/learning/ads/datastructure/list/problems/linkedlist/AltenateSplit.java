package com.learning.ads.datastructure.list.problems;

public class AltenateSplit {
	public ListNode[] alternateSplit(ListNode head) {
		ListNode first = new ListNode(-1), second = new ListNode(-1), fTail = first, sTail = second;
		ListNode current = head;
		while (current != null) {
			fTail.next = current;
			ListNode next = current.next;
			current.next = null;
			fTail = fTail.next;
			if (next != null) {
				sTail.next = next;
				current = next.next;
				next.next = null;
				sTail = sTail.next;
			} else {
				current = next;
			}
		}
		return new ListNode[] { first.next, second.next };
	}
}
