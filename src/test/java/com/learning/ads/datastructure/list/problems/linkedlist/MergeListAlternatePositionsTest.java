package com.learning.ads.datastructure.list.problems.linkedlist;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.MergeListAlternatePositions;

public class MergeListAlternatePositionsTest {

	MergeListAlternatePositions rll = new MergeListAlternatePositions();

	@Test
	public void merge() {
		ListNode first = new ListNode(0);
		first.attach(2).attach(4).attach(6).attach(8);
		ListNode second = new ListNode(1);
		second.attach(3).attach(5).attach(7).attach(9);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9);
		rll.merge(first, second);
		Util.assertListEqual(expected, first);
	}

	@Test
	public void mergeInEqualFirst() {
		ListNode first = new ListNode(0);
		first.attach(2).attach(4);
		ListNode second = new ListNode(1);
		second.attach(3).attach(5).attach(7).attach(9);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(4).attach(5).attach(7).attach(9);
		rll.merge(first, second);
		Util.assertListEqual(expected, first);
	}

	@Test
	public void mergeInEqualSecond() {
		ListNode first = new ListNode(0);
		first.attach(2).attach(4).attach(6).attach(8);
		ListNode second = new ListNode(1);
		second.attach(3).attach(5);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(8);
		rll.merge(first, second);
		Util.assertListEqual(expected, first);
	}

	@Test
	public void mergeWithTwo() {
		ListNode first = new ListNode(0);
		ListNode second = new ListNode(1);
		ListNode expected = new ListNode(0);
		expected.attach(1);
		rll.merge(first, second);
		Util.assertListEqual(expected, first);
	}

	@Test
	public void mergeWithFirstNull() {
		ListNode second = new ListNode(1);
		rll.merge(null, second);
	}

	@Test
	public void mergeWithSecondNull() {
		ListNode first = new ListNode(0);
		ListNode expected = new ListNode(0);
		rll.merge(first, null);
		Util.assertListEqual(expected, first);
	}

	@Test
	public void mergeWithBothNull() {
		rll.merge(null, null);
	}
	
	@Test
	public void mergeLeft() {
		ListNode first = new ListNode(0);
		first.attach(2).attach(4).attach(6).attach(8);
		ListNode second = new ListNode(1);
		second.attach(3).attach(5).attach(7).attach(9);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9);
		rll.mergeLeft(first, second);
		Util.assertListEqual(expected, first);
	}

	@Test
	public void mergeLeftInEqualFirst() {
		ListNode first = new ListNode(0);
		first.attach(2).attach(4);
		ListNode second = new ListNode(1);
		second.attach(3).attach(5).attach(7).attach(9);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(4).attach(5);
		ListNode expectedSec = new ListNode(7);
		expectedSec.attach(9);
		rll.mergeLeft(first, second);
		Util.assertListEqual(expected, first);
		Util.assertListEqual(expectedSec, rll.second);
	}

	@Test
	public void mergeLeftInEqualSecond() {
		ListNode first = new ListNode(0);
		first.attach(2).attach(4).attach(6).attach(8);
		ListNode second = new ListNode(1);
		second.attach(3).attach(5);
		ListNode expected = new ListNode(0);
		expected.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6).attach(8);
		rll.mergeLeft(first, second);
		Util.assertListEqual(expected, first);
	}

	@Test
	public void mergeLeftWithTwo() {
		ListNode first = new ListNode(0);
		ListNode second = new ListNode(1);
		ListNode expected = new ListNode(0);
		expected.attach(1);
		rll.mergeLeft(first, second);
		Util.assertListEqual(expected, first);
	}

	@Test
	public void mergeLeftWithFirstNull() {
		ListNode second = new ListNode(1);
		rll.mergeLeft(null, second);
	}

	@Test
	public void mergeLeftWithSecondNull() {
		ListNode first = new ListNode(0);
		ListNode expected = new ListNode(0);
		rll.mergeLeft(first, null);
		Util.assertListEqual(expected, first);
	}

	@Test
	public void mergeLeftWithBothNull() {
		rll.mergeLeft(null, null);
	}

}
