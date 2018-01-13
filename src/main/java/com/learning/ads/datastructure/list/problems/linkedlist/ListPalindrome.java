package com.learning.ads.datastructure.list.problems.linkedlist;

import java.util.Stack;

public class ListPalindrome {
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head, slow = head;
		Stack<Integer> stack = new Stack<>();
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			stack.push(slow.value);
			slow = slow.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.value != stack.pop()) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}
