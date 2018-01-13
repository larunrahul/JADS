package com.learning.ads.datastructure.list.problems.linkedlist;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.RemoveDuplicatesInSortedLinkedList;

public class RemoveDuplicatesInSortedLinkedListTest {

	RemoveDuplicatesInSortedLinkedList rll = new RemoveDuplicatesInSortedLinkedList();

	@Test
	public void test() {
		ListNode head = new ListNode(11);
		head.attach(11).attach(11).attach(12).attach(13).attach(14).attach(14).attach(15).attach(15);
		ListNode expected = new ListNode(11);
		expected.attach(12).attach(13).attach(14).attach(15);
		rll.remove(head);
		Util.assertListEqual(expected, head);
	}

}
