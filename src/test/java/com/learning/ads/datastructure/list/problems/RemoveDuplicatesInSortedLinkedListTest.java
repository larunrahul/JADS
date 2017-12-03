package com.learning.ads.datastructure.list.problems;

import org.junit.Test;

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
