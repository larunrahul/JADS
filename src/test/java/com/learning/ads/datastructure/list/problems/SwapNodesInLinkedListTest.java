package com.learning.ads.datastructure.list.problems;

import org.junit.Test;

public class SwapNodesInLinkedListTest {
	
	private SwapNodesInLinkedList rll = new SwapNodesInLinkedList();
	final ListNode head;
	
	{
		head = new ListNode(1);
		head.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4)).attach(new ListNode(5)).attach(new ListNode(6));
	}

	@Test
	public void swapMiddle() {
		ListNode expected = new ListNode(1);
		expected.attach(new ListNode(4)).attach(new ListNode(3)).attach(new ListNode(2)).attach(new ListNode(5)).attach(new ListNode(6));
		Util.assertListEqual(expected, rll.swap(2, 4, head));
		
	}
	
	@Test
	public void swapMiddleReverse() {
		ListNode expected = new ListNode(1);
		expected.attach(new ListNode(4)).attach(new ListNode(3)).attach(new ListNode(2)).attach(new ListNode(5)).attach(new ListNode(6));
		Util.assertListEqual(expected, rll.swap(4, 2, head));
		
	}
	
	@Test
	public void swapHead() {
		ListNode expected = new ListNode(2);
		expected.attach(new ListNode(1)).attach(new ListNode(3)).attach(new ListNode(4)).attach(new ListNode(5)).attach(new ListNode(6));
		Util.assertListEqual(expected, rll.swap(1, 2, head));
		
	}
	
	@Test
	public void swapHeadReverse() {
		ListNode expected = new ListNode(2);
		expected.attach(new ListNode(1)).attach(new ListNode(3)).attach(new ListNode(4)).attach(new ListNode(5)).attach(new ListNode(6));
		Util.assertListEqual(expected, rll.swap(2, 1, head));
		
	}
	
	@Test
	public void swapHeadWithMiddle() {
		ListNode expected = new ListNode(4);
		expected.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(1)).attach(new ListNode(5)).attach(new ListNode(6));
		Util.assertListEqual(expected, rll.swap(1, 4, head));
		
	}
	
	@Test
	public void swapHeadReverseWithMiddle() {
		ListNode expected = new ListNode(4);
		expected.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(1)).attach(new ListNode(5)).attach(new ListNode(6));
		Util.assertListEqual(expected, rll.swap(4, 1, head));
		
	}

}
