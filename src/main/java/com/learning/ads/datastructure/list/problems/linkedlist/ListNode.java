package com.learning.ads.datastructure.list.problems;

public class ListNode {
	public int value;
	public ListNode next;

	ListNode(int value) {
		this.value = value;
	}

	ListNode attach(ListNode next) {
		this.next = next;
		return next;
	}
	
	ListNode attach(int value) {
		return this.attach(new ListNode(value));
	}
}
