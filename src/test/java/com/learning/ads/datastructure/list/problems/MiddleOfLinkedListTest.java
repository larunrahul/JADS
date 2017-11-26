package com.learning.ads.datastructure.list.problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class MiddleOfLinkedListTest {
	
	private MiddleOfLinkedList rll = new MiddleOfLinkedList();
	final ListNode head;
	
	{
		head = new ListNode(1);
		head.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4));
	}
	
	@Test
	public void middleSingleElement() {
		ListNode node = new ListNode(1);
		assertEquals(1, rll.middle(node));
	}
	
	@Test
	public void middleTwoElements() {
		ListNode node = new ListNode(1);
		node.attach(new ListNode(2));
		assertEquals(2, rll.middle(node));
	}

	@Test
	public void middleEven() {
		assertEquals(3, rll.middle(head));
	}

	@Test
	public void middleOdd() {
		ListNode node = new ListNode(1);
		node.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4)).attach(new ListNode(5));
		assertEquals(3, rll.middle(node));
	}
}
