package com.learning.ads.datastructure.tree.problems;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import com.learning.ads.datastructure.tree.BinaryTree;

public class RightViewTest {

	RightView<Integer> rightView;

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
		rightView = new RightView<>(root);
	}

	@Test
	public void iterative() {
		assertArrayEquals(new Integer[] { 0, 2, 6, 11, 13, 17, 18 }, rightView.iterative());
		BinaryTree.Node<Integer> leftSubTree = new BinaryTree.Node<>(null, 1, new BinaryTree.Node<>(3));
		BinaryTree.Node<Integer> rightSubTree = new BinaryTree.Node<>(2);
		BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(leftSubTree, 0, rightSubTree);
		assertArrayEquals(new Integer[] { 0, 2, 3 }, new RightView<Integer>(root).iterative());
	}

}
