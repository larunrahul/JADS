package com.learning.ads.datastructure.list.problems;

import org.junit.Test;

public class FlattenLinkedListTest {

	FlattenLinkedList rll = new FlattenLinkedList();

	@Test
	public void flattenMultiBranchRec() {
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
		Util.assertListEqual(expected, rll.flattenRec(head));
	}

	@Test
	public void flattenMultiBranch() {
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
	public void flattenLevelWiseMultiBranch() {
		ListBiNode level31 = new ListBiNode(3);
		ListBiNode level32 = new ListBiNode(19);
		level32.attach(15);
		ListBiNode level21 = new ListBiNode(2);
		ListBiNode level22 = new ListBiNode(16);
		level22.addBranch(level31);
		ListBiNode level23 = new ListBiNode(9);
		level23.addBranch(level32).attach(8);
		ListBiNode level11 = new ListBiNode(4);
		level11.attach(20).addBranch(level21).attach(13).addBranch(level22);
		ListBiNode level12 = new ListBiNode(17);
		level12.addBranch(level23).attach(6);
		ListBiNode node = new ListBiNode(10);
		node.addBranch(level11).attach(5).attach(12).attach(7).addBranch(level12).attach(11);
		ListNode expected = new ListNode(10);
		expected.attach(5).attach(12).attach(7).attach(11).attach(4).attach(20).attach(13).attach(17).attach(6)
				.attach(2).attach(16).attach(9).attach(8).attach(3).attach(19).attach(15);
		Util.assertListEqual(expected, rll.flattenLevelWise(node));
	}

	@Test
	public void flattenSingleBranchRec() {
		ListBiNode head = new ListBiNode(1);
		head.attach(2).attach(6).attach(7).attach(8);
		ListNode expected = new ListNode(1);
		expected.attach(2).attach(6).attach(7).attach(8);
		Util.assertListEqual(expected, rll.flattenRec(head));
	}

	@Test
	public void flattenSingleBranch() {
		ListBiNode head = new ListBiNode(1);
		head.attach(2).attach(6).attach(7).attach(8);
		ListNode expected = new ListNode(1);
		expected.attach(2).attach(6).attach(7).attach(8);
		Util.assertListEqual(expected, rll.flatten(head));
	}

	@Test
	public void flattenLevelWiseSingleBranch() {
		ListBiNode head = new ListBiNode(1);
		head.attach(2).attach(6).attach(7).attach(8);
		ListNode expected = new ListNode(1);
		expected.attach(2).attach(6).attach(7).attach(8);
		Util.assertListEqual(expected, rll.flattenLevelWise(head));
	}

}
