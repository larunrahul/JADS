package com.learning.ads.datastructure.tree.problems;

import com.learning.ads.datastructure.tree.BinaryTree;

public class BinaryTreeConstructor<T extends Comparable<T>> extends BinaryTree<T> {

	public BinaryTreeConstructor(Node<T> root) {
		super(root);
	}

	public Node<T> constructWithPreOrderAndInOrder(T[] inOrder, T[] preOrder) {
		return constructRecursive(inOrder, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
	}

	private Node<T> constructRecursive(T[] inOrder, T[] preOrder, int iStart, int iEnd, int pStart, int pEnd) {
		if (iEnd - iStart < 0 || pEnd - pStart < 0) {
			return null;
		}
		int current = iStart;
		while (current >= 0 && current < preOrder.length && !inOrder[current].equals(preOrder[pStart])) {
			current++;
		}
		Node<T> root = new Node<T>(preOrder[pStart]);
		root.left = constructRecursive(inOrder, preOrder, iStart, current - 1, pStart + 1, pStart + current - iStart);
		root.right = constructRecursive(inOrder, preOrder, current + 1, iEnd, pStart + current - iStart + 1, pEnd);
		return root;
	}

}
