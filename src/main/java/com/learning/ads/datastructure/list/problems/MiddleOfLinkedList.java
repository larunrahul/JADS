package com.learning.ads.datastructure.list.problems;

public class MiddleOfLinkedList {
	public int middle(ListNode head) {
		ListNode fast = head, slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.value;
	}
}
