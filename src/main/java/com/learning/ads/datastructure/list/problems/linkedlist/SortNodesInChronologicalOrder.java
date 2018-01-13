package com.learning.ads.datastructure.list.problems.linkedlist;

/**
 * Sort linked list whose nodes has value 0 or 1 or 2
 * 
 * @author rahul.lakkapragada
 *
 */
public class SortNodesInChronologicalOrder {

	public ListNode sort(ListNode head) {
		ListNode f = new ListNode(-1), fTail = f, s = new ListNode(-1), sTail = s, t = new ListNode(-1), tTail = t;
		while (head != null) {
			ListNode next = head.next;
			if (head.value == 0) {
				fTail.next = head;
				fTail = fTail.next;
			} else if (head.value == 1) {
				sTail.next = head;
				sTail = sTail.next;
			} else {
				tTail.next = head;
				tTail = tTail.next;
			}
			head.next = null;
			head = next;
		}
		ListNode result = new ListNode(-1);
		sTail.next = t.next;
		fTail.next = s.next;
		result.next = f.next;
		return result.next;
	}

}
