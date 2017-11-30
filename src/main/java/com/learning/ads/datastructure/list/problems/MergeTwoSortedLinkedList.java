package com.learning.ads.datastructure.list.problems;

public class MergeTwoSortedLinkedList {
	public ListNode merge(ListNode first, ListNode second) {
		ListNode result = new ListNode(-1), tail = result;
		while (first != null && second != null) {
			if (first.value <= second.value) {
				tail.next = first;
				first = first.next;
				tail = tail.next;
			} else {
				tail.next = second;
				second = second.next;
				tail = tail.next;
			}
		}
		if (first == null) {
			tail.next = second;
		} else {
			tail.next = first;
		}
		return result.next;
	}
}
