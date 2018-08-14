package com.learning.ads.datastructure.tree.problems;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.stack.Stack;
import com.learning.ads.datastructure.tree.BinaryTree;

public class InOrderTraversal<T> extends BinaryTree<T> {

	private Node<T> root;

	public InOrderTraversal(Node<T> root) {
		super(root);
		this.root = root;
	}

	public T[] traverseIterative() {
		List<T> list = new ArrayList<>();
		if (root == null) {
			listToArray(list);
		}
		Stack<Node<T>> stack = new Stack<>();
		Node<T> currentNode = root;
		boolean done = false;
		while (!done) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if (stack.isEmpty()) {
					done = true;
				} else {
					currentNode = stack.pop();
					list.add(currentNode.value);
					currentNode = currentNode.right;
				}
			}

		}
		return listToArray(list);
	}

}
