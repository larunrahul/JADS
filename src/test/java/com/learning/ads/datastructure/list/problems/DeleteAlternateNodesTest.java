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

	@Test
	public void deleteAlternate() {
		ListNode head = new ListNode(0);
		head.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(5).attach(6).attach(7).attach(10);
		rll.deleteAlternate(head, 2, 3);
		Util.assertListEqual(expected, head);
	}

	@Test
	public void deleteAlternateMOutOfBounds() {
		ListNode head = new ListNode(0);
		head.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(7).attach(8).attach(9);
		rll.deleteAlternate(head, 4, 3);
		Util.assertListEqual(expected, head);
	}

	@Test
	public void deleteAlternateNOutOfBounds() {
		ListNode head = new ListNode(0);
		head.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(8).attach(9).attach(10);
		rll.deleteAlternate(head, 4, 4);
		Util.assertListEqual(expected, head);
	}

	@Test
	public void deleteAlternateExactEnd() {
		ListNode head = new ListNode(0);
		head.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(4).attach(5).attach(8).attach(9);
		rll.deleteAlternate(head, 2, 2);
		Util.assertListEqual(expected, head);
	}

	@Test
	public void deleteAlternateEquivalentToDeleteAlternate() {
		ListNode head = new ListNode(0);
		head.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10);
		rll.deleteAlternate(head, 1, 1);
		rll.delete(expected);
		Util.assertListEqual(expected, head);
	}

	@Test
	public void deleteAlternateMgtN() {
		ListNode head = new ListNode(0);
		head.attach(1).attach(2).attach(3).attach(4);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(4);
		rll.deleteAlternate(head, 2, 5);
		Util.assertListEqual(expected, head);
	}

}
