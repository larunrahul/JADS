package com.learning.ads.datastructure.list.problems.linkedlist;

public class SwapNodesInLinkedList {

	public ListNode swap(long first, long second, ListNode head) {
		ListNode node = head, pFirst = null, cFirst = null, pSecond = null, cSecond = null, prev = null;
		while (node != null) {
			if (first == node.value) {
				cFirst = node;
				pFirst = prev;
			}
			if (second == node.value) {
				cSecond = node;
				pSecond = prev;
			}
			prev = node;
			node = node.next;
		}
		if (cFirst == null || cSecond == null) {
			return head;
		}
		if (pFirst == null) {
			head = cSecond;
		} else {
			pFirst.next = cSecond;
		}
		if (pSecond == null) {
			head = cFirst;
		} else {
			pSecond.next = cFirst;
		}
		ListNode temp = cSecond.next;
		cSecond.next = cFirst.next;
		cFirst.next = temp;
		return head;
	}

}
