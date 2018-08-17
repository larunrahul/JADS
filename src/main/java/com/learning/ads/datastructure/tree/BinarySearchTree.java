package com.learning.ads.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import com.learning.ads.datastructure.queue.Queue;

/**
 * 
 * Most of the operations can be done in O(log n) time. As this tree
 * implementation is unbalanced, it quickly grows to Skew trees whose worst case
 * complexity is O(n).
 * 
 * Hence, although they tend to do operations in O(log n) time, worst case
 * complexity is O(n) which is no different from a linked list.
 * 
 * In real world cases, we always use balanced implementation like Red-Black
 * trees or AVL trees
 * 
 * Inorder traversal always results in sorted list of all nodes in tree
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private Node<T> root;

	public BinarySearchTree(Node<T> node) {
		this.root = node;
	}

	public BinarySearchTree(T value) {
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

	public Node<T> min() {
		return min(root);
	}

	public Node<T> min(Node<T> node) {
		if (node == null) {
			return null;
		}
		Node<T> minNode = min(node.left);
		if (minNode == null) {
			return node;
		}
		return minNode;
	}

	public Node<T> max() {
		return max(root);
	}

	public Node<T> max(Node<T> node) {
		if (node == null) {
			return null;
		}
		Node<T> minNode = max(node.right);
		if (minNode == null) {
			return node;
		}
		return minNode;
	}

	public Node<T> get(T o) {
		Node<T> result = get(root, o);
		if (result == null) {
			throw new RuntimeException("node not found");
		}
		return result;
	}

	private Node<T> get(Node<T> node, T o) {
		if (node == null) {
			return null;
		}
		int compResult = o.compareTo(node.value);
		if (compResult == 0) {
			return node;
		}
		if (compResult < 0) {
			return get(node.left, o);
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
	 * Complexity: O(log n)
	 * 
	 * This can quickly grow into Skew tree whose insert complexity will be O(n)
	 * 
	 * @param value
	 */
	public void insert(T value) {
		root = insert(root, value);
	}

	public Node<T> insert(Node<T> node, T value) {
		if (node == null) {
			return new Node<T>(value);
		}
		int compValue = node.value.compareTo(value);
		if (compValue > 0) {
			node.left = insert(node.left, value);
		} else {
			node.right = insert(node.right, value);
		}
		return node;
	}

	/**
	 * Complexity: O(log n)
	 * 
	 * This can quickly grow into Skew tree whose insert complexity will be O(n)
	 * 
	 * @param key
	 */
	public void delete(T key) {
		root = delete(root, key);
	}

	private Node<T> delete(Node<T> node, T key) {
		if (node == null) {
			return null;
		}
		int comp = node.value.compareTo(key);
		if (comp > 0) {
			node.left = delete(node.left, key);
		} else if (comp < 0) {
			node.right = delete(node.right, key);
		} else {// if this is the node to be deleted
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			Node<T> successorParent = getSuccessorParent(node.right);
			/*
			 * if immediate right is successor, which means, immediate right has not left
			 * child
			 */
			if (node.right.equals(successorParent) && successorParent.left == null) {
				successorParent.left = node.left;
				return successorParent;
			}
			/*
			 * successorParent's left is the one which we use as replacement and hence never
			 * empty
			 */
			Node<T> replacement = successorParent.left;
			if (replacement.right != null) {
				successorParent.left = replacement.right;
				return node;
			}
			successorParent.left = null;
			replacement.left = node.left;
			replacement.right = node.right;
			node.left = null;
			node.right = null;
			node = replacement;
		}

		return node;
	}

	private Node<T> getSuccessorParent(Node<T> node) {
		Node<T> parent = node;
		while (parent.left != null && parent.left.left != null) {
			parent = parent.left;
		}
		return parent;
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
