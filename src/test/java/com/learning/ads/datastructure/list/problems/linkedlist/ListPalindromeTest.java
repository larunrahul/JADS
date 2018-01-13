package com.learning.ads.datastructure.list.problems.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import com.learning.ads.datastructure.list.problems.linkedlist.ListNode;
import com.learning.ads.datastructure.list.problems.linkedlist.ListPalindrome;

public class ListPalindromeTest {
	
	private ListPalindrome rll = new ListPalindrome();

	@Test
	public void midForOdd() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(4).attach(3).attach(2).attach(1);
		assertTrue(rll.isPalindrome(head));
	}
	
	@Test
	public void midForEven() {
		ListNode head = new ListNode(1);
		head.attach(2).attach(3).attach(3).attach(2).attach(1);
		assertTrue(rll.isPalindrome(head));
	}

}
