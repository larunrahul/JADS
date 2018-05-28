package com.learning.ads.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.queue.Queue;

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

		public String toString() {
			return value + " ";
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

	public T[] preOrderTraversal() {
		List<T> list = new ArrayList<>();
		preOrderTraversal(root, list);
		return listToArray(list);
	}

	private void preOrderTraversal(Node<T> node, List<T> list) {
		if (node == null) {
			return;
		}
		list.add(node.value);
		preOrderTraversal(node.left, list);
		preOrderTraversal(node.right, list);

	}

	public T[] postOrderTraversal() {
		List<T> list = new ArrayList<>();
		postOrderTraversal(root, list);
		return listToArray(list);
	}

	private void postOrderTraversal(Node<T> node, List<T> list) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left, list);
		postOrderTraversal(node.right, list);
		list.add(node.value);

	}

	public T[] inOrderTraversal() {
		List<T> list = new ArrayList<>();
		inOrderTraversal(root, list);
		return listToArray(list);
	}

	private void inOrderTraversal(Node<T> node, List<T> list) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left, list);
		list.add(node.value);
		inOrderTraversal(node.right, list);
	}

	public T[] levelOrderTraversal() {
		List<T> list = new ArrayList<>();
		Queue<Node<T>> queue = new Queue<>();
		levelOrderTraversal(root, list, queue);
		return listToArray(list);
	}

	private void levelOrderTraversal(Node<T> node, List<T> list, Queue<Node<T>> queue) {
		if (node == null) {
			return;
		}
		list.add(node.value);
		queue.enQueue(node.left);
		queue.enQueue(node.right);
		levelOrderTraversal(queue.deQueue(), list, queue);
		levelOrderTraversal(queue.deQueue(), list, queue);
	}

	@SuppressWarnings("unchecked")
	private T[] listToArray(List<T> list) {
		return (T[]) list.toArray();
	}

}
