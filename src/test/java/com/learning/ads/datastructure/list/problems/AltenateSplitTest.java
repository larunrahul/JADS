package com.learning.ads.datastructure.list.problems;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AltenateSplitTest {

	AltenateSplit rll = new AltenateSplit();

	@Test
	public void splitEven() {
		ListNode head = new ListNode(0);
		head.attach(1).attach(2).attach(3).attach(4).attach(5);
		ListNode[] result = rll.alternateSplit(head);
		ListNode expectedFirst = new ListNode(0);
		expectedFirst.attach(2).attach(4);
		ListNode expectedSecond = new ListNode(1);
		expectedSecond.attach(3).attach(5);
		Util.assertListEqual(expectedFirst, result[0]);
		Util.assertListEqual(expectedSecond, result[1]);
	}

	@Test
	public void splitOdd() {
		ListNode head = new ListNode(0);
		head.attach(1).attach(2).attach(3).attach(4).attach(5).attach(6);
		ListNode[] result = rll.alternateSplit(head);
		ListNode expectedFirst = new ListNode(0);
		expectedFirst.attach(2).attach(4).attach(6);
		ListNode expectedSecond = new ListNode(1);
		expectedSecond.attach(3).attach(5);
		Util.assertListEqual(expectedFirst, result[0]);
		Util.assertListEqual(expectedSecond, result[1]);
	}

	@Test
	public void splitWithTwoElements() {
		ListNode head = new ListNode(0);
		head.attach(1);
		ListNode[] result = rll.alternateSplit(head);
		ListNode expectedFirst = new ListNode(0);
		ListNode expectedSecond = new ListNode(1);
		Util.assertListEqual(expectedFirst, result[0]);
		Util.assertListEqual(expectedSecond, result[1]);
	}

	@Test
	public void splitWithSingleElement() {
		ListNode head = new ListNode(0);
		ListNode[] result = rll.alternateSplit(head);
		ListNode expectedFirst = new ListNode(0);
		Util.assertListEqual(expectedFirst, result[0]);
		assertNull(result[1]);
	}

}
