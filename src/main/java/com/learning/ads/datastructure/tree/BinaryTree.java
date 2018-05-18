package com.learning.ads.datastructure.tree;

public class BinaryTree<T> {

	private Node<T> root;

	private int length;

	static class Node<T> {

		T value;
		Node<T> left;
		Node<T> right;

		public Node(T value) {
			this.value = value;
		}

		public Node(Node<T> left, T value, Node<T> right) {
			this.left = left;
			this.value = value;
			this.right = right;
		}
	}

	public int height() {
		return 0;
	}

	public int depth() {
		return height();
	}

}
