package com.learning.ads.datastructure.tree.problems;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.queue.Queue;
import com.learning.ads.datastructure.tree.BinaryTree;

public class LevelOrderTraversal<T> extends BinaryTree<T> {

	private Node<T> root;

	public LevelOrderTraversal(Node<T> root) {
		super(root);
		this.root = root;
	}

	public T[] traverseRecursive() {
		List<T> list = new ArrayList<>();
		Queue<Node<T>> queue = new Queue<>();
		traverseRecursive(root, list, queue);
		return listToArray(list);
	}

	private void traverseRecursive(Node<T> node, List<T> list, Queue<Node<T>> queue) {
		list.add(node.value);
		if (node.left != null) {
			queue.enQueue(node.left);
		}
		if (node.right != null) {
			queue.enQueue(node.right);
		}
		if (!queue.isEmpty()) {
			traverseRecursive(queue.deQueue(), list, queue);
		}
	}

	public T[] traverseIterative() {
		List<T> list = new ArrayList<>();
		Queue<Node<T>> queue = new Queue<>();
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.deQueue();
			list.add(node.value);
			if (node.left != null) {
				queue.enQueue(node.left);
			}
			if (node.right != null) {
				queue.enQueue(node.right);
			}
		}
		return listToArray(list);
	}

}
