package com.learning.ads.datastructure.tree.problems;

import com.learning.ads.datastructure.tree.BinaryTree;

public class MaxMinElement<T extends Comparable<T>> extends BinaryTree<T> {

	Node<T> root;

	public MaxMinElement(Node<T> root) {
		super(root);
		this.root = root;
	}

	public T getMin() {
		Node<T> node = getMin(root);
		return node != null ? node.value : null;
	}

	private Node<T> getMin(Node<T> node) {
		if (node == null) {
			return null;
		}
		return getMin(getMin(node.left), node, getMin(node.right));
	}

	private Node<T> getMin(Node<T> left, Node<T> mid, Node<T> right) {
		if (left == null && right != null) {
			return getMin(mid, right);
		}
		if (left != null && right == null) {
			return getMin(left, mid);
		}
		if (left == null || right == null) {
			return mid;
		}
		return left.value.compareTo(mid.value) < 0 ? (left.value.compareTo(right.value) < 0 ? left : right)
				: (mid.value.compareTo(right.value) < 0 ? mid : right);
	}

	private Node<T> getMin(Node<T> left, Node<T> right) {
		return left.value.compareTo(right.value) < 0 ? left : right;
	}

	public T getMax() {
		Node<T> node = getMax(root);
		return node != null ? node.value : null;
	}

	private Node<T> getMax(Node<T> node) {
		if (node == null) {
			return null;
		}
		return getMax(getMax(node.left), node, getMax(node.right));
	}

	private Node<T> getMax(Node<T> left, Node<T> mid, Node<T> right) {
		if (left == null && right != null) {
			return getMax(mid, right);
		}
		if (left != null && right == null) {
			return getMax(left, mid);
		}
		if (left == null || right == null) {
			return mid;
		}
		return left.value.compareTo(mid.value) >= 0 ? (left.value.compareTo(right.value) >= 0 ? left : right)
				: (mid.value.compareTo(right.value) >= 0 ? mid : right);
	}

	private Node<T> getMax(Node<T> left, Node<T> right) {
		return left.value.compareTo(right.value) >= 0 ? left : right;
	}

}
