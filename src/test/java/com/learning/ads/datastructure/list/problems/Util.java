package com.learning.ads.datastructure.list.problems;

public final class Util {
	
	public static void toString(ListNode head) {
		while (head != null) {
			System.out.print(head.value + " --> ");
			head = head.next;
		}
		System.out.println("NULL\n");
	}

	public static void assertListEqual(ListNode first, ListNode second) {
		while (first != null && second != null) {
			if(first.value == second.value) {
				first = first.next;
				second = second.next;
			}else {
				throw new RuntimeException("Value for nodes didn't match");
			}
		}
		if (!(first == null && second == null)) {
			throw new RuntimeException("List lengths didn't match");
		}
	}
}
