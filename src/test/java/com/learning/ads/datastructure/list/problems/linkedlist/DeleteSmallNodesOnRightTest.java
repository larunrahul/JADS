package com.learning.ads.datastructure.list.problems;

import org.junit.Test;

public class DeleteSmallNodesOnRightTest {
	
	DeleteSmallNodesOnRight rll = new DeleteSmallNodesOnRight();

	@Test
	public void delete() {
		ListNode head = new ListNode(12);
		head.attach(15).attach(10).attach(11).attach(5).attach(6).attach(2).attach(3);
		ListNode expected = new ListNode(15);
		expected.attach(11).attach(6).attach(3);
		Util.assertListEqual(expected, rll.delete(head));
	}
	
	@Test
	public void deleteAscendingList() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4).attach(5).attach(6);
		ListNode expected = new ListNode(6);
		Util.assertListEqual(expected, rll.delete(head));
	}
	
	@Test
	public void deleteDecendingList() {
		ListNode head = new ListNode(6);
		head.attach(5).attach(4).attach(3).attach(2).attach(1);
		ListNode expected = new ListNode(6);
		expected.attach(5).attach(4).attach(3).attach(2).attach(1);
		Util.assertListEqual(expected, rll.delete(head));
	}

}
