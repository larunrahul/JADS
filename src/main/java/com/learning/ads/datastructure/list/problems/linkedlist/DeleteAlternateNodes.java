package com.learning.ads.datastructure.list.problems.linkedlist;

public class DeleteAlternateNodes {
	public void delete(ListNode head) {
		while (head != null && head.next != null) {
			head.next = head.next.next;
			head = head.next;
		}
	}

	/**
	 * Delete alternate n nodes after m nodes
	 * 
	 * @param head
	 * @param n
	 * @param m
	 */
	public void deleteAlternate(ListNode head, int n, int m) {
		while (head != null) {
			for (int i = 0; i < m - 1 && head != null; i++) {
				head = head.next;
			}
			ListNode fHalf = head;
			if (fHalf != null) {
				for (int i = 0; i < n && fHalf.next != null; i++) {
					fHalf.next = fHalf.next.next;
				}
				head = fHalf.next;
			}
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
