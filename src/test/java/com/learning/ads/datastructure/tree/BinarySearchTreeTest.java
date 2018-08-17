package com.learning.ads.datastructure.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

	BinarySearchTree<Integer> tree;

	@Before
	public void setUp() throws Exception {
		tree = new BinarySearchTree<>(40);
	}

	@Test
	public void insert() {
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
	}

	@Test
	public void delete() {
		// delete non-existent node
		tree.delete(0);
		assertArrayEquals(new Integer[] { 40 }, tree.traverseInOrder().toArray());
		tree.delete(40);
		assertNull(tree.min());
		assertNull(tree.max());
		assertArrayEquals(new Integer[] {}, tree.traverseInOrder().toArray());
		tree.insert(40);
		insert();
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
		tree.delete(20);
		assertArrayEquals(new Integer[] { 5, 10, 15, 25, 30, 35, 45, 50, 55, 70, 75 },
				tree.traverseInOrder().toArray());
		tree.delete(30);
		tree.delete(55);
		tree.delete(10);
		tree.delete(75);
		tree.delete(45);
		tree.delete(25);
		tree.delete(15);
		tree.delete(50);
		tree.delete(5);
		assertArrayEquals(new Integer[] { 35, 70 }, tree.traverseInOrder().toArray());
		tree.delete(70);
		tree.delete(35);
		assertArrayEquals(new Integer[] {}, tree.traverseInOrder().toArray());
		tree.delete(456);// no effect, since element doesn't exist
		assertArrayEquals(new Integer[] {}, tree.traverseInOrder().toArray());
		tree.insert(67);
		assertArrayEquals(new Integer[] { 67 }, tree.traverseInOrder().toArray());
		tree.insert(45);
		tree.insert(25);
		tree.insert(55);
		assertArrayEquals(new Integer[] { 25, 45, 55, 67 }, tree.traverseInOrder().toArray());
		tree.delete(67);
		assertArrayEquals(new Integer[] { 25, 45, 55 }, tree.traverseInOrder().toArray());
	}

}
