package com.learning.ads.datastructure.list.problems.linkedlist;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.MergeTwoSortedLinkedList;

import static org.junit.Assert.assertNull;

public class MergeTwoSortedLinkedListTest {

	private MergeTwoSortedLinkedList rll = new MergeTwoSortedLinkedList();

	@Test
	public void mergeWithLargeFirstList() {
		ListNode first = new ListNode(4);
		first.attach(5).attach(6).attach(8).attach(10).attach(11).attach(12);
		ListNode second = new ListNode(1);
		second.attach(2).attach(3).attach(7).attach(9);

		ListNode expected = new ListNode(1);
		expected.attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10).attach(11)
				.attach(12);

		ListNode actual = rll.merge(first, second);

		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeWithLargeSecondList() {
		ListNode first = new ListNode(2);
		first.attach(4).attach(6).attach(8).attach(10);
		ListNode second = new ListNode(1);
		second.attach(3).attach(5).attach(7).attach(9).attach(11).attach(12);

		ListNode expected = new ListNode(1);
		expected.attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10).attach(11)
				.attach(12);

		ListNode actual = rll.merge(first, second);

		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeWithFirstListNull() {
		ListNode second = new ListNode(1);
		second.attach(3).attach(5).attach(7).attach(9).attach(11).attach(12);

		ListNode expected = new ListNode(1);
		expected.attach(3).attach(5).attach(7).attach(9).attach(11).attach(12);

		ListNode actual = rll.merge(null, second);
		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeWithSecondListNull() {
		ListNode first = new ListNode(2);
		first.attach(4).attach(6).attach(8).attach(10);

		ListNode expected = new ListNode(2);
		expected.attach(4).attach(6).attach(8).attach(10);

		ListNode actual = rll.merge(first, null);
		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeWithBothListsNull() {
		assertNull(rll.merge(null, null));
	}

	@Test
	public void mergeRecWithLargeFirstList() {
		ListNode first = new ListNode(4);
		first.attach(5).attach(6).attach(8).attach(10).attach(11).attach(12);
		ListNode second = new ListNode(1);
		second.attach(2).attach(3).attach(7).attach(9);

		ListNode expected = new ListNode(1);
		expected.attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10).attach(11)
				.attach(12);

		ListNode actual = rll.mergeRec(first, second);

		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeRecWithLargeSecondList() {
		ListNode first = new ListNode(2);
		first.attach(4).attach(6).attach(8).attach(10);
		ListNode second = new ListNode(1);
		second.attach(3).attach(5).attach(7).attach(9).attach(11).attach(12);

		ListNode expected = new ListNode(1);
		expected.attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10).attach(11)
				.attach(12);

		ListNode actual = rll.mergeRec(first, second);

		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeRecWithFirstListNull() {
		ListNode second = new ListNode(1);
		second.attach(3).attach(5).attach(7).attach(9).attach(11).attach(12);

		ListNode expected = new ListNode(1);
		expected.attach(3).attach(5).attach(7).attach(9).attach(11).attach(12);

		ListNode actual = rll.mergeRec(null, second);
		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeRecWithSecondListNull() {
		ListNode first = new ListNode(2);
		first.attach(4).attach(6).attach(8).attach(10);

		ListNode expected = new ListNode(2);
		expected.attach(4).attach(6).attach(8).attach(10);

		ListNode actual = rll.mergeRec(first, null);
		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeRecWithBothListsNull() {
		assertNull(rll.merge(null, null));
	}

}
