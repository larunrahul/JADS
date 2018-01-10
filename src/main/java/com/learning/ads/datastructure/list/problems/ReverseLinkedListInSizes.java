package com.learning.ads.datastructure.list.problems;

/**
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 * 
 * @author Arun Rahul
 *
 */
public class ReverseLinkedListInSizes {

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
		Util.toString(node);
		if (ids[1] != null) {
			node.next = reverseInSet(ids[1], size);
		}
		return ids[0];
	}

}
