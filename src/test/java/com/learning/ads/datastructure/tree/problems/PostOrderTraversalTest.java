package com.learning.ads.datastructure.tree.problems;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import com.learning.ads.datastructure.tree.BinaryTree;

public class PostOrderTraversalTest {

	PostOrderTraversal<Integer> postOrder;

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
		postOrder = new PostOrderTraversal<>(root);
	}

	@Test
	public void recursive() {
		assertArrayEquals(new Integer[] { 7, 3, 14, 18, 15, 12, 8, 4, 1, 9, 5, 10, 16, 17, 13, 11, 6, 2, 0 },
				postOrder.traversePostOrder());
		assertArrayEquals(new Integer[] { 7, 3, 14, 18, 15, 12, 8, 4, 1, 9, 5, 10, 16, 17, 13, 11, 6, 2, 0 },
				postOrder.traverseIterative());
	}

}
