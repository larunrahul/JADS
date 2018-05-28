package com.learning.ads.datastructure.tree;

public class BinaryTree<T> {

	private Node<T> root;

	public BinaryTree(Node<T> root) {
		this.root = root;
	}

	protected static class Node<T> {

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
		return height(root);
	}

	/**
	 * Complexity: O(n) where n is the number of nodes in binary tree
	 * 
	 * @param node
	 * @return
	 */
	public int height(Node<T> node) {
		if (node == null) {
			return 0;
		}
		return Math.max(height(node.left), height(node.right)) + (node.left != null || node.right != null ? 1 : 0);
	}

	public int depth() {
		return height();
	}

	public boolean contains(Object o) {
		return false;
	}

	public int levels() {
		if (root == null) {
			return 0;
		}
		return height() + 1;
	}

}
