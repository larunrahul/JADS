package com.learning.ads.datastructure.list.problems;

public class ListBiNode {
	public int value;
	public ListBiNode next;
	public ListBiNode down;

	ListBiNode(int value) {
		this.value = value;
	}

	ListBiNode attach(ListBiNode next) {
		this.next = next;
		return this.next;
	}

	ListBiNode addBranch(ListBiNode branch) {
		this.down = branch;
		return this;
	}

	ListBiNode attach(int value) {
		return this.attach(new ListBiNode(value));
	}

}
