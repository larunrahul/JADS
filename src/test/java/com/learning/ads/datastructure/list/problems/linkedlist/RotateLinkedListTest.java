package com.learning.ads.datastructure.list.problems.linkedlist;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.RotateLinkedList;

public class RotateLinkedListTest {

	RotateLinkedList rll = new RotateLinkedList();

	ListNode head;

	@Before
	public void setUp() {
		head = new ListNode(1);
		head.attach(2).attach(3).attach(4).attach(5).attach(6);
	}

	@Test
	public void rotateEmptyList() {
		assertNull(rll.rotate(null, 6));
	}

	@Test
	public void rotateList() {
		ListNode expected = new ListNode(5);
		expected.attach(6).attach(1).attach(2).attach(3).attach(4);
		Util.assertListEqual(expected, rll.rotate(head, 4));
	}
	
	@Test
	public void rotateWithExactSize() {
		ListNode expected = new ListNode(1);
		expected.attach(2).attach(3).attach(4).attach(5).attach(6);
		Util.assertListEqual(expected, rll.rotate(head, 6));
	}
	
	@Test
	public void rotateWithBiggerSize() {
		ListNode expected = new ListNode(1);
		expected.attach(2).attach(3).attach(4).attach(5).attach(6);
		Util.assertListEqual(expected, rll.rotate(head, 8));
	}

}
