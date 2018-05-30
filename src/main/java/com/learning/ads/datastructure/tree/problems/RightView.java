package com.learning.ads.datastructure.tree.problems;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.queue.Queue;
import com.learning.ads.datastructure.tree.BinaryTree;

public class RightView<T> extends BinaryTree<T> {

	private Node<T> root;
	private int currentLevel;

	public RightView(Node<T> root) {
		super(root);
		this.root = root;
		currentLevel = -1;
	}

	public T[] iterative() {
		List<T> list = new ArrayList<>();
		iterative(root, list);
		return listToArray(list);
	}

	private void iterative(Node<T> node, List<T> list) {
		if (node == null) {
			return;
		}
		Queue<Node<T>> queue = new Queue<>();
		queue.enQueue(node);
		while (!queue.isEmpty()) {
			list.add(queue.head().value);
			int size = queue.length();
			while (size > 0) {
				Node<T> element = queue.deQueue();
				if (element.right != null) {
					queue.enQueue(element.right);
				}
				if (element.left != null) {
					queue.enQueue(element.left);
				}
				size--;
			}
		}
	}

	/*
	 * https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
	 */
	public T[] recursive() {
		List<T> list = new ArrayList<>();
		recursive(root, list, 0);
		return listToArray(list);
	}

	private void recursive(Node<T> node, List<T> list, int level) {
		if (node == null) {
			return;
		}
		if (level > currentLevel) {
			list.add(node.value);
			currentLevel = level;
		}
		recursive(node.right, list, level + 1);
		recursive(node.left, list, level + 1);
	}

}
