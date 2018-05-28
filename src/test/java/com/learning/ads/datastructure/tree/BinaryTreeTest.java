package com.learning.ads.datastructure.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
	public void preOrderTraversal() {
		assertArrayEquals(new Integer[] { 0, 1, 3, 7, 4, 8, 12, 14, 15, 18, 2, 5, 9, 6, 10, 11, 13, 16, 17 },
				binaryTree.preOrderTraversal());
	}

	@Test
	public void postOrderTraversal() {
		assertArrayEquals(new Integer[] { 7, 3, 14, 18, 15, 12, 8, 4, 1, 9, 5, 10, 16, 17, 13, 11, 6, 2, 0 },
				binaryTree.postOrderTraversal());
	}

	@Test
	public void inOrderTraversal() {
		assertArrayEquals(new Integer[] { 3, 7, 1, 4, 14, 12, 18, 15, 8, 0, 9, 5, 2, 10, 6, 16, 13, 17, 11 },
				binaryTree.inOrderTraversal());
	}

	@Test
	public void levelOrderTraversal() {
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 },
				binaryTree.levelOrderTraversal());
		BinaryTree.Node<Integer> leftSubTree = new BinaryTree.Node<>(1);
		BinaryTree.Node<Integer> rightSubTree = new BinaryTree.Node<>(null, 2, new BinaryTree.Node<>(3));
		BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(leftSubTree, 0, rightSubTree);
		assertArrayEquals(new Integer[] { 0, 1, 2, 3 }, new BinaryTree<Integer>(root).levelOrderTraversal());
	}

	@Test
	public void leftView() {
		assertArrayEquals(new Integer[] { 0, 1, 3, 7, 12, 14, 18 }, binaryTree.leftView());
		BinaryTree.Node<Integer> leftSubTree = new BinaryTree.Node<>(1);
		BinaryTree.Node<Integer> rightSubTree = new BinaryTree.Node<>(null, 2, new BinaryTree.Node<>(3));
		BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(leftSubTree, 0, rightSubTree);
		assertArrayEquals(new Integer[] { 0, 1, 3 }, new BinaryTree<Integer>(root).leftView());
	}

	@Test
	public void rightView() {
		assertArrayEquals(new Integer[] { 0, 2, 6, 11, 13, 17, 18 }, binaryTree.rightView());
		BinaryTree.Node<Integer> leftSubTree = new BinaryTree.Node<>(null, 1, new BinaryTree.Node<>(3));
		BinaryTree.Node<Integer> rightSubTree = new BinaryTree.Node<>(2);
		BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(leftSubTree, 0, rightSubTree);
		assertArrayEquals(new Integer[] { 0, 2, 3 }, new BinaryTree<Integer>(root).rightView());
	}

}
