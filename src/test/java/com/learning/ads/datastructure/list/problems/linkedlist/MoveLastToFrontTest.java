package com.learning.ads.datastructure.list.problems.linkedlist;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.MoveLastToFront;

public class MoveLastToFrontTest {

	MoveLastToFront rll = new MoveLastToFront();

	@Test
	public void moveEven() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4);
		ListNode expected = new ListNode(4);
		expected.attach(1).attach(2).attach(3);
		Util.assertListEqual(expected, rll.move(head));
	}

	@Test
	public void moveOdd() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4).attach(5);
		ListNode expected = new ListNode(5);
		expected.attach(1).attach(2).attach(3).attach(4);
		Util.assertListEqual(expected, rll.move(head));
	}

	@Test
	public void moveMinEven() {
		ListNode head = new ListNode(1);
		head.attach(2);
		ListNode expected = new ListNode(2);
		expected.attach(1);
		Util.assertListEqual(expected, rll.move(head));
	}

	@Test
	public void moveMinOdd() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3);
		ListNode expected = new ListNode(3);
		expected.attach(1).attach(2);
		Util.assertListEqual(expected, rll.move(head));
	}

	@Test
	public void moveSingle() {
		ListNode head = new ListNode(1);
		ListNode expected = new ListNode(1);
		Util.assertListEqual(expected, rll.move(head));
	}

}
