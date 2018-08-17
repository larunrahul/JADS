package com.learning.ads.datastructure.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

	BinaryTree<Integer> binaryTree;

	@Before
	public void setUp() {
		// building right sub-tree
		BinaryTree.Node<Integer> left = new BinaryTree.Node<>(16);
		BinaryTree.Node<Integer> right = new BinaryTree.Node<>(17);
		BinaryTree.Node<Integer> node = new BinaryTree.Node<>(left, 13, right);
		left = node;
		node = new BinaryTree.Node<>(left, 11, null);
		right = node;
		left = new BinaryTree.Node<>(10);
		node = new BinaryTree.Node<>(left, 6, right);
		right = node;
		left = new BinaryTree.Node<Integer>(new BinaryTree.Node<>(9), 5, null);
		BinaryTree.Node<Integer> rightSubTree = new BinaryTree.Node<>(left, 2, right);

		// building left sub-tree
		left = new BinaryTree.Node<>(18);
		node = new BinaryTree.Node<>(left, 15, null);
		right = node;
		left = new BinaryTree.Node<>(14);
		node = new BinaryTree.Node<>(left, 12, right);
		left = node;
		node = new BinaryTree.Node<>(left, 8, null);
		right = node;
		node = new BinaryTree.Node<>(null, 4, right);
		right = node;
		left = new BinaryTree.Node<>(null, 3, new BinaryTree.Node<>(7));
		BinaryTree.Node<Integer> leftSubTree = new BinaryTree.Node<>(left, 1, right);

		// building root
		BinaryTree.Node<Integer> root = new BinaryTree.Node<>(leftSubTree, 0, rightSubTree);
		binaryTree = new BinaryTree<>(root);
	}

	@Test
	public void height() {
		assertEquals(6, binaryTree.height());
		assertEquals(0, new BinaryTree<>(null).height());
		assertEquals(0, new BinaryTree<>(new BinaryTree.Node<>(1)).height());
		assertEquals(1, new BinaryTree<>(new BinaryTree.Node<>(null, 1, new BinaryTree.Node<>(2))).height());
	}

	@Test
	public void levels() {
		assertEquals(7, binaryTree.levels());
		assertEquals(0, new BinaryTree<>(null).levels());
		assertEquals(1, new BinaryTree<>(new BinaryTree.Node<>(1)).levels());
		assertEquals(2, new BinaryTree<>(new BinaryTree.Node<>(null, 1, new BinaryTree.Node<>(2))).levels());
	}

	@Test
	public void insert() {
		BinaryTree<Integer> tree = new BinaryTree<>(1);
		assertArrayEquals(new Integer[] { 1 }, tree.traverseLevelOrder());
		tree.insert(2);
		assertArrayEquals(new Integer[] { 1, 2 }, tree.traverseLevelOrder());
		tree.insert(3);
		assertArrayEquals(new Integer[] { 1, 2, 3 }, tree.traverseLevelOrder());
		tree.insert(4);
		tree.insert(5);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, tree.traverseLevelOrder());
		assertArrayEquals(new Integer[] { 4, 2, 5, 1, 3 }, tree.traverseInOrder());
		assertArrayEquals(new Integer[] { 1, 2, 4, 5, 3 }, tree.traversePreOrder());
		assertArrayEquals(new Integer[] { 4, 5, 2, 3, 1 }, tree.traversePostOrder());
		assertEquals(Integer.valueOf(5), tree.get(5).value);
		assertNull(tree.get(7).value);
	}

	@Test
	public void delete() {
		BinaryTree<Integer> tree = new BinaryTree<>(1);
		tree.delete(0);
		assertArrayEquals(new Integer[] { 1 }, tree.traverseLevelOrder());
		tree.delete(1);
		assertArrayEquals(new Integer[] {}, tree.traverseLevelOrder());
		tree.insert(1);
		assertArrayEquals(new Integer[] { 1 }, tree.traverseLevelOrder());
		tree.delete(1);
		assertArrayEquals(new Integer[] {}, tree.traverseLevelOrder());
		tree.insert(1);
		tree.insert(2);
		tree.delete(4);
		assertArrayEquals(new Integer[] { 1, 2 }, tree.traverseLevelOrder());
		tree.delete(2);
		assertArrayEquals(new Integer[] { 1 }, tree.traverseLevelOrder());
		tree.delete(1);
		assertArrayEquals(new Integer[] {}, tree.traverseLevelOrder());
		tree.insert(1);
		tree.insert(2);
		tree.delete(4);
		assertArrayEquals(new Integer[] { 1, 2 }, tree.traverseLevelOrder());
		tree.delete(1);
		assertArrayEquals(new Integer[] { 2 }, tree.traverseLevelOrder());
		tree.delete(2);
		assertArrayEquals(new Integer[] {}, tree.traverseLevelOrder());
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.delete(7);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6 }, tree.traverseLevelOrder());
		assertArrayEquals(new Integer[] { 4, 2, 5, 1, 6, 3 }, tree.traverseInOrder());
		assertArrayEquals(new Integer[] { 1, 2, 4, 5, 3, 6 }, tree.traversePreOrder());
		assertArrayEquals(new Integer[] { 4, 5, 2, 6, 3, 1 }, tree.traversePostOrder());
		tree.delete(1);
		assertArrayEquals(new Integer[] { 6, 2, 3, 4, 5 }, tree.traverseLevelOrder());
	}

}
