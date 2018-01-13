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
		Util.toString(rll.move(head));
	}
	
	@Test
	public void moveOdd() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4).attach(5);
		Util.toString(rll.move(head));
	}
	
	@Test
	public void moveMinEven() {
		ListNode head = new ListNode(1);
		head.attach(2);
		Util.toString(rll.move(head));
	}
	
	@Test
	public void moveMinOdd() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3);
		Util.toString(rll.move(head));
	}
	
	@Test
	public void moveSingle() {
		ListNode head = new ListNode(1);
		Util.toString(rll.move(head));
	}

}
