package com.learning.ads.datastructure.tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StandardRedBlackTreeTest {

	StandardRedBlackTree<Integer> tree;

	@Before
	public void setUp() throws Exception {
		tree = new StandardRedBlackTree<>();
	}

	@Test
	public void insert() {
		tree.insert(50);
		tree.insert(60);
		tree.insert(70);
		tree.insert(80);
		tree.insert(90);
		tree.insert(100);
		assertEquals(3, tree.height());// tree is balanced
	}

}
