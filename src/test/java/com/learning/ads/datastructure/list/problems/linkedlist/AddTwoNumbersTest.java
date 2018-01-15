package com.learning.ads.datastructure.list.problems.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.AddTwoNumbers;
import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;

public class AddTwoNumbersTest {

	AddTwoNumbers rll = new AddTwoNumbers();

	@Test
	public void empty() {
		assertNull(rll.add(null, null));
	}

	@Test
	public void addEqualSizes() {
		ListNode first = new ListNode(5);
		first.attach(6).attach(3);
		ListNode second = new ListNode(8);
		second.attach(4).attach(2);
		ListNode expected = new ListNode(3);
		expected.attach(1).attach(6);
		Util.assertListEqual(expected, rll.add(first, second));
	}

	@Test
	public void addUnequalSizes() {
		ListNode first = new ListNode(7);
		first.attach(5).attach(9).attach(4).attach(6);
		ListNode second = new ListNode(8);
		second.attach(4);
		ListNode expected = new ListNode(5);
		expected.attach(0).attach(0).attach(5).attach(6);
		Util.assertListEqual(expected, rll.add(first, second));
	}

	@Test
	public void additionalCarrySizes() {
		ListNode first = new ListNode(2);
		first.attach(1);
		ListNode second = new ListNode(8);
		second.attach(8);
		ListNode expected = new ListNode(0);
		expected.attach(0).attach(1);
		Util.assertListEqual(expected, rll.add(first, second));
	}

	@Test
	public void addTwoRec() {
		ListNode first = new ListNode(2);
		first.attach(3).attach(4);
		ListNode second = new ListNode(5);
		second.attach(7).attach(4);
		ListNode expected = new ListNode(0);
		expected.attach(8).attach(0).attach(8);
		Util.assertListEqual(expected, rll.sumRec(first, second));
	}

	@Test
	public void addRegWithDifferentLengthCarry() {
		ListNode second = new ListNode(9);
		second.attach(9).attach(9).attach(4).attach(6);
		ListNode first = new ListNode(9);
		first.attach(9).attach(4);
		rll.addReg(first, second);
		ListNode expected = new ListNode(1);
		expected.attach(0).attach(0).attach(9).attach(4).attach(0);
		Util.assertListEqual(expected, rll.result);
	}
	@Test
	public void addRegWithDifferentLengthNoCarry() {
		ListNode second = new ListNode(9);
		second.attach(2).attach(9).attach(4).attach(6);
		ListNode first = new ListNode(9);
		first.attach(9).attach(4);
		rll.addReg(first, second);
		ListNode expected = new ListNode(9);
		expected.attach(3).attach(9).attach(4).attach(0);
		Util.assertListEqual(expected, rll.result);
	}
	
	@Test
	public void addRegWithSameLengthNoCarry() {
		ListNode second = new ListNode(9);
		second.attach(9).attach(9);
		ListNode first = new ListNode(2);
		first.attach(9).attach(4);
		rll.addReg(first, second);
		ListNode expected = new ListNode(1);
		expected.attach(2).attach(9).attach(3);
		Util.assertListEqual(expected, rll.result);
	}
	
	@Test
	public void addRegWithSameLengthCarry() {
		ListNode second = new ListNode(5);
		second.attach(9).attach(9);
		ListNode first = new ListNode(2);
		first.attach(9).attach(4);
		rll.addReg(first, second);
		ListNode expected = new ListNode(8);
		expected.attach(9).attach(3);
		Util.assertListEqual(expected, rll.result);
	}

}
