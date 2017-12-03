package com.learning.ads.datastructure.list.problems;

public class PairwiseSwap {
	public ListNode swap(ListNode head) {
		ListNode cur = head, next, prev = null;
		while (cur != null && cur.next != null) {
			next = cur.next;
			cur.next = next.next;
			next.next = cur;
			if (prev == null) {
				head = next;
			} else {
				prev.next = next;
			}
			prev = cur;
			cur = cur.next;
		}
		return head;
	}
}
