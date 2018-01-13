package com.learning.ads.datastructure.list.problems.linkedlist;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.SortNodesInChronologicalOrder;

public class SortNodesInChronologicalOrderTest {

	SortNodesInChronologicalOrder rll = new SortNodesInChronologicalOrder();

	@Test
	public void sort() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(0).attach(0).attach(2).attach(1).attach(1).attach(2).attach(0).attach(1).attach(1);
		ListNode expected = new ListNode(0);
		expected.attach(0).attach(0).attach(1).attach(1).attach(1).attach(1).attach(1).attach(2).attach(2).attach(2);
		Util.assertListEqual(expected, rll.sort(head));
	}

	@Test
	public void onlyZeroes() {
		ListNode head = new ListNode(0);
		head.attach(0).attach(0).attach(0);
		ListNode expected = new ListNode(0);
		expected.attach(0).attach(0).attach(0);
		Util.assertListEqual(expected, rll.sort(head));
	}

	@Test
	public void onlyOnes() {
		ListNode head = new ListNode(1);
		head.attach(1).attach(1).attach(1);
		ListNode expected = new ListNode(1);
		expected.attach(1).attach(1).attach(1);
		Util.assertListEqual(expected, rll.sort(head));
	}

	@Test
	public void onlyTwos() {
		ListNode head = new ListNode(2);
		head.attach(2).attach(2).attach(2);
		ListNode expected = new ListNode(2);
		expected.attach(2).attach(2).attach(2);
		Util.assertListEqual(expected, rll.sort(head));
	}

	@Test
	public void onlyZeroesOnes() {
		ListNode head = new ListNode(1);
		head.attach(0).attach(0).attach(1);
		ListNode expected = new ListNode(0);
		expected.attach(0).attach(1).attach(1);
		Util.assertListEqual(expected, rll.sort(head));
	}

	@Test
	public void onlyZeroesTwos() {
		ListNode head = new ListNode(2);
		head.attach(0).attach(2).attach(0);
		ListNode expected = new ListNode(0);
		expected.attach(0).attach(2).attach(2);
		Util.assertListEqual(expected, rll.sort(head));
	}

	@Test
	public void onlyOnesTwos() {
		ListNode head = new ListNode(2);
		head.attach(1).attach(1).attach(2);
		ListNode expected = new ListNode(1);
		expected.attach(1).attach(2).attach(2);
		Util.assertListEqual(expected, rll.sort(head));
	}

}
