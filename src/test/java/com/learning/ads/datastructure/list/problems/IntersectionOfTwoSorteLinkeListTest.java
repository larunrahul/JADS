package com.learning.ads.datastructure.list.problems;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class IntersectionOfTwoSorteLinkeListTest {

	IntersectionOfTwoSorteLinkeList rll = new IntersectionOfTwoSorteLinkeList();

	@Test
	public void intersectionWithBiggestFirstList() {
		ListNode first = new ListNode(1);
		first.attach(2).attach(3).attach(4).attach(5).attach(6);
		ListNode second = new ListNode(2);
		second.attach(4).attach(6).attach(8);
		ListNode expected = new ListNode(2);
		expected.attach(4).attach(6);
		Util.assertListEqual(expected, rll.intersection(first, second));
	}

	@Test
	public void intersectionWithBiggestSecondList() {
		ListNode second = new ListNode(1);
		second.attach(2).attach(3).attach(4).attach(5).attach(6);
		ListNode first = new ListNode(2);
		first.attach(4).attach(6).attach(8);
		ListNode expected = new ListNode(2);
		expected.attach(4).attach(6);
		Util.assertListEqual(expected, rll.intersection(first, second));
	}

	@Test
	public void intersectionWithAllMatching() {
		ListNode second = new ListNode(1);
		second.attach(2).attach(3).attach(4).attach(5).attach(6);
		ListNode first = new ListNode(1);
		first.attach(2).attach(3).attach(4).attach(5).attach(6);
		ListNode expected = new ListNode(1);
		expected.attach(2).attach(3).attach(4).attach(5).attach(6);
		Util.assertListEqual(expected, rll.intersection(first, second));
	}

	@Test
	public void intersectionWithUnMatching() {
		ListNode second = new ListNode(2);
		second.attach(4).attach(6).attach(8);
		ListNode first = new ListNode(1);
		first.attach(3).attach(5).attach(7).attach(9).attach(11);
		assertNull(rll.intersection(first, second));
	}

	@Test
	public void intersectionWithSingleElementList() {
		ListNode second = new ListNode(1);
		ListNode first = new ListNode(1);
		ListNode expected = new ListNode(1);
		Util.assertListEqual(expected, rll.intersection(first, second));
	}

	@Test
	public void intersectionWithSingleElementListUnmatching() {
		ListNode second = new ListNode(1);
		ListNode first = new ListNode(2);
		assertNull(rll.intersection(first, second));
	}

}
