package com.learning.ads.datastructure.list.problems.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.NodeFromLast;

public class NodeFromLastTest {
	
	private NodeFromLast rll = new NodeFromLast();
	final ListNode head;
	
	{
		head = new ListNode(1);
		head.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4));
	}

	@Test
	public void getNodeFromLast() {
		assertEquals(4, rll.getNodeFromLast(1, head));
	}

	@Test
	public void getNodeFromLastAtMiddle() {
		assertEquals(3, rll.getNodeFromLast(2, head));
	}
	
	@Test
	public void getNodeFromLastAtStart() {
		assertEquals(1, rll.getNodeFromLast(4, head));
	}
	
	@Test(expected = RuntimeException.class)
	public void getNodeFromLastOutOfBounds() {
		rll.getNodeFromLast(5, head);
	}
}
