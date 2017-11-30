package com.learning.ads.datastructure.list.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LengthOfLinkedListTest {
	
	private LengthOfLinkedList rll = new LengthOfLinkedList();
	final ListNode head;
	
	{
		head = new ListNode(1);
		head.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4));
	}

	@Test
	public void lengthForEmptyList() {
		assertEquals(0, rll.length(null));
	}
	
	@Test
	public void length() {
		assertEquals(4, rll.length(head));
	}

	@Test
	public void lengthForEmptyListRec() {
		assertEquals(0, rll.lengthRec(null));
	}
	
	@Test
	public void lengthRec() {
		assertEquals(4, rll.lengthRec(head));
	}
}
