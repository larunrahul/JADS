package com.learning.ads.datastructure.list.problems.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.SegregateEvenOdd;

public class SegregateEvenOddTest {

	SegregateEvenOdd rll = new SegregateEvenOdd();

	@Test
	public void evenNodes() {
		ListNode head = new ListNode(1);
		head.attach(4).attach(2).attach(6).attach(3).attach(9).attach(8).attach(24);
		ListNode expected = new ListNode(4);
		expected.attach(2).attach(6).attach(8).attach(24).attach(1).attach(3).attach(9);
		Util.assertListEqual(expected, rll.segregate(head));
	}

	@Test
	public void oddNodes() {
		ListNode head = new ListNode(1);
		head.attach(4).attach(2).attach(6).attach(3).attach(9).attach(8).attach(24).attach(23);
		ListNode expected = new ListNode(4);
		expected.attach(2).attach(6).attach(8).attach(24).attach(1).attach(3).attach(9).attach(23);
		Util.assertListEqual(expected, rll.segregate(head));
	}

	@Test
	public void emptyList() {
		assertNull(rll.segregate(null));
	}

	@Test
	public void singleEvenNode() {
		ListNode head = new ListNode(1);
		ListNode expected = new ListNode(1);
		Util.assertListEqual(expected, rll.segregate(head));
	}

	@Test
	public void singleOddNode() {
		ListNode head = new ListNode(2);
		ListNode expected = new ListNode(2);
		Util.assertListEqual(expected, rll.segregate(head));
	}

	@Test
	public void singleOddNodeSingleEvenNode() {
		ListNode head = new ListNode(2).attach(7);
		ListNode expected = new ListNode(2).attach(7);
		Util.assertListEqual(expected, rll.segregate(head));
	}

}
