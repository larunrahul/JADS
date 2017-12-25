package com.learning.ads.datastructure.list.problems;

import org.junit.Test;

public class FlattenLinkedListTest {

	FlattenLinkedList rll = new FlattenLinkedList();

	@Test
	public void multiBranch() {
		ListBiNode firstBranch = new ListBiNode(3);
		firstBranch.attach(4).attach(5);
		ListBiNode subBranch = new ListBiNode(12);
		subBranch.attach(13).attach(14).attach(15).attach(16);
		ListBiNode secondBranch = new ListBiNode(9);
		secondBranch.attach(10).attach(11).addBranch(subBranch).attach(17).attach(18);
		ListBiNode head = new ListBiNode(1);
		head.attach(2).addBranch(firstBranch).attach(6).attach(7).attach(8).addBranch(secondBranch);
		ListNode expected = new ListNode(1);
		expected.attach(2).attach(3).attach(4).attach(5).attach(6).attach(7).attach(8).attach(9).attach(10).attach(11)
				.attach(12).attach(13).attach(14).attach(15).attach(16).attach(17).attach(18);
		Util.assertListEqual(expected, rll.flatten(head));
	}

	@Test
	public void singleBranch() {
		ListBiNode head = new ListBiNode(1);
		head.attach(2).attach(6).attach(7).attach(8);
		ListNode expected = new ListNode(1);
		expected.attach(2).attach(6).attach(7).attach(8);
		Util.assertListEqual(expected, rll.flatten(head));
	}

}
