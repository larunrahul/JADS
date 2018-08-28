package com.learning.ads.datastructure.tree.problems;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import com.learning.ads.datastructure.tree.BinaryTree;
import com.learning.ads.datastructure.tree.BinaryTree.Node;

public class BinaryTreeConstructorTest {

	BinaryTreeConstructor<Integer> constructor;
	InOrderTraversal<Integer> inOrder;
	PreOrderTraversal<Integer> preOrder;
	PostOrderTraversal<Integer> postOrder;

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
		constructor = new BinaryTreeConstructor<>(root);
	}

	@Test
	public void constructWithPreOrderAndInOrder() {
		Node<Integer> result = constructor.constructWithPreOrderAndInOrder(new Integer[] { 2, 1, 4, 3, 6, 7, 5 },
				new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		preOrder = new PreOrderTraversal<>(result);
		inOrder = new InOrderTraversal<>(result);
		postOrder = new PostOrderTraversal<>(result);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, preOrder.traverseIterative());
		assertArrayEquals(new Integer[] { 2, 1, 4, 3, 6, 7, 5 }, inOrder.traverseIterative());
		assertArrayEquals(new Integer[] { 2, 4, 7, 6, 5, 3, 1 }, postOrder.traverseIterative());
	}

	@Test
	public void constructWithInOrderAndPostOrder() {
		Node<Integer> result = constructor.constructWithInOrderAndPostOrder(new Integer[] { 2, 1, 4, 3, 6, 7, 5 },
				new Integer[] { 2, 4, 7, 6, 5, 3, 1 });
		preOrder = new PreOrderTraversal<>(result);
		inOrder = new InOrderTraversal<>(result);
		postOrder = new PostOrderTraversal<>(result);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, preOrder.traverseIterative());
		assertArrayEquals(new Integer[] { 2, 1, 4, 3, 6, 7, 5 }, inOrder.traverseIterative());
		assertArrayEquals(new Integer[] { 2, 4, 7, 6, 5, 3, 1 }, postOrder.traverseIterative());
	}

}
