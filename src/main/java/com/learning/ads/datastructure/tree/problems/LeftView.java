package com.learning.ads.datastructure.tree.problems;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.queue.Queue;
import com.learning.ads.datastructure.tree.BinaryTree;

public class LeftView<T> extends BinaryTree<T> {

	Node<T> root;

	public LeftView(Node<T> root) {
		super(root);
		this.root = root;
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
				if (element.left != null) {
					queue.enQueue(element.left);
				}
				if (element.right != null) {
					queue.enQueue(element.right);
				}
				size--;
			}
		}
	}

}
