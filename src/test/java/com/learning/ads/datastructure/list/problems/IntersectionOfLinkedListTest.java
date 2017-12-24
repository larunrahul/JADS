package com.learning.ads.datastructure.list.problems;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class IntersectionOfLinkedListTest {

	IntersectionOfLikedList rll = new IntersectionOfLikedList();

	@Test
	public void union() {
		ListNode first = new ListNode(10);
		first.attach(15).attach(4).attach(20);
		ListNode second = new ListNode(8);
		second.attach(4).attach(2).attach(10);
		ListNode expected = new ListNode(4);
		expected.attach(10);
		Util.assertListEqual(expected, rll.intersection(first, second));
	}

	@Test
	public void firstNull() {
		ListNode expected = new ListNode(8);
		expected.attach(4).attach(2).attach(10);
		ListNode second = new ListNode(8);
		second.attach(4).attach(2).attach(10);
		assertNull(rll.intersection(null, second));
	}

	@Test
	public void secondNull() {
		ListNode expected = new ListNode(10);
		expected.attach(15).attach(4).attach(20);
		ListNode first = new ListNode(10);
		first.attach(15).attach(4).attach(20);
		assertNull(rll.intersection(first, null));
	}

	@Test
	public void bothNull() {
		assertNull(rll.intersection(null, null));
	}

}
