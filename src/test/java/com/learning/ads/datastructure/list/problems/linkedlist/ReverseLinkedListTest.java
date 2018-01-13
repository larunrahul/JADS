package com.learning.ads.datastructure.list.problems;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ReverseLinkedListTest {

	private ReverseLinkedList rll = new ReverseLinkedList();
	final ListNode head;

	{
		head = new ListNode(1);
		head.attach(2).attach(3).attach(4);
	}
	
	@Test
	public void reverseEmptyList() {
		assertNull(rll.reverse(null));
	}

	@Test
	public void reverseSingleElement() {
		ListNode head = new ListNode(4);
		ListNode expected = new ListNode(4);
		Util.assertListEqual(expected, rll.reverse(head));
	}

	@Test
	public void reverse() {
		ListNode expected = new ListNode(4);
		expected.attach(3).attach(2).attach(1);
		Util.assertListEqual(expected, rll.reverse(head));
	}

	@Test
	public void reverseRecursiveSingleElement() {
		ListNode head = new ListNode(4);
		ListNode expected = new ListNode(4);
		Util.assertListEqual(expected, rll.reverseRecursive(head, head));
	}

	@Test
	public void reverseRecursive() {
		ListNode expected = new ListNode(4);
		expected.attach(3).attach(2).attach(1);
		Util.assertListEqual(expected, rll.reverseRecursive(head, head));
	}

}
