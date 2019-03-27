package com.learning.ads.datastructure.tree.problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import com.learning.ads.datastructure.tree.BinaryTree;

public class DiagonalView<T> extends BinaryTree<T> {

	private Node<T> root;
	private LinkedHashMap<Integer, List<Node<T>>> map;

	public DiagonalView(Node<T> root) {
		super(root);
		this.root = root;
	}

	public T[] recursive() {
		List<T> list = new ArrayList<>();
		recursive(root, 0);
		
		return listToArray(list);
	}

	private void recursive(Node<T> node, int key) {
		if (node == null) {
			return;
		}
		List<Node<T>> list = map.get(key);
		if (list != null) {
			list.add(node);
		} else {
			List<Node<T>> newList = new LinkedList<>();
			newList.add(node);
			map.put(key, newList);
		}

		recursive(node.left, key - 1);
		recursive(node.left, key + 1);

	}

}
