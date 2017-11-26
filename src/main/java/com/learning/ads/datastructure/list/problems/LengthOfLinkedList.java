package com.learning.ads.datastructure.list.problems;

public class LengthOfLinkedList {
	public long length(ListNode head) {
		long count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public long lengthRec(ListNode head) {
		if (head == null) {
			return 0;
		}
		return 1 + lengthRec(head.next);
	}
}
