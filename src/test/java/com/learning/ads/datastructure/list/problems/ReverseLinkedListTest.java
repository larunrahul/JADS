package com.learning.ads.datastructure.list.problems;

import org.junit.Test;

public class ReverseLinkedListTest {
	
	private ReverseLinkedList rll = new ReverseLinkedList();
	final ListNode head;
	
	{
		head = new ListNode(1);
		head.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4));
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
		expected.attach(new ListNode(3)).attach(new ListNode(2)).attach(new ListNode(1));
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
		expected.attach(new ListNode(3)).attach(new ListNode(2)).attach(new ListNode(1));
		Util.assertListEqual(expected, rll.reverseRecursive(head, head));
	}

}
