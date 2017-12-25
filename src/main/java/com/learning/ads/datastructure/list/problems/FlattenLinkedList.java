package com.learning.ads.datastructure.list.problems;

public class FlattenLinkedList {

	/**
	 * Flattens multilevel linked list to a single level linked list. This doesn't disturb the original list.
	 * @param head : List of type ListBiNode that has pointers to both next and branch
	 * @return : List of type ListNode whic is flattened form of head
	 */
	public ListNode flatten(ListBiNode head) {
		ListNode result = null;
		if (head != null) {
			result = new ListNode(head.value);
			// A straight forward manipulation
			if (head.down == null) {
				result.next = flatten(head.next);
			}
			// First go down to flatten it, then continue with next element
			else {
				ListBiNode next = head.next;
				// Go down to flatten branch
				result.next = flatten(head.down);
				ListNode end = result.next;
				// traverse through the flatten till end
				while (end.next != null) {
					end = end.next;
				}
				// continue with next element
				end.next = flatten(next);
			}
		}
		return result;
	}

}
