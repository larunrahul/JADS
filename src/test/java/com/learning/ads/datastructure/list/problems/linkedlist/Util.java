package com.learning.ads.datastructure.list.problems.linkedlist;

import com.learning.ads.datastructure.list.problems.linkedlist.ListBiNode;
import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;

public final class Util {
	
	public static void toString(ListNode head) {
		while (head != null) {
			System.out.print(head.value + " --> ");
			head = head.next;
		}
		System.out.println("NULL\n");
	}
	
	public static void toStringBiNode(ListBiNode head) {
		while(head != null) {
			System.out.print(head.value + " --> ");
			if(head.down != null) {
				toStringBiNode(head.down);
			}
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
