package com.learning.ads.datastructure.list.problems.linkedlist;

public class NodeFromLast {
	public int getNodeFromLast(long n, ListNode head) {
		ListNode first = head, regular = head;
		long count = 0;
		while (count < n) {
			if (first == null) {
				throw new RuntimeException("Index out of range of list length");
			}
			first = first.next;
			count++;
		}
		while (first != null) {
			regular = regular.next;
			first = first.next;
		}
		return regular.value;
	}
}
