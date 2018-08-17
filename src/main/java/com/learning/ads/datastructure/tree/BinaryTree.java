package com.learning.ads.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.queue.Queue;

/**
 * A Binary Tree implementation.
 * 
 * Most of the basic operations like insert, delete, search can be done in O(n)
 * time
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class BinaryTree<T> {

	private Node<T> root;

	public BinaryTree(Node<T> root) {
		this.root = root;
	}

	public BinaryTree(T value) {
		this.root = new Node<T>(value);
	}

	public static class Node<T> {

		public T value;
		public Node<T> left;
		public Node<T> right;

		public Node(T value) {
			this.value = value;
		}

		public Node(Node<T> left, T value, Node<T> right) {
			this.left = left;
			this.value = value;
			this.right = right;
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
		if (node == null) {
			return 0;
		}
		return Math.max(height(node.left), height(node.right)) + (node.left != null || node.right != null ? 1 : 0);
	}

	public int depth() {
		return height();
	}

	public Node<T> get(T o) {
		Node<T> result = get(root, o);
		if (result == null) {
			return new Node<T>(null);
		}
		return result;
	}

	private Node<T> get(Node<T> node, T o) {
		if (node == null) {
			return null;
		}
		if (node.value.equals(o)) {
			return node;
		}
		Node<T> left = get(node.left, o);
		if (left != null) {
			return left;
		}
		return get(node.right, o);
	}

	public int levels() {
		if (root == null) {
			return 0;
		}
		return height() + 1;
	}

	/**
	 * Complexity: O(n)
	 * 
	 * We are always trying to insert at the right most possible empty child
	 * 
	 * @param value
	 */
	public void insert(T value) {
		if (root == null) {
			root = new Node<>(value);
			return;
		}
		Queue<Node<T>> queue = new Queue<>();
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.deQueue();
			if (node.left != null) {
				queue.enQueue(node.left);
			} else {
				node.left = new Node<>(value);
				break;
			}
			if (node.right != null) {
				queue.enQueue(node.right);
			} else {
				node.right = new Node<>(value);
				break;
			}
		}
	}

	/**
	 * Complexity: O(n)
	 * 
	 * This delete operation can quickly make tree into Skew tree
	 * 
	 * @param key
	 */
	public void delete(T key) {
		if (root == null) {
			return;
		}
		Node<T> keyNode = null;// node to be deleted
		Node<T> parent = null;// parent of node to be deleted
		Node<T> node = null;// replacement node
		Queue<Node<T>> queue = new Queue<>();
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			node = queue.deQueue();
			if (node.value.equals(key)) {
				keyNode = node;
			}
			if (node.left != null) {
				queue.enQueue(node.left);
				if (node.left.value.equals(key)) {
					parent = node;
					keyNode = node.left;
				}
			}
			if (node.right != null) {
				queue.enQueue(node.right);
				if (node.right.value.equals(key)) {
					parent = node;
					keyNode = node.right;
				}
			}
		}
		// node not found
		if (keyNode == null || node == null) {
			return;
		}
		deleteDeepest(keyNode, parent, node);
	}

	private void deleteDeepest(Node<T> keyNode, Node<T> parent, Node<T> deepNode) {
		// to be deleted node is the replacement node
		if (deepNode.equals(keyNode)) {
			// if root
			if (parent != null) {
				if (parent.left != null && parent.left.equals(keyNode)) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else {
				root = null;
			}
			return;
		}
		Queue<Node<T>> queue = new Queue<>();
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.deQueue();
			if (node.left != null) {
				if (node.left.value.equals(deepNode.value)) {
					node.left = null;
					break;
				}
				queue.enQueue(node.left);

			}
			if (node.right != null) {
				if (node.right.value.equals(deepNode.value)) {
					node.right = null;
					break;
				}
				queue.enQueue(node.right);
			}
		}
		deepNode.left = keyNode.left;
		deepNode.right = keyNode.right;
		if (parent != null) {
			if (parent.left != null && parent.left.equals(keyNode)) {
				parent.left = deepNode;
			} else {
				parent.right = deepNode;
			}
		} else {
			deepNode.left = root.left;
			deepNode.right = root.right;
			root = deepNode;
		}
	}

	/**
	 * Complexity: O(n)
	 * 
	 * @return
	 */
	public T[] traverseLevelOrder() {
		List<T> list = new ArrayList<>();
		Queue<Node<T>> queue = new Queue<>();
		traverseLevelOrderRecursive(root, list, queue);
		return listToArray(list);
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
	public T[] traverseInOrder() {
		List<T> list = new ArrayList<>();
		traverseInOrderRecursive(root, list);
		return listToArray(list);
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
	public T[] traversePreOrder() {
		List<T> list = new ArrayList<>();
		traversePreOrderRecursive(root, list);
		return listToArray(list);
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
