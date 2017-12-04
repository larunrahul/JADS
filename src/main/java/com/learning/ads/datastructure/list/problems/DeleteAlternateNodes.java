package com.learning.ads.datastructure.list.problems;

public class DeleteAlternateNodes {
	public void delete(ListNode head) {
		while (head != null && head.next != null) {
			head.next = head.next.next;
			head = head.next;
		}
	}

	public void deleteRec(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		head.next = head.next.next;
		deleteRec(head.next);
	}
}
