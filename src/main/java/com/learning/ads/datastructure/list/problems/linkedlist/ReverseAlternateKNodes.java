package com.learning.ads.datastructure.list.problems.linkedlist;

/**
 * https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 * 
 * @author Arun Rahul
 *
 */
public class ReverseAlternateKNodes {

	private ListNode[] reverse(ListNode node, int size) {
		ListNode next = null, current = node, prev = null;
		while (current != null && size != 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			size--;
		}
		return new ListNode[] { prev, next };
	}

	public ListNode reverseInSet(ListNode node, int size) {
		ListNode[] ids = reverse(node, size);
		if (ids[1] != null) {
			node.next = ids[1];
			for (int i = 0; i < size && node != null; i++) {
				node = node.next;
			}
			if (node != null) {
				node.next = reverseInSet(node.next, size);
			}
		}
		return ids[0];
	}

}
