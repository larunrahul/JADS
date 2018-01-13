package com.learning.ads.datastructure.list.problems.linkedlist;

public class RemoveDuplicatesInSortedLinkedList {
	public void remove(ListNode head) {
		while (head != null && head.next != null) {
			if (head.value == head.next.value) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}

		}
	}
}
