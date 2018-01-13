package com.learning.ads.datastructure.list.problems;

public class MoveLastToFront {
	public ListNode move(ListNode head) {
		ListNode prev = head, next = head;
		if (next == null || next.next == null) {
			return next;
		}
		while (next != null && next.next != null) {
			prev = next;
			next = next.next;
		}
		prev.next = null;
		next.next = head;
		head = next;
		return head;
	}
}
