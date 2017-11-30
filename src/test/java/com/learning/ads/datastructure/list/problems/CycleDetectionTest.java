package com.learning.ads.datastructure.list.problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class CycleDetectionTest {

	private CycleDetection rll = new CycleDetection();
	final ListNode head;

	{
		head = new ListNode(1);
		ListNode loopstart = new ListNode(5);
		ListNode loopend = new ListNode(10);
		loopend.next = loopstart;
		head.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4)).attach(loopstart)
				.attach(new ListNode(6)).attach(new ListNode(7)).attach(new ListNode(8)).attach(new ListNode(9))
				.attach(loopend);
	}

	@Test
	public void testIfLoopForNonCycleList() {
		ListNode head = new ListNode(1);
		head.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4));
		assertFalse(rll.hasLoop(head));
	}

	@Test
	public void testIfLoopForSnake() {
		assertTrue(rll.hasLoop(head));
	}

	@Test(expected = RuntimeException.class)
	public void headOfLoopForNonCycle() {
		ListNode head = new ListNode(1);
		head.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4));
		rll.loopstart(head);
	}

	@Test
	public void headOfLoopForSnake() {
		assertEquals(5, rll.loopstart(head));
	}
}
