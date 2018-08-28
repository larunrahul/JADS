package com.learning.ads.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.queue.Queue;

/**
 * 
 * One of the balanced(approximately) balanced implementation of BST.
 * 
 * Implementation follows as explained in CLRS
 * 
 * Most of the operations can be done in O(log n) time due to the fact that tree
 * is always approximately balanced.
 * 
 * The height of the tree is at most 2(lg(n+1)) where n is the number of nodes
 * in tree.
 * 
 * Inorder traversal always results in sorted list of all nodes in tree
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class StandardRedBlackTree<T extends Comparable<T>> {

	private final Node<T> nil = new Node<>(null, COLOR.BLACK, null);

	private Node<T> root = nil;

	public static enum COLOR {
		RED, BLACK
	}

	private static class Node<T> {

		public T value;
		public Node<T> left;
		public Node<T> right;
		public Node<T> parent;
		public COLOR color;

		public Node(T value, Node<T> nil) {
			this.value = value;
			this.color = COLOR.RED;
			this.left = nil;
			this.right = nil;
		}

		public Node(T value, COLOR c, Node<T> nil) {
			this.value = value;
			this.color = c;
			this.left = nil;
			this.right = nil;
		}

		public String toString() {
			return value + " ";
		}
	}

	public int height() {
		return height(root);
	}

	/**
	 * Complexity: O(n) where n is the number of nodes in binary tree
	 * 
	 * @param node
	 * @return
	 */
	public int height(Node<T> node) {
		if (nil.equals(node)) {
			return 0;
		}
		return Math.max(height(node.left), height(node.right))
				+ (!nil.equals(node.left) || !nil.equals(node.right) ? 1 : 0);
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
	 * Complexity: O(log n) but quickly grows to O(n) if tree becomes Skew tree
	 * 
	 * @return
	 */
	public T min() {
		Node<T> min = min(root);
		return min == null ? null : min.value;
	}

	/**
	 * Complexity: O(log n) but quickly grows to O(n) if tree becomes Skew tree
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
	 * Complexity: O(log n) but quickly grows to O(n) if tree becomes Skew tree
	 * 
	 * @return
	 */
	public T max() {
		Node<T> max = max(root);
		return max == null ? null : max.value;
	}

	/**
	 * Complexity: O(log n) but quickly grows to O(n) if tree becomes Skew tree
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
		Node<T> z = new Node<>(key, nil);
		Node<T> y = nil;
		Node<T> x = this.root;
		while (!x.equals(nil)) {
			y = x;
			if (key.compareTo(x.value) < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		z.parent = y;
		if (y.equals(nil)) {
			this.root = z;
		} else if (key.compareTo(y.value) < 0) {
			y.left = z;
		} else {
			y.right = z;
		}
		z.color = COLOR.RED;
		insertFixUp(z);
	}

	private void insertFixUp(Node<T> z) {
		while (COLOR.RED.equals(z.parent.color)) {
			if (z.parent.equals(z.parent.parent.left)) {
				Node<T> y = z.parent.parent.right;// z's uncle
				if (COLOR.RED.equals(y.color)) {// z's parent and z's uncle both are red
					z.parent.color = COLOR.BLACK;
					y.color = COLOR.BLACK;
					z.parent.parent.color = COLOR.RED;
					z = z.parent.parent;
				} else {
					if (z.equals(z.parent.right)) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = COLOR.BLACK;
					z.parent.parent.color = COLOR.RED;
					rightRotate(z.parent.parent);
				}
			} else {
				Node<T> y = z.parent.parent.left;// z's uncle
				if (COLOR.RED.equals(y.color)) {// z's parent and z's uncle both are red
					z.parent.color = COLOR.BLACK;
					y.color = COLOR.BLACK;
					z.parent.parent.color = COLOR.RED;
					z = z.parent.parent;
				} else {
					if (z.equals(z.parent.left)) {
						z = z.parent;
						rightRotate(z);
					}
					z.parent.color = COLOR.BLACK;
					z.parent.parent.color = COLOR.RED;
					leftRotate(z.parent.parent);
				}
			}
		}
		this.root.color = COLOR.BLACK;
	}

	/**
	 * This method presumes that right child of input node is not null
	 * 
	 * @param x
	 */
	private void leftRotate(Node<T> x) {
		Node<T> y = x.right;
		x.right = y.left;
		if (!y.left.equals(nil)) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent.equals(nil)) {
			this.root = y;
		} else if (x.equals(x.parent.left)) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	/**
	 * This method presumes that left child of input node is not null
	 * 
	 * @param x
	 */
	private void rightRotate(Node<T> x) {
		Node<T> y = x.left;
		x.left = y.right;
		if (!y.right.equals(nil)) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent.equals(nil)) {
			this.root = y;
		} else if (x.equals(x.parent.left)) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.right = x;
		x.parent = y;
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * @return
	 */
	public void delete(T key) {

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
		if (nil.equals(node)) {
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
