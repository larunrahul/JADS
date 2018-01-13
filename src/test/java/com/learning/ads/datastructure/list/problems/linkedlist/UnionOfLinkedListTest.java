package com.learning.ads.datastructure.list.problems.linkedlist;

import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.UnionOfLinkedList;

public class UnionOfLinkedListTest {

	UnionOfLinkedList rll = new UnionOfLinkedList();

	@Test
	public void union() {
		ListNode first = new ListNode(10);
		first.attach(15).attach(4).attach(20);
		ListNode second = new ListNode(8);
		second.attach(4).attach(2).attach(10);
		ListNode expected = new ListNode(10);
		expected.attach(15).attach(4).attach(20).attach(8).attach(2);
		Util.assertListEqual(expected, rll.union(first, second));
	}

	@Test
	public void firstNull() {
		ListNode expected = new ListNode(8);
		expected.attach(4).attach(2).attach(10);
		ListNode second = new ListNode(8);
		second.attach(4).attach(2).attach(10);
		Util.assertListEqual(expected, rll.union(null, second));
	}

	@Test
	public void secondNull() {
		ListNode expected = new ListNode(10);
		expected.attach(15).attach(4).attach(20);
		ListNode first = new ListNode(10);
		first.attach(15).attach(4).attach(20);
		Util.assertListEqual(expected, rll.union(first, null));
	}
	
	@Test
	public void bothNull() {
		assertNull(rll.union(null, null));
	}

}
