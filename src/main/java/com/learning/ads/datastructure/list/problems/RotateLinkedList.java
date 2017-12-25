package com.learning.ads.datastructure.list.problems;

/**
 * https://www.geeksforgeeks.org/rotate-a-linked-list/
 * 
 * @author Arun Rahul
 *
 */
public class RotateLinkedList {
	public ListNode rotate(ListNode head, int k) {
		ListNode current = head;
		while (current != null && k > 1) {
			current = current.next;
			k--;
		}
		if (current == null || current.next == null) {
			return head;
		}
		ListNode newHead = current.next;
		current.next = null;
		current = newHead;
		while (current.next != null) {
			current = current.next;
		}
		current.next = head;
		return newHead;
	}
}
