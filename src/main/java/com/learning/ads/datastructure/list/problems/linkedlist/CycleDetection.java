package com.learning.ads.datastructure.list.problems.linkedlist;

/**
 * https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 * 
 * @author Arun Rahul
 *
 */

public class CycleDetection {

	/**
	 * Floyd Cycle Detection Algorithm
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasLoop(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Once we find the loop with Floyd Cycle detection Algorithm, our slow and fast
	 * pointer met at some random node in the loop. Now, we have to keep one pointer
	 * (either slow or fast) at start of list and start moving both slow and pointer
	 * at same speed, let us say speed is 1. The node where both meet is the start
	 * of the loop.
	 * 
	 * @param head
	 * @return
	 */
	public int loopstart(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow.value;
			}
		}
		throw new RuntimeException("There is no loop in give linked list");
	}
}
