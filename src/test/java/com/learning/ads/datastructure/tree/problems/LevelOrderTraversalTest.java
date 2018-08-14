package com.learning.ads.datastructure.tree.problems;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import com.learning.ads.datastructure.tree.BinaryTree;

public class LevelOrderTraversalTest {

	LevelOrderTraversal<Integer> levelOrder;

	@Before
	public void setUp() throws Exception {

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
		levelOrder = new LevelOrderTraversal<>(root);
	}

	@Test
	public void recursive() {
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 },
				levelOrder.traverseLevelOrder());
		BinaryTree.Node<Integer> leftSubTree = new BinaryTree.Node<>(1);
		BinaryTree.Node<Integer> rightSubTree = new BinaryTree.Node<>(null, 2, new BinaryTree.Node<>(3));
		BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(leftSubTree, 0, rightSubTree);
		assertArrayEquals(new Integer[] { 0, 1, 2, 3 }, new LevelOrderTraversal<Integer>(root).traverseLevelOrder());
	}

	@Test
	public void iterative() {
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 },
				levelOrder.traverseIterative());
		BinaryTree.Node<Integer> leftSubTree = new BinaryTree.Node<>(1);
		BinaryTree.Node<Integer> rightSubTree = new BinaryTree.Node<>(null, 2, new BinaryTree.Node<>(3));
		BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(leftSubTree, 0, rightSubTree);
		assertArrayEquals(new Integer[] { 0, 1, 2, 3 }, new LevelOrderTraversal<Integer>(root).traverseIterative());
	}

}
