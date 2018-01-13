package com.learning.ads.datastructure.list.problems.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.IntersectionOfTwoLinkedList;
import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;

public class IntersectionOfTwoLinkedListTest {

	IntersectionOfTwoLinkedList rll = new IntersectionOfTwoLinkedList();

	@Test
	public void findIntersection() {
		ListNode iPoint = new ListNode(6);
		iPoint.attach(7).attach(8);
		ListNode first = new ListNode(1);
		first.attach(2).attach(3).attach(4).attach(5).attach(iPoint);
		ListNode second = new ListNode(9);
		second.attach(10).attach(iPoint);
		assertEquals(6, rll.findIntersection(first, second));
	}
	
	@Test
	public void findIntersectionWithSingleElement() {
		ListNode iPoint = new ListNode(6);
		iPoint.attach(7).attach(8);
		ListNode first = new ListNode(1);
		first.attach(iPoint);
		ListNode second = new ListNode(9);
		second.attach(iPoint);
		assertEquals(6, rll.findIntersection(first, second));
	}
	
	@Test
	public void findIntersectionWithNoIntersection() {
		ListNode iPoint = new ListNode(6);
		iPoint.attach(7).attach(8);
		ListNode first = new ListNode(1);
		first.attach(2).attach(3).attach(4).attach(5).attach(iPoint);
		ListNode second = new ListNode(9);
		second.attach(10).attach(11);
		assertEquals(-1, rll.findIntersection(first, second));
	}
	
	@Test
	public void findIntersectionWithNull() {
		ListNode iPoint = new ListNode(6);
		iPoint.attach(7).attach(8);
		ListNode first = new ListNode(1);
		first.attach(2).attach(3).attach(4).attach(5).attach(iPoint);
		assertEquals(-1, rll.findIntersection(first, null));
	}
	
	@Test
	public void findIntersectionCircle() {
		ListNode iPoint = new ListNode(6);
		iPoint.attach(7).attach(8);
		ListNode first = new ListNode(1);
		first.attach(2).attach(3).attach(4).attach(5).attach(iPoint);
		ListNode second = new ListNode(9);
		second.attach(10).attach(iPoint);
		assertEquals(6, rll.finIntersectionCircle(first, second));
	}

	@Test
	public void findIntersectionCircleWithSingleElement() {
		ListNode iPoint = new ListNode(6);
		iPoint.attach(7).attach(8);
		ListNode first = new ListNode(1);
		first.attach(iPoint);
		ListNode second = new ListNode(9);
		second.attach(iPoint);
		assertEquals(6, rll.finIntersectionCircle(first, second));
	}
	
	@Test
	public void findIntersectionCircleWithNoIntersection() {
		ListNode iPoint = new ListNode(6);
		iPoint.attach(7).attach(8);
		ListNode first = new ListNode(1);
		first.attach(2).attach(3).attach(4).attach(5).attach(iPoint);
		ListNode second = new ListNode(9);
		second.attach(10).attach(11);
		assertEquals(-1, rll.finIntersectionCircle(first, second));
	}
	
	@Test
	public void findIntersectionCircleWithNull() {
		ListNode iPoint = new ListNode(6);
		iPoint.attach(7).attach(8);
		ListNode first = new ListNode(1);
		first.attach(2).attach(3).attach(4).attach(5).attach(iPoint);
		assertEquals(-1, rll.finIntersectionCircle(first, null));
	}
}
