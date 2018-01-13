package com.learning.ads.datastructure.list.problems.linkedlist;

import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.ReverseAlternateKNodes;
import com.learning.ads.datastructure.list.problems.linkedlist.ReverseLinkedList;

public class ReverseAlternateKNodesTest {

	ReverseAlternateKNodes rll = new ReverseAlternateKNodes();
	ReverseLinkedList rl = new ReverseLinkedList();
	final ListNode head;
	{
		head = new ListNode(0);
		head.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9);
	}

	@Test
	public void emptyList() {
		assertNull(rll.reverseInSet(null, 2));
	}

	@Test
	public void reverseInEvenSizes() {
		ListNode expected = new ListNode(1);
		expected.attach(0).attach(2).attach(3).attach(5).attach(4).attach(6).attach(7).attach(9).attach(8);
		Util.assertListEqual(expected, rll.reverseInSet(head, 2));
	}

	@Test
	public void reverseInOddSizes() {
		ListNode expected = new ListNode(2);
		expected.attach(1).attach(0).attach(3).attach(4).attach(5).attach(8).attach(7).attach(6).attach(9);
		Util.assertListEqual(expected, rll.reverseInSet(head, 3));
	}

	@Test
	public void reverseInExceedingSizes() {
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9);
		Util.assertListEqual(rl.reverse(expected), rll.reverseInSet(head, 10));
	}

	@Test
	public void reverseInSize1() {
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9);
		Util.assertListEqual(expected, rll.reverseInSet(head, 1));
	}

}
