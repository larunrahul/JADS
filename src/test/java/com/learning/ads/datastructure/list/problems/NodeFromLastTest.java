package com.learning.ads.datastructure.list.problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeFromLastTest {
	
	private NodeFromLast rll = new NodeFromLast();
	final ListNode head;
	
	{
		head = new ListNode(1);
		head.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4));
	}

	@Test
	public void getNodeFromLast() {
		assertEquals(4, rll.getNodeFromLast(0, head));
	}

	@Test
	public void getNodeFromLastAtMiddle() {
		assertEquals(2, rll.getNodeFromLast(2, head));
	}
	
	@Test
	public void getNodeFromLastAtStart() {
		assertEquals(1, rll.getNodeFromLast(3, head));
	}
	
	@Test(expected = RuntimeException.class)
	public void getNodeFromLastOutOfBounds() {
		rll.getNodeFromLast(4, head);
	}
}
