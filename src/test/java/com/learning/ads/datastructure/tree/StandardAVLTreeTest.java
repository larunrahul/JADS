package com.learning.ads.datastructure.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StandardAVLTreeTest {

	StandardAVLTree<Integer> tree;

	@Before
	public void setUp() throws Exception {
		tree = new StandardAVLTree<>();
	}

	@Test
	public void insert() {
		tree.insert(50);
		tree.insert(60);
		tree.insert(70);
		tree.insert(80);
		tree.insert(90);
		tree.insert(100);
		tree.insert(110);
		tree.insert(120);
		tree.insert(130);
		tree.insert(140);
		tree.insert(150);
		tree.insert(160);
		tree.insert(170);
		tree.insert(180);
		tree.insert(190);
		tree.insert(200);
		assertEquals(4, tree.height());
		assertArrayEquals(new Integer[] { 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200 },
				tree.traverseInOrder().toArray());
		assertEquals(16, tree.traverseInOrder().size());
	}
	
	@Test
	public void insertWithVariousCases() {
		tree.insert(20);
		assertArrayEquals(new Integer[] {20}, tree.traverseInOrder().toArray());
		assertEquals(0, tree.height());
		tree.insert(26);
		tree.insert(4);
		tree.insert(3);
		tree.insert(9);
		assertEquals(2, tree.height());
	}

}
