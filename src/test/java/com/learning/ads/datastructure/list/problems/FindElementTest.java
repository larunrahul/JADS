package com.learning.ads.datastructure.list.problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindElementTest {
	
	private FindElement rll = new FindElement();
	final ListNode head;
	
	{
		head = new ListNode(1);
		head.attach(2).attach(3).attach(4);
	}

	@Test
	public void findNotFound() {
		assertEquals(-1, rll.find(31, head));
	}
	
	@Test
	public void find() {
		assertEquals(3, rll.find(4, head));
	}

	@Test
	public void findRecNotFound() {
		assertEquals(-1, rll.findRec(31, head));
	}
	
	@Test
	public void findRec() {
		assertEquals(3, rll.findRec(4, head));
	}
}
