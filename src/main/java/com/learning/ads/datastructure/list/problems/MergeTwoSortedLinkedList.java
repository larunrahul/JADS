package com.learning.ads.datastructure.list.problems;

public class MergeTwoSortedLinkedList {
	public ListNode merge(ListNode first, ListNode second) {
		ListNode result = new ListNode(-1), tail = result;
		while (first != null && second != null) {
			if (first.value <= second.value) {
				tail.next = first;
				first = first.next;
			} else {
				tail.next = second;
				second = second.next;
			}
			tail = tail.next;
		}
		if (first == null) {
			tail.next = second;
		} else {
			tail.next = first;
		}
		return result.next;
	}

	public ListNode mergeRec(ListNode first, ListNode second) {
		ListNode result = null;
		if (first == null) {
			return second;
		} else if (second == null) {
			return first;
		}
		if (first.value <= second.value) {
			result = first;
			result.next = mergeRec(first.next, second);
		} else {
			result = second;
			result.next = mergeRec(first, second.next);
		}
		return result;
	}
}
