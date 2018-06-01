package com.learning.ads.datastructure.tree.problems;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.tree.BinaryTree;

public class PreOrderTraversal<T> extends BinaryTree<T> {

	private Node<T> root;

	public PreOrderTraversal(Node<T> root) {
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
		list.add(node.value);
		traverseRecursive(node.left, list);
		traverseRecursive(node.right, list);

	}
}
