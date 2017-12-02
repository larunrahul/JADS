package com.learning.ads.datastructure.list.problems;

import java.util.Stack;

public class IntersectionOfTwoLinkedList {
	public int findIntersection(ListNode first, ListNode second) {
		Stack<Integer> fStack = new Stack<>();
		Stack<Integer> sStack = new Stack<>();
		while (first != null) {
			fStack.push(first.value);
			first = first.next;
		}
		while (second != null) {
			sStack.push(second.value);
			second = second.next;
		}
		int result = -1;
		while (!fStack.isEmpty() && !sStack.isEmpty()) {
			int fel = fStack.pop();
			int sel = sStack.pop();
			if (fel != sel) {
				break;
			}
			result = fel;
		}
		return result;
	}

	public int finIntersectionCircle(ListNode first, ListNode second) {
		ListNode head = first, prev = first;
		if (first == null || second == null) {
			return -1;
		}
		while (head != null) {
			prev = head;
			head = head.next;
		}
		prev.next = first;
		CycleDetection cycle = new CycleDetection();
		try {
			return cycle.loopstart(second);
		} catch (RuntimeException e) {
			// no cycle
			return -1;
		}
	}
}
