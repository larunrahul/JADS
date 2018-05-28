package com.learning.ads.datastructure.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

	BinaryTree<Integer> binaryTree;

	@Before
	public void setUp() {
		// building right sub-tree
		BinaryTree.Node<Integer> left = new BinaryTree.Node<>(17);
		BinaryTree.Node<Integer> right = new BinaryTree.Node<>(18);
		BinaryTree.Node<Integer> node = new BinaryTree.Node<>(left, 13, right);
		left = node;
		node = new BinaryTree.Node<>(left, 11, null);
		right = node;
		left = new BinaryTree.Node<>(10);
		node = new BinaryTree.Node<>(left, 6, right);
		right = node;
		left = new BinaryTree.Node<Integer>(new BinaryTree.Node<>(9), 5, null);
		BinaryTree.Node<Integer> leftSubTree = new BinaryTree.Node<>(left, 2, right);

		// building left sub-tree
		left = new BinaryTree.Node<>(16);
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
		BinaryTree.Node<Integer> rightSubTree = new BinaryTree.Node<>(left, 1, right);

		// building root
		BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(leftSubTree, 0, rightSubTree);
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

}
