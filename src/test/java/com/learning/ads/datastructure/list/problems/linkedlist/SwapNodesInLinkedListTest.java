package com.learning.ads.datastructure.list.problems.linkedlist;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.SwapNodesInLinkedList;

public class SwapNodesInLinkedListTest {

	private SwapNodesInLinkedList rll = new SwapNodesInLinkedList();
	final ListNode head;

	{
		head = new ListNode(1);
		head.attach(2).attach(3).attach(4).attach(5).attach(6);
	}

	@Test
	public void swapMiddle() {
		ListNode expected = new ListNode(1);
		expected.attach(4).attach(3).attach(2).attach(5).attach(6);
		Util.assertListEqual(expected, rll.swap(2, 4, head));

	}

	@Test
	public void swapMiddleReverse() {
		ListNode expected = new ListNode(1);
		expected.attach(4).attach(3).attach(2).attach(5).attach(6);
		Util.assertListEqual(expected, rll.swap(4, 2, head));

	}

	@Test
	public void swapHead() {
		ListNode expected = new ListNode(2);
		expected.attach(1).attach(3).attach(4).attach(5).attach(6);
		Util.assertListEqual(expected, rll.swap(1, 2, head));

	}

	@Test
	public void swapHeadReverse() {
		ListNode expected = new ListNode(2);
		expected.attach(1).attach(3).attach(4).attach(5).attach(6);
		Util.assertListEqual(expected, rll.swap(2, 1, head));

	}

	@Test
	public void swapHeadWithMiddle() {
		ListNode expected = new ListNode(4);
		expected.attach(2).attach(3).attach(1).attach(5).attach(6);
		Util.assertListEqual(expected, rll.swap(1, 4, head));

	}

	@Test
	public void swapHeadReverseWithMiddle() {
		ListNode expected = new ListNode(4);
		expected.attach(2).attach(3).attach(1).attach(5).attach(6);
		Util.assertListEqual(expected, rll.swap(4, 1, head));

	}

}
