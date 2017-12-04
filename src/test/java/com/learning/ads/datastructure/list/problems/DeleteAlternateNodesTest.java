package com.learning.ads.datastructure.list.problems;

import org.junit.Test;

public class DeleteAlternateNodesTest {

	DeleteAlternateNodes rll = new DeleteAlternateNodes();

	@Test
	public void deleteOddCountList() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4).attach(5);
		ListNode expected = new ListNode(1);
		expected.attach(3).attach(5);
		rll.delete(head);
		Util.assertListEqual(expected, head);
	}

	@Test
	public void deleteRecOddCountList() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4).attach(5);
		ListNode expected = new ListNode(1);
		expected.attach(3).attach(5);
		rll.deleteRec(head);
		Util.assertListEqual(expected, head);
	}

	@Test
	public void deleteEvenCountList() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4);
		ListNode expected = new ListNode(1);
		expected.attach(3);
		rll.delete(head);
		Util.assertListEqual(expected, head);
	}

	@Test
	public void deleteRecEvenCountList() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4);
		ListNode expected = new ListNode(1);
		expected.attach(3);
		rll.deleteRec(head);
		Util.assertListEqual(expected, head);
	}

	@Test
	public void deleteSingleElementList() {
		ListNode head = new ListNode(1);
		ListNode expected = new ListNode(1);
		rll.delete(head);
		Util.assertListEqual(expected, head);
	}

	@Test
	public void deleteRecSingleElementList() {
		ListNode head = new ListNode(1);
		ListNode expected = new ListNode(1);
		rll.deleteRec(head);
		Util.assertListEqual(expected, head);
	}

}
