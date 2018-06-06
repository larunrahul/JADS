package com.learning.ads.datastructure.tree.problems;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.stack.Stack;
import com.learning.ads.datastructure.tree.BinaryTree;

public class PostOrderTraversal<T> extends BinaryTree<T> {

	private Node<T> root;

	public PostOrderTraversal(Node<T> root) {
		super(root);
		this.root = root;
	}

	public T[] traverseRecursive() {
		List<T> list = new ArrayList<>();
		traverseRecursive(root, list);
		return listToArray(list);
	}

	private void traverseRecursive(Node<T> node, List<T> list) {
		if (node == null) {
			return;
		}
		traverseRecursive(node.left, list);
		traverseRecursive(node.right, list);
		list.add(node.value);
	}

	public T[] traverseIterative() {
		List<T> list = new ArrayList<>();
		if (root == null) {
			listToArray(list);
		}
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);
		Node<T> prev = null;
		while (!stack.isEmpty()) {
			Node<T> current = stack.peek();
			if (prev == null || prev.left == current || prev.right == current) {
				if (current.left != null) {
					stack.push(current.left);
				} else if (current.right != null) {
					stack.push(current.right);
				}
			} else if (current.left == prev) {
				if (current.right != null) {
					stack.push(current.right);
				}
			} else {
				list.add(current.value);
				stack.pop();
			}
			prev = current;
		}
		return listToArray(list);
	}

}
