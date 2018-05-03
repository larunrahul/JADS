package com.learning.ads.datastructure.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.learning.ads.datastructure.exception.UnInitializedException;

public class LinkedListTest {

	LinkedList<Integer> list;

	@Before
	public void setUp() {
		list = new LinkedList<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@After
	public void tearDown() {
		list.assertCorrectness();
	}

	@Test
	public void length() {
		assertEquals(10, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test(expected = UnInitializedException.class)
	public void getPositiveIndexWhenEmpty() {
		list = new LinkedList<>();
		list.get(3);
	}

	@Test(expected = UnInitializedException.class)
	public void getNegativeIndexWhenEmpty() {
		list = new LinkedList<>();
		list.get(-3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getWhenIndexOutOfBoundsPositiveIndex() {
		list.get(10);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getWhenIndexOutOfBoundsNegativeIndex() {
		list.get(-11);
	}

	@Test
	public void getPositiveIndex() {
		assertEquals(Integer.valueOf(6), list.get(6));
	}

	@Test
	public void getNegativeIndex() {
		assertEquals(Integer.valueOf(4), list.get(-6));
	}

	@Test
	public void getPositiveIndexFirst() {
		assertEquals(Integer.valueOf(0), list.get(0));
	}

	@Test
	public void getPositiveIndexLast() {
		assertEquals(Integer.valueOf(9), list.get(9));
	}

	@Test
	public void getNegativeIndexFirst() {
		assertEquals(Integer.valueOf(1), list.get(-9));
	}

	@Test
	public void getNegativeIndexLast() {
		assertEquals(Integer.valueOf(9), list.get(-1));
	}

	@Test
	public void getZerothIndexFirst() {
		assertEquals(Integer.valueOf(0), list.get(0));
	}

	@Test
	public void getZerothIndexLast() {
		assertEquals(Integer.valueOf(0), list.get(-10));
	}

	@Test
	public void insertFromStartWhenEmpty() {
		list = new LinkedList<>();
		list.insert(0, 0);
		assertEquals(Integer.valueOf(0), list.get(0));
		assertEquals(1, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(0), list.getTail());
		assertArrayEquals(new Integer[] { 0 }, list.toArray());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertFromStartWhenEmptyOutOfBounds() {
		list = new LinkedList<>();
		list.insert(0, 2);
	}

	@Test
	public void insertAtStartFromStart() {
		list.insert(-1, 0);
		assertEquals(Integer.valueOf(-1), list.get(0));
		assertEquals(11, list.length());
		assertEquals(Integer.valueOf(-1), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test
	public void insertFromStartAfterZero() {
		list.insert(34, 1);
		assertEquals(Integer.valueOf(34), list.get(1));
		assertEquals(Integer.valueOf(0), list.get(0));
		assertEquals(Integer.valueOf(1), list.get(2));
		assertEquals(11, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 0, 34, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test
	public void insertFromStart() {
		list.insert(34, 5);
		assertEquals(Integer.valueOf(34), list.get(5));
		assertEquals(Integer.valueOf(5), list.get(6));
		assertEquals(Integer.valueOf(4), list.get(4));
		assertEquals(11, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 34, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test
	public void insertFromStartAtEnd() {
		list.insert(34, 10);
		assertEquals(Integer.valueOf(34), list.get(10));
		assertEquals(Integer.valueOf(9), list.get(9));
		assertEquals(11, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(34), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 34 }, list.toArray());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertFromStartOutOfBounds() {
		list.insert(34, 11);
	}

	@Test
	public void insertFromEndWhenEmpty() {
		list = new LinkedList<>();
		list.insert(0, -1);
		assertEquals(Integer.valueOf(0), list.get(-1));
		assertEquals(Integer.valueOf(0), list.get(0));
		assertEquals(1, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(0), list.getTail());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertFromEndWhenEmptyOutOfBounds() {
		list = new LinkedList<>();
		list.insert(0, -2);
	}

	@Test
	public void insertAtEndFromEnd() {
		list.insert(43, -1);
		assertEquals(Integer.valueOf(43), list.get(10));
		assertEquals(11, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(43), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 43 }, list.toArray());
	}

	@Test
	public void insertFromEndAfterOne() {
		list.insert(34, -2);
		assertEquals(Integer.valueOf(34), list.get(-2));
		assertEquals(Integer.valueOf(9), list.get(-1));
		assertEquals(Integer.valueOf(8), list.get(-3));
		assertEquals(11, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 34, 9 }, list.toArray());
	}

	@Test
	public void insertFromEnd() {
		list.insert(34, -5);
		assertEquals(Integer.valueOf(34), list.get(-5));
		assertEquals(Integer.valueOf(5), list.get(-6));
		assertEquals(Integer.valueOf(6), list.get(-4));
		assertEquals(11, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 34, 6, 7, 8, 9 }, list.toArray());
	}

	@Test
	public void insertFromEndAtStart() {
		list.insert(34, -11);
		assertEquals(Integer.valueOf(34), list.get(0));
		assertEquals(Integer.valueOf(0), list.get(1));
		assertEquals(11, list.length());
		assertEquals(Integer.valueOf(34), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 34, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertFromEndOutOfBounds() {
		list.insert(34, -12);
	}

	@Test(expected = UnInitializedException.class)
	public void deleteFromStartFirstWhenEmpty() {
		list = new LinkedList<>();
		list.delete(0);
	}

	@Test(expected = UnInitializedException.class)
	public void deleteFromEndFirstWhenEmpty() {
		list = new LinkedList<>();
		list.delete(-1);
	}

	@Test(expected = UnInitializedException.class)
	public void deleteFromStartEndWhenEmpty() {
		list = new LinkedList<>();
		list.delete(9);
	}

	@Test(expected = UnInitializedException.class)
	public void deleteFromEndEndWhenEmpty() {
		list = new LinkedList<>();
		list.delete(-10);
	}

	@Test
	public void deleteFromStartWhenOneElement() {
		list = new LinkedList<>();
		list.append(0);
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(0), list.getTail());
		assertEquals(1, list.length());
		list.delete(0);
		assertEquals(0, list.length());
		assertArrayEquals(new Integer[] {}, list.toArray());
	}

	@Test
	public void deleteFromEndWhenOneElement() {
		list = new LinkedList<>();
		list.append(0);
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(0), list.getTail());
		assertEquals(1, list.length());
		list.delete(-1);
		assertEquals(0, list.length());
		assertArrayEquals(new Integer[] {}, list.toArray());
	}

	@Test
	public void deleteFromStartFirst() {
		list.delete(0);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(1), list.get(0));
		assertEquals(Integer.valueOf(9), list.get(list.length() - 1));
		assertEquals(Integer.valueOf(1), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test
	public void deleteFromEndFirst() {
		list.delete(-1);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(8), list.get(8));
		assertEquals(Integer.valueOf(8), list.get(list.length() - 1));
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(8), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, list.toArray());
	}

	@Test
	public void deleteFromStart() {
		list.delete(1);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(2), list.get(1));
		assertEquals(Integer.valueOf(0), list.get(0));
		assertArrayEquals(new Integer[] { 0, 2, 3, 4, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test
	public void deleteFromEnd() {
		list.delete(-9);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(2), list.get(1));
		assertEquals(Integer.valueOf(0), list.get(0));
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 0, 2, 3, 4, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test
	public void deleteFromStartAtLast() {
		list.delete(9);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(8), list.get(8));
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(8), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, list.toArray());
	}

	@Test
	public void deleteFromEndAtLast() {
		list.delete(-10);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(1), list.get(0));
		assertEquals(Integer.valueOf(1), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test
	public void deleteFromStartAtMiddle() {
		list.delete(7);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(6), list.get(6));
		assertEquals(Integer.valueOf(8), list.get(7));
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 8, 9 }, list.toArray());
	}

	@Test
	public void deleteFromEndAtMiddle() {
		list.delete(-7);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(2), list.get(2));
		assertEquals(Integer.valueOf(4), list.get(3));
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 4, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test
	public void insertDelete() {
		list = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.insert(i, i);
			assertEquals(Integer.valueOf(0), list.getHead());
			assertEquals(Integer.valueOf(i), list.getTail());
		}
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, list.toArray());
		for (int i = 9; i >= 0; i--) {
			assertEquals(Integer.valueOf(0), list.getHead());
			assertEquals(list.get(i), list.getTail());
			list.delete(i);
		}
		assertEquals(0, list.length());
		assertArrayEquals(new Integer[] {}, list.toArray());
	}

	@Test
	public void prependToEmptyList() {
		list = new LinkedList<>();
		list.prepend(0);
		assertEquals(1, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(0), list.getTail());
		assertArrayEquals(new Integer[] { 0 }, list.toArray());
	}

	@Test
	public void prependToNonEmptyList() {
		list.prepend(-1);
		assertEquals(11, list.length());
		assertEquals(Integer.valueOf(-1), list.getHead());
		assertEquals(Integer.valueOf(9), list.getTail());
		assertArrayEquals(new Integer[] { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, list.toArray());
	}

	@Test
	public void appendToEmptyList() {
		list = new LinkedList<>();
		list.append(0);
		assertEquals(1, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(0), list.getTail());
		assertArrayEquals(new Integer[] { 0 }, list.toArray());
	}

	@Test
	public void appendToNonEmptyList() {
		list.append(10);
		assertEquals(11, list.length());
		assertEquals(Integer.valueOf(0), list.getHead());
		assertEquals(Integer.valueOf(10), list.getTail());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, list.toArray());
	}

}
