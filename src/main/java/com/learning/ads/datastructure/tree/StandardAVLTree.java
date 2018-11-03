package com.learning.ads.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.queue.Queue;

/**
 * 
 * One of the height-balanced implementation of BST.
 * 
 * Height property of ALV tree: Heights of left and right sub trees of every
 * tree should differ by at most 1
 * 
 * Most of the operations can be done in O(log n) time due to the fact that tree
 * is always height-balanced.
 * 
 * The height of the tree is at most log n where n is the number of nodes in
 * tree.
 * 
 * Inorder traversal always results in sorted list of all nodes in tree
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class StandardAVLTree<T extends Comparable<T>> {

	private Node<T> root;

	private static class Node<T> {

		public T value;
		public Node<T> left;
		public Node<T> right;
		public Node<T> parent;
		public int height;

		public Node(T value) {
			this.value = value;
		}

		public String toString() {
			return value + " ";
		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node<T> node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

	public int depth() {
		return height();
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * @param key
	 * @return
	 */
	public Node<T> search(T key) {
		Node<T> node = root;
		int comp;
		while (node != null && (comp = key.compareTo(node.value)) != 0) {
			if (comp < 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node;
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * @return
	 */
	public T min() {
		Node<T> min = min(root);
		return min == null ? null : min.value;
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * @return
	 */
	private Node<T> min(Node<T> node) {
		Node<T> parent = null;
		while (node != null) {
			parent = node;
			node = node.left;
		}
		return parent;
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * @return
	 */
	public T max() {
		Node<T> max = max(root);
		return max == null ? null : max.value;
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * @return
	 */
	private Node<T> max(Node<T> node) {
		Node<T> parent = null;
		while (node != null) {
			parent = node;
			node = node.right;
		}
		return parent;
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * @return
	 */
	public Node<T> successor(Node<T> node) {
		Node<T> successor = node;
		if (node.right != null) {
			successor = min(node.right);
		} else {
			successor = node.parent;
			while (successor != null && node.equals(successor.right)) {
				node = successor;
				successor = successor.parent;
			}
		}
		return successor;
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * @return
	 */
	public Node<T> predecessor(Node<T> node) {
		Node<T> successor = node;
		if (node.left != null) {
			successor = max(node.right);
		} else {
			successor = node.parent;
			while (successor != null && node.equals(successor.left)) {
				node = successor;
				successor = successor.parent;
			}
		}
		return successor;
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * @return
	 */
	public void insert(T key) {
		Node<T> node = new Node<>(key);
		Node<T> parent = null;
		Node<T> child = this.root;
		while (child != null) {
			parent = child;
			if (key.compareTo(child.value) < 0) {
				child = child.left;
			} else {
				child = child.right;
			}
		}
		node.parent = parent;
		if (parent == null) {
			this.root = node;
		} else if (key.compareTo(parent.value) < 0) {
			parent.left = node;
		} else {
			parent.right = node;
		}
		insertBalance(node);
	}

	private void insertBalance(Node<T> node) {
		while (node != null) {
			node.height = Math.max(height(node.left), height(node.right)) + 1;
			Node<T> newNode = balance(node);
			node = newNode.parent;
		}
	}

	private Node<T> balance(Node<T> x) {
		if (Math.abs(height(x.left) - height(x.right)) <= 1) {
			return x;
		}
		// left subtree is heavier than right subtree
		if (height(x.left) > height(x.right)) {
			// right subtree of left subtree is heavier than left subtree of left subtree
			if (height(x.left.left) < height(x.left.right)) {
				leftRotate(x.left);
			}
			return rightRotate(x);
		}
		// right subtree is heavier than left sub-tree
		else {
			// left subtree of right subtree is heavier than right subtree of right sub-tree
			if (height(x.right.left) > height(x.right.right)) {
				rightRotate(x.right);
			}
			return leftRotate(x);
		}
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * @return
	 */
	public void delete(T key) {
		Node<T> node = search(key);
		if (node == null) {
			return;
		}
		Node<T> parent = node.parent;
		if (node.left == null) {
			transplant(node, node.right);
			if (node.right != null) {
				parent = node.right;
			}
		} else if (node.right == null) {
			transplant(node, node.left);
			if (node.left != null) {
				parent = node.left;
			}
		} else {
			Node<T> replacement = min(node.right);
			parent = replacement.parent;
			if (!replacement.parent.equals(node)) {
				transplant(replacement, replacement.right);
				replacement.right = node.right;
				replacement.right.parent = replacement;
			}
			transplant(node, replacement);
			replacement.left = node.left;
			replacement.left.parent = replacement;
		}
	}

	/**
	 * This method presumes that right child of input node is not null
	 * 
	 * @param x
	 */
	private Node<T> leftRotate(Node<T> x) {
		Node<T> y = x.right;
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		return y;
	}

	/**
	 * This method presumes that left child of input node is not null
	 * 
	 * @param x
	 */
	private Node<T> rightRotate(Node<T> x) {
		Node<T> y = x.left;
		x.left = y.right;
		if (y.right != null) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.right = x;
		x.parent = y;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		return y;
	}

	private void transplant(Node<T> oTree, Node<T> rTree) {
		if (oTree.parent == null) {
			this.root = rTree;
		} else if (oTree.equals(oTree.parent.left)) {
			oTree.parent.left = rTree;
		} else {
			oTree.parent.right = rTree;
		}
		if (rTree != null) {
			rTree.parent = oTree.parent;
		}
	}

	/**
	 * Complexity: O(n)
	 * 
	 * @return
	 */
	public List<T> traverseLevelOrder() {
		List<T> list = new ArrayList<>();
		Queue<Node<T>> queue = new Queue<>();
		traverseLevelOrderRecursive(root, list, queue);
		return list;
	}

	private void traverseLevelOrderRecursive(Node<T> node, List<T> list, Queue<Node<T>> queue) {
		if (node == null) {
			return;
		}
		list.add(node.value);
		if (node.left != null) {
			queue.enQueue(node.left);
		}
		if (node.right != null) {
			queue.enQueue(node.right);
		}
		if (!queue.isEmpty()) {
			traverseLevelOrderRecursive(queue.deQueue(), list, queue);
		}
	}

	/**
	 * Complexity: O(n)
	 * 
	 * @return
	 */
	public List<T> traverseInOrder() {
		List<T> list = new ArrayList<>();
		traverseInOrderRecursive(root, list);
		return list;
	}

	private void traverseInOrderRecursive(Node<T> node, List<T> list) {
		if (node == null) {
			return;
		}
		traverseInOrderRecursive(node.left, list);
		list.add(node.value);
		traverseInOrderRecursive(node.right, list);
	}

	/**
	 * Complexity: O(n)
	 * 
	 * @return
	 */
	public T[] traversePostOrder() {
		List<T> list = new ArrayList<>();
		traversePostOrderRecursive(root, list);
		return listToArray(list);
	}

	private void traversePostOrderRecursive(Node<T> node, List<T> list) {
		if (node == null) {
			return;
		}
		traversePostOrderRecursive(node.left, list);
		traversePostOrderRecursive(node.right, list);
		list.add(node.value);
	}

	/**
	 * Complexity: O(n)
	 * 
	 * @return
	 */
	public List<T> traversePreOrder() {
		List<T> list = new ArrayList<>();
		traversePreOrderRecursive(root, list);
		return list;
	}

	private void traversePreOrderRecursive(Node<T> node, List<T> list) {
		if (node == null) {
			return;
		}
		list.add(node.value);
		traversePreOrderRecursive(node.left, list);
		traversePreOrderRecursive(node.right, list);
	}

	@SuppressWarnings("unchecked")
	public T[] listToArray(List<T> list) {
		return (T[]) list.toArray();
	}
}
