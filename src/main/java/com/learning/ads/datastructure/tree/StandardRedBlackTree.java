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
 * Properties of RB tree
 * 
 * 1. Every node is either red or black.
 * 
 * 2. The root is black
 * 
 * 3. Every leaf (NIL) is black.
 * 
 * 4. If a node is red, then both its children are black.
 * 
 * 5. For each node, all simple paths from the node to descendant leaves contain
 * the same number of black nodes.
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

	private static final char BLACK = 'B';
	private static final char RED = 'R';

	private final Node<T> nil = new Node<>(null, BLACK, null);

	private Node<T> root = nil;

	private static class Node<T> {

		public T value;
		public Node<T> left;
		public Node<T> right;
		public Node<T> parent;
		public char color;

		public Node(T value, Node<T> nil) {
			this.value = value;
			this.color = RED;
			this.left = nil;
			this.right = nil;
		}

		public Node(T value, char c, Node<T> nil) {
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
		if (node == nil) {
			return 0;
		}
		return Math.max(height(node.left), height(node.right)) + (node.left != nil || node.right != nil ? 1 : 0);
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
		while (node != nil && (comp = key.compareTo(node.value)) != 0) {
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
		return min == nil ? null : min.value;
	}

	private Node<T> min(Node<T> node) {
		Node<T> parent = nil;
		while (node != nil) {
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
		return max == nil ? null : max.value;
	}

	private Node<T> max(Node<T> node) {
		Node<T> parent = nil;
		while (node != nil) {
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
		if (node.right != nil) {
			successor = min(node.right);
		} else {
			successor = node.parent;
			while (successor != nil && node == successor.right) {
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
		if (node.left != nil) {
			successor = max(node.right);
		} else {
			successor = node.parent;
			while (successor != nil && node == successor.left) {
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
		while (x != nil) {
			y = x;
			if (key.compareTo(x.value) < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		z.parent = y;
		if (y == nil) {
			this.root = z;
		} else if (key.compareTo(y.value) < 0) {
			y.left = z;
		} else {
			y.right = z;
		}
		z.color = RED;
		insertFixUp(z);
	}

	private void insertFixUp(Node<T> z) {
		while (z.parent.color == RED) {
			if (z.parent == z.parent.parent.left) {
				Node<T> y = z.parent.parent.right;// z's uncle
				if (y.color == RED) {// z's parent and z's uncle both are red
					z.parent.color = BLACK;
					y.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					rightRotate(z.parent.parent);
				}
			} else {
				Node<T> y = z.parent.parent.left;// z's uncle
				if (y.color == RED) {// z's parent and z's uncle both are red
					z.parent.color = BLACK;
					y.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					}
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					leftRotate(z.parent.parent);
				}
			}
		}
		this.root.color = BLACK;
	}

	/**
	 * This method presumes that right child of input node is not null
	 * 
	 * @param x
	 */
	private void leftRotate(Node<T> x) {
		Node<T> y = x.right;
		x.right = y.left;
		if (y.left != nil) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nil) {
			this.root = y;
		} else if (x == x.parent.left) {
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
		if (y.right != nil) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nil) {
			this.root = y;
		} else if (x == x.parent.left) {
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
	public void delete(T z) {
		Node<T> y = search(z);
		if (y == nil) {
			return;
		}
		Node<T> x;
		char y_original_color = y.color;
		if (y.left == nil) {
			x = y.right;
			transplant(y, y.right);
		} else if (y.right == nil) {
			x = y.left;
			transplant(y, y.left);
		} else {
			Node<T> r = min(y.right);
			y_original_color = r.color;
			x = r.right;
			if (r.parent == y) {
				x.parent = r;
			} else {
				transplant(r, r.right);
				r.right = y.right;
				r.right.parent = r;
			}
			transplant(y, r);
			r.left = y.left;
			r.left.parent = r;
			r.color = y.color;
		}
		// we do fix-up only if deleted node is BLACK, cause that violates the property
		// 5 i.e., "For each node, all simple paths from the node to descendant leaves
		// contain the same number of black nodes"
		if (y_original_color == BLACK) {
			deleteFixUp(x);
		}
	}

	private void deleteFixUp(Node<T> x) {
		while (x != root && x.color == BLACK) {
			if (x == x.parent.left) {
				Node<T> w = x.parent.right;// right sibling of node x
				// sibling is red
				if (w.color == RED) {
					w.color = BLACK; // change it to BLACK
					x.parent.color = RED;
					leftRotate(x.parent);
					w = x.parent.right;
				}
				// both children of sibling are BLACK
				if (w.left.color == BLACK && w.right.color == BLACK) {
					w.color = RED;
					x = x.parent;
				} else {
					// right child of sibling is BLACK and left child of sibling is RED
					if (w.right.color == BLACK) {
						w.left.color = BLACK;// change left child to BLACK
						w.color = RED;
						rightRotate(w);
						w = x.parent.right;
					}
					// right child of  siblings is RED
					w.color = x.parent.color;
					x.parent.color = BLACK;
					w.right.color = BLACK;
					leftRotate(x.parent);
					x = root;
				}
			} else {
				Node<T> w = x.parent.left;// left sibling of node x
				// sibling is red
				if (w.color == RED) {
					w.color = BLACK;// change it to BLACK
					x.parent.color = RED;
					rightRotate(x.parent);
					w = x.parent.left;
				}
				// both children of sibling are BLACK
				if (w.left.color == BLACK && w.right.color == BLACK) {
					w.color = RED;
					x = x.parent;
				} else {
					// left child of sibling is BLACK and right child of sibling is RED
					if (w.left.color == BLACK) {
						w.right.color = BLACK;// change right child to BLACK
						w.color = RED;
						leftRotate(w);
						w = x.parent.left;
					}
					// left child of siblings is RED
					w.color = x.parent.color;
					x.parent.color = BLACK;
					w.left.color = BLACK;
					rightRotate(x.parent);
					x = root;
				}
			}
		}
		x.color = BLACK;
	}

	private void transplant(Node<T> oTree, Node<T> rTree) {
		if (oTree.parent == nil) {
			this.root = rTree;
		} else if (oTree == oTree.parent.left) {
			oTree.parent.left = rTree;
		} else {
			oTree.parent.right = rTree;
		}
		rTree.parent = oTree.parent;
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
		if (node == nil) {
			return;
		}
		list.add(node.value);
		if (node.left != nil) {
			queue.enQueue(node.left);
		}
		if (node.right != nil) {
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
		if (node == nil) {
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
		if (node == nil) {
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
		if (node == nil) {
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
