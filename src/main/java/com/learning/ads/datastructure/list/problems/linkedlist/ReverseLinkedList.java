package com.learning.ads.datastructure.list.problems.linkedlist;

public class ReverseLinkedList {

	public ListNode prev, next;

	public ListNode reverse(ListNode node) {
		ListNode next = null, current = node, prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public ListNode reverseRecursive(ListNode current, ListNode head) {
		if (current.next == null) {
			return head;
		}
		ListNode pn = current;
		current = current.next;
		pn.next = current.next;
		current.next = head;
		head = current;
		current = pn;
		return reverseRecursive(current, head);

	}

}
