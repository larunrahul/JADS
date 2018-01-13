package com.learning.ads.datastructure.list.problems.linkedlist;

public class FindElement {
	
	long position = 0;
	
	public long find(int value, ListNode head) {
		long position = 0;
		while(head != null) {
			if(value == head.value) {
				return position;
			}
			position++;
			head = head.next;
		}
		return -1;
	}
	
	public long findRec(int value, ListNode head) {
		if(head == null) {
			return -1;
		}
		if(value == head.value) {
			return position;
		}
		position++;
		return findRec(value, head.next);
	}
}
