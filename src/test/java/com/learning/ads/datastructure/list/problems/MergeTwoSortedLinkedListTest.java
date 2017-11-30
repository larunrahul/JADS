package com.learning.ads.datastructure.list.problems;

import org.junit.Test;
import static org.junit.Assert.assertNull;

public class MergeTwoSortedLinkedListTest {

	private MergeTwoSortedLinkedList rll = new MergeTwoSortedLinkedList();

	@Test
	public void mergeWithLargeFirstList() {
		ListNode first = new ListNode(4);
		first.attach(new ListNode(5)).attach(new ListNode(6)).attach(new ListNode(8)).attach(new ListNode(10))
				.attach(new ListNode(11)).attach(new ListNode(12));
		ListNode second = new ListNode(1);
		second.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(7)).attach(new ListNode(9));

		ListNode expected = new ListNode(1);
		expected.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4)).attach(new ListNode(5))
				.attach(new ListNode(6)).attach(new ListNode(7)).attach(new ListNode(8)).attach(new ListNode(9))
				.attach(new ListNode(10)).attach(new ListNode(11)).attach(new ListNode(12));

		ListNode actual = rll.merge(first, second);

		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeWithLargeSecondList() {
		ListNode first = new ListNode(2);
		first.attach(new ListNode(4)).attach(new ListNode(6)).attach(new ListNode(8)).attach(new ListNode(10));
		ListNode second = new ListNode(1);
		second.attach(new ListNode(3)).attach(new ListNode(5)).attach(new ListNode(7)).attach(new ListNode(9))
				.attach(new ListNode(11)).attach(new ListNode(12));

		ListNode expected = new ListNode(1);
		expected.attach(new ListNode(2)).attach(new ListNode(3)).attach(new ListNode(4)).attach(new ListNode(5))
				.attach(new ListNode(6)).attach(new ListNode(7)).attach(new ListNode(8)).attach(new ListNode(9))
				.attach(new ListNode(10)).attach(new ListNode(11)).attach(new ListNode(12));

		ListNode actual = rll.merge(first, second);

		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeWithFirstListNull() {
		ListNode second = new ListNode(1);
		second.attach(new ListNode(3)).attach(new ListNode(5)).attach(new ListNode(7)).attach(new ListNode(9))
				.attach(new ListNode(11)).attach(new ListNode(12));

		ListNode expected = new ListNode(1);
		expected.attach(new ListNode(3)).attach(new ListNode(5)).attach(new ListNode(7)).attach(new ListNode(9))
				.attach(new ListNode(11)).attach(new ListNode(12));

		ListNode actual = rll.merge(null, second);
		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeWithSecondListNull() {
		ListNode first = new ListNode(2);
		first.attach(new ListNode(4)).attach(new ListNode(6)).attach(new ListNode(8)).attach(new ListNode(10));

		ListNode expected = new ListNode(2);
		expected.attach(new ListNode(4)).attach(new ListNode(6)).attach(new ListNode(8)).attach(new ListNode(10));

		ListNode actual = rll.merge(first, null);
		Util.assertListEqual(expected, actual);
	}

	@Test
	public void mergeWithBothListsNull() {
		assertNull(rll.merge(null, null));
	}

}
