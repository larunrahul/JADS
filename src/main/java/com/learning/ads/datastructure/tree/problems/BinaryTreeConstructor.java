package com.learning.ads.datastructure.tree.problems;

import com.learning.ads.datastructure.tree.BinaryTree;

public class BinaryTreeConstructor<T extends Comparable<T>> extends BinaryTree<T> {

	public BinaryTreeConstructor(Node<T> root) {
		super(root);
	}

	public Node<T> constructWithPreOrderAndInOrder(T[] inOrder, T[] preOrder) {
		return constructRecursiveWithPreOrderAndInOrder(inOrder, preOrder, 0, inOrder.length - 1, 0,
				preOrder.length - 1);
	}

	private Node<T> constructRecursiveWithPreOrderAndInOrder(T[] preOrder, T[] inOrder, int iStart, int iEnd,
			int pStart, int pEnd) {
		if (iEnd - iStart < 0 || pEnd - pStart < 0) {
			return null;
		}
		int current = iStart;
		while (current >= 0 && current < preOrder.length && !inOrder[current].equals(preOrder[pStart])) {
			current++;
		}
		Node<T> root = new Node<T>(preOrder[pStart]);
		root.left = constructRecursiveWithPreOrderAndInOrder(inOrder, preOrder, iStart, current - 1, pStart + 1,
				pStart + current - iStart);
		root.right = constructRecursiveWithPreOrderAndInOrder(inOrder, preOrder, current + 1, iEnd,
				pStart + current - iStart + 1, pEnd);
		return root;
	}

	public Node<T> constructWithInOrderAndPostOrder(T[] inOrder, T[] postOrder) {
		return constructRecursiveWithInOrderAndPostOrder(inOrder, postOrder, 0, inOrder.length - 1,
				postOrder.length - 1, 0);
	}

	private Node<T> constructRecursiveWithInOrderAndPostOrder(T[] inOrder, T[] postOrder, int iStart, int iEnd,
			int pStart, int pEnd) {
		if (iEnd - iStart < 0 || pStart - pEnd < 0) {
			return null;
		}
		int current = iStart;
		while (current >= 0 && current < postOrder.length && !inOrder[current].equals(postOrder[pStart])) {
			current++;
		}
		Node<T> root = new Node<T>(postOrder[pStart]);
		root.right = constructRecursiveWithInOrderAndPostOrder(inOrder, postOrder, current + 1, iEnd, pStart - 1,
				pStart + current - iEnd);
		root.left = constructRecursiveWithInOrderAndPostOrder(inOrder, postOrder, iStart, current - 1,
				pStart + current - iEnd - 1, pEnd);
		return root;
	}

}
