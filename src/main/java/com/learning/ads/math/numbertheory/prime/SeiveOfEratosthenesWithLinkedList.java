package com.learning.ads.math.numbertheory.prime;

import com.learning.ads.element.ListNode;

public class SeiveOfEratosthenesWithLinkedList {

	private ListNode list;

	public SeiveOfEratosthenesWithLinkedList(int limit) {
		ListNode current = new ListNode(0);
		list = current;
		for (int value = 2; value <= limit; value++) {
			current.next = new ListNode(value);
			current = current.next;
		}
		list = list.next;
	}

	public void findPrimes() {
		ListNode temp = list;
		while (temp != null) {
			ListNode next = temp.next;
			ListNode prev = temp;
			while (next != null) {
				if (next.value % temp.value == 0) {
					prev.next = next.next;
				} else {
					prev = prev.next;
				}
				next = next.next;
			}
			temp = temp.next;
		}
	}

	private void printList() {
		ListNode temp = list;
		while (temp != null) {
			System.out.print(temp.value + "\t");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SeiveOfEratosthenesWithLinkedList soe = new SeiveOfEratosthenesWithLinkedList(10000);
		soe.findPrimes();
		soe.printList();
	}

}
