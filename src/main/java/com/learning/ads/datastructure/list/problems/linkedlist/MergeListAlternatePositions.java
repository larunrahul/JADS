package com.learning.ads.datastructure.list.problems.linkedlist;

public class MergeListAlternatePositions {

	public ListNode second;

	/**
	 * Merge them at alternate positions and attach the remaining list in second to
	 * the first
	 * 
	 * @param first
	 * @param second
	 */
	public void merge(ListNode first, ListNode second) {
		ListNode fPrev = first;
		while (first != null && second != null) {
			ListNode fNext = first.next;
			ListNode sNext = second.next;
			first.next = second;
			second.next = fNext;
			fPrev = second;
			first = fNext;
			second = sNext;
		}
		if (second != null && fPrev != null) {
			fPrev.next = second;
		}
	}

	/**
	 * Merge them at alternate positions and keep the remaining list in second
	 * 
	 * https://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
	 * 
	 * @param first
	 * @param second
	 */
	public void mergeLeft(ListNode first, ListNode second) {
		while (first != null && second != null) {
			ListNode fNext = first.next;
			ListNode sNext = second.next;
			first.next = second;
			second.next = fNext;
			first = fNext;
			second = sNext;
		}
		this.second = second;
	}

}
