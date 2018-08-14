package com.learning.ads.datastructure.tree.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.learning.ads.datastructure.tree.BinaryTree;

public class PreOrderTraversal<T> extends BinaryTree<T> {

	private Node<T> root;

	public PreOrderTraversal(Node<T> root) {
		super(root);
		this.root = root;
	}

	public T[] traverseIterative() {
		List<T> list = new ArrayList<>();
		if (root == null) {
			listToArray(list);
		}
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<T> element = stack.pop();
			list.add(element.value);
			if (element.right != null) {
				stack.push(element.right);
			}
			if (element.left != null) {
				stack.push(element.left);
			}
		}
		return listToArray(list);
	}

}
