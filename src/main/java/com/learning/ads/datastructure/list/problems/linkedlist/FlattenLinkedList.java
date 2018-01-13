package com.learning.ads.datastructure.list.problems.linkedlist;

/**
 * Flattening a linked list
 * 
 * @author Arun Rahul
 *
 */
public class FlattenLinkedList {

	/**
	 * Flattens multilevel linked list to a single level linked list. This doesn't
	 * disturb the original list.
	 * 
	 * @param head
	 *            : List of type ListBiNode that has pointers to both next and
	 *            branch
	 * @return : List of type ListNode which is flattened form of head
	 */
	public ListNode flattenRec(ListBiNode head) {
		ListNode result = null;
		if (head != null) {
			result = new ListNode(head.value);
			// A straight forward manipulation
			if (head.down == null) {
				result.next = flattenRec(head.next);
			}
			// First go down to flatten it, then continue with next element
			else {
				ListBiNode next = head.next;
				// Go down to flatten branch
				result.next = flattenRec(head.down);
				ListNode end = result.next;
				// traverse through the flatten till end
				while (end.next != null) {
					end = end.next;
				}
				// continue with next element
				end.next = flattenRec(next);
			}
		}
		return result;
	}

	/**
	 * Flattens multilevel linked list to a single level linked list. This doesn't
	 * disturb the original list.
	 * 
	 * @param head
	 *            : List of type ListBiNode that has pointers to both next and
	 *            branch
	 * @return : List of type ListNode which is flattened form of head
	 */
	public ListNode flatten(ListBiNode node) {
		ListNode result = new ListNode(-1), tail = result;
		ListBiNode head = node;
		while (head != null) {
			ListBiNode next = head.next;
			// create new node for current node
			tail.next = new ListNode(head.value);
			tail = tail.next;
			// if child, append it to the end of this list
			if (head.down != null) {
				head.next = head.down;
				ListBiNode dNext = head.down;
				while (dNext.next != null) {
					dNext = dNext.next;
				}
				dNext.next = next;
			}
			head = head.next;
		}

		return result.next;
	}

	/**
	 * Flatten a linked list level wise.
	 * https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/
	 * 
	 * @param node
	 * @return
	 */
	public ListNode flattenLevelWise(ListBiNode node) {
		ListNode result = new ListNode(-1), tail = result;
		ListBiNode head = node, ltail = node;
		// find the tail
		while (ltail.next != null) {
			ltail = ltail.next;
		}
		while (head != null) {
			// new node for current node
			tail.next = new ListNode(head.value);
			tail = tail.next;
			// append child to tail
			ltail.next = head.down;
			// find new tail
			while (ltail.next != null) {
				ltail = ltail.next;
			}
			head = head.next;
		}
		return result.next;
	}

}
