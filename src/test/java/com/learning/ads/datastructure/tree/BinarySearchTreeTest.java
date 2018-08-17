package com.learning.ads.datastructure.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>(0);
		assertEquals(Integer.valueOf(0), tree.min().value);
		assertEquals(Integer.valueOf(0), tree.max().value);
		tree.delete(0);
		assertNull(tree.min());
		assertNull(tree.max());
		tree.insert(40);
		assertEquals(Integer.valueOf(40), tree.min().value);
		assertEquals(Integer.valueOf(40), tree.max().value);
		assertArrayEquals(new Integer[] { 40 }, tree.traverseInOrder().toArray());
		tree.insert(60);
		assertEquals(Integer.valueOf(40), tree.min().value);
		assertEquals(Integer.valueOf(60), tree.max().value);
		assertArrayEquals(new Integer[] { 40, 60 }, tree.traverseInOrder().toArray());
		tree.insert(20);
		assertEquals(Integer.valueOf(20), tree.min().value);
		assertArrayEquals(new Integer[] { 20, 40, 60 }, tree.traverseInOrder().toArray());
		assertEquals(Integer.valueOf(60), tree.max().value);
		assertEquals(Integer.valueOf(20), tree.min().value);
		tree.insert(10);
		tree.insert(70);
		tree.insert(30);
		tree.insert(50);
		tree.insert(25);
		tree.insert(55);
		tree.insert(45);
		tree.insert(35);
		tree.insert(65);
		tree.insert(15);
		tree.insert(5);
		tree.insert(75);
		assertEquals(Integer.valueOf(75), tree.max().value);
		assertArrayEquals(new Integer[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75 },
				tree.traverseInOrder().toArray());
		// both childs are empty
		tree.delete(75);
		assertArrayEquals(new Integer[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70 },
				tree.traverseInOrder().toArray());
		// both childs are empty
		tree.delete(65);
		assertArrayEquals(new Integer[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 70 },
				tree.traverseInOrder().toArray());
		tree.insert(75);
		tree.insert(65);
		assertArrayEquals(new Integer[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75 },
				tree.traverseInOrder().toArray());
		// both childs are non-empty with successor not the immediate node
		tree.delete(60);
		assertArrayEquals(new Integer[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 65, 70, 75 },
				tree.traverseInOrder().toArray());
		tree.delete(65);
		assertArrayEquals(new Integer[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 70, 75 },
				tree.traverseInOrder().toArray());
		tree.delete(40);
		assertArrayEquals(new Integer[] { 5, 10, 15, 20, 25, 30, 35, 45, 50, 55, 70, 75 },
				tree.traverseInOrder().toArray());
	}

}
