package com.learning.ads.datastructure.list.problems;

public class IntersectionOfTwoSorteLinkeList {
	public ListNode intersection(ListNode first, ListNode second) {
		ListNode dummy = new ListNode(-1), cur = dummy;
		while (first != null && second != null) {
			while (second != null && first.value > second.value) {
				second = second.next;
			}
			if (second == null) {
				return dummy.next;
			} else if (first.value == second.value) {
				ListNode temp = second;
				second = second.next;
				cur.next = temp;
				cur = cur.next;
				cur.next = null;
			}
			first = first.next;
		}
		return dummy.next;
	}

}
