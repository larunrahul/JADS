package com.learning.ads.datastructure.list.problems.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.CycleDetection;
import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;

public class CycleDetectionTest {

	private CycleDetection rll = new CycleDetection();
	final ListNode head;

	{
		head = new ListNode(1);
		ListNode loopstart = new ListNode(5);
		ListNode loopend = new ListNode(10);
		loopend.next = loopstart;
		head.attach(2).attach(3).attach(4).attach(loopstart).attach(6).attach(7).attach(8).attach(9).attach(loopend);
	}

	@Test
	public void testIfLoopForNonCycleList() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4);
		assertFalse(rll.hasLoop(head));
	}

	@Test
	public void testIfLoopForSnake() {
		assertTrue(rll.hasLoop(head));
	}

	@Test(expected = RuntimeException.class)
	public void headOfLoopForNonCycle() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4);
		rll.loopstart(head);
	}

	@Test
	public void headOfLoopForSnake() {
		assertEquals(5, rll.loopstart(head));
	}
}
