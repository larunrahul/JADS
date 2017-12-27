package com.learning.ads.datastructure.list.problems;

public class AddTwoNumbers {

	/**
	 * Two numbers are represented in rear to front fashion. For example 563 is
	 * represented as 3-->6-->5
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public ListNode add(ListNode first, ListNode second) {
		ListNode result = new ListNode(-1), tail = result;
		int carry = 0;
		while (first != null || second != null) {
			int sum = 0;
			if (first != null) {
				sum += first.value;
				first = first.next;
			}
			if (second != null) {
				sum += second.value;
				second = second.next;
			}
			sum += carry;
			carry = sum >= 10 ? 1 : 0;
			tail.next = new ListNode(sum % 10);
			tail = tail.next;
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return result.next;
	}

	public ListNode result;

	/**
	 * Two numbers are represented in front to rear fashion. For example 563 is
	 * represented as 5-->6-->3
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public void addReg(ListNode first, ListNode second) {
		ListNode f = first, s = second;
		int firstLength = 0, secondLength = 0;
		while (f != null) {
			firstLength++;
			f = f.next;
		}
		while (s != null) {
			secondLength++;
			s = s.next;
		}
		if (firstLength == secondLength) {
			// calculate sum as both the lists are of same length
			result = sumRec(first, second);
		} else {
			// swap pointers to lists so that first list is always big
			if (firstLength < secondLength) {
				ListNode temp = second;
				second = first;
				first = temp;
			}
			ListNode prev = first;
			f = first;
			int diff = Math.abs(firstLength - secondLength);
			// move first list pointer so that both first and second lists are of same length
			while (diff-- > 0) {
				prev = first;
				first = first.next;
			}
			// cut the list at 'first' so that it can be sent individually to sumRec
			prev.next = null;
			// calculate sum as both the lists are of same length
			result = sumRec(first, second);
			// add the previous result and 'f' (which contains all the pointers till before 'first'
			addCarryToSum(f);
		}
		if (result.value == 0) {
			result = result.next;
		}
	}

	/**
	 * Recursively add two numbers of same size represented as linked list in front
	 * to rear fashion. For example 563 is represented as 5-->6-->3
	 * 
	 * @param first
	 *            : First number represented as LinkedList. For example, 563 as
	 *            5-->6-->3
	 * @param second:
	 *            Second number represented as LinkedList. For example 468 as
	 *            4-->6-->8
	 * @return: Result of sum of first and second represented as LinkedList. For
	 *          example 563 + 468 = 1031 as 1-->0-->3-->1
	 */
	public ListNode sumRec(ListNode first, ListNode second) {
		if (first == null) {
			return new ListNode(0);
		}
		ListNode next = sumRec(first.next, second.next);
		int sum = first.value + second.value + next.value;
		next.value = sum % 10;
		ListNode result = new ListNode(sum >= 10 ? 1 : 0);
		result.attach(next);
		return result;
	}

	public void addCarryToSum(ListNode first) {
		if (first == null) {
			return;
		}
		addCarryToSum(first.next);
		int sum = first.value + result.value;
		result.value = sum % 10;
		ListNode temp = new ListNode(sum >= 10 ? 1 : 0);
		temp.attach(result);
		result = temp;
	}
}
