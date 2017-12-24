package com.learning.ads.datastructure.list.problems;

public class AddTwoNumbers {
	public ListNode add(ListNode first, ListNode second) {
		ListNode result = new ListNode(-1), tail = result;
		int carry = 0;
		while (first != null || second != null) {
			int sum = 0;
			if (first != null) {
				sum += first.value;
				first = first.next;
			}
			if (second != null) {
				sum += second.value;
				second = second.next;
			}
			sum += carry;
			carry = sum >= 10 ? 1 : 0;
			tail.next = new ListNode(sum % 10);
			tail = tail.next;
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return result.next;
	}
}
