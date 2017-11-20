package com.learning.ads.datastructure.list;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.learning.ads.datastructure.exception.UnInitializedException;

public class DoubleLinkedListTest {

	DoublyLinkedList<Integer> list;

	@Before
	public void setUp() {
		list = new DoublyLinkedList<>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Test
	public void length() {
		assertEquals(10, list.length());
	}

	@Test(expected = UnInitializedException.class)
	public void getPositiveIndexWhenEmpty() {
		list = new DoublyLinkedList<>();
		list.get(3);
	}

	@Test(expected = UnInitializedException.class)
	public void getNegativeIndexWhenEmpty() {
		list = new DoublyLinkedList<>();
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
	public void getPositiveIndexFromStart() {
		assertEquals(Integer.valueOf(4), list.get(4));
	}
	
	@Test
	public void getPositiveIndexFromEnd() {
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
		list = new DoublyLinkedList<>();
		list.insert(0, 0);
		assertEquals(Integer.valueOf(0), list.get(0));
		assertEquals(1, list.length());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertFromStartWhenEmptyOutOfBounds() {
		list = new DoublyLinkedList<>();
		list.insert(0, 2);
	}

	@Test
	public void insertAtStartFromStart() {
		list.insert(-1, 0);
		assertEquals(Integer.valueOf(-1), list.get(0));
		assertEquals(11, list.length());
	}

	@Test
	public void insertFromStartAfterZero() {
		list.insert(34, 1);
		assertEquals(Integer.valueOf(34), list.get(1));
		assertEquals(Integer.valueOf(0), list.get(0));
		assertEquals(Integer.valueOf(1), list.get(2));
		assertEquals(11, list.length());
	}

	@Test
	public void insertFromStart() {
		list.insert(34, 5);
		assertEquals(Integer.valueOf(34), list.get(5));
		assertEquals(Integer.valueOf(5), list.get(6));
		assertEquals(Integer.valueOf(4), list.get(4));
		assertEquals(11, list.length());
	}

	@Test
	public void insertFromStartAtEnd() {
		list.insert(34, 10);
		assertEquals(Integer.valueOf(34), list.get(10));
		assertEquals(Integer.valueOf(9), list.get(9));
		assertEquals(11, list.length());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertFromStartOutOfBounds() {
		list.insert(34, 11);
	}

	@Test
	public void insertFromEndWhenEmpty() {
		list = new DoublyLinkedList<>();
		list.insert(0, -1);
		assertEquals(Integer.valueOf(0), list.get(-1));
		assertEquals(Integer.valueOf(0), list.get(0));
		assertEquals(1, list.length());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertFromEndWhenEmptyOutOfBounds() {
		list = new DoublyLinkedList<>();
		list.insert(0, -2);
	}

	@Test
	public void insertAtEndFromEnd() {
		list.insert(43, -1);
		assertEquals(Integer.valueOf(43), list.get(10));
		assertEquals(11, list.length());
	}

	@Test
	public void insertFromEndAfterOne() {
		list.insert(34, -2);
		assertEquals(Integer.valueOf(34), list.get(-2));
		assertEquals(Integer.valueOf(9), list.get(-1));
		assertEquals(Integer.valueOf(8), list.get(-3));
		assertEquals(11, list.length());
	}

	@Test
	public void insertFromEnd() {
		list.insert(34, -5);
		assertEquals(Integer.valueOf(34), list.get(-5));
		assertEquals(Integer.valueOf(5), list.get(-6));
		assertEquals(Integer.valueOf(6), list.get(-4));
		assertEquals(11, list.length());
	}

	@Test
	public void insertFromEndAtStart() {
		list.insert(34, -11);
		assertEquals(Integer.valueOf(34), list.get(0));
		assertEquals(Integer.valueOf(0), list.get(1));
		assertEquals(11, list.length());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertFromEndOutOfBounds() {
		list.insert(34, -12);
	}

	@Test(expected = UnInitializedException.class)
	public void deleteFromStartFirstWhenEmpty() {
		list = new DoublyLinkedList<>();
		list.delete(0);
	}
	
	@Test(expected = UnInitializedException.class)
	public void deleteFromEndFirstWhenEmpty() {
		list = new DoublyLinkedList<>();
		list.delete(-1);
	}
	
	@Test(expected = UnInitializedException.class)
	public void deleteFromStartEndWhenEmpty() {
		list = new DoublyLinkedList<>();
		list.delete(9);
	}

	@Test(expected = UnInitializedException.class)
	public void deleteFromEndEndWhenEmpty() {
		list = new DoublyLinkedList<>();
		list.delete(-10);
	}

	@Test
	public void deleteFromStartWhenOneElement() {
		list = new DoublyLinkedList<>();
		list.append(0);
		assertEquals(1, list.length());
		list.delete(0);
		assertEquals(0, list.length());
	}

	@Test
	public void deleteFromEndWhenOneElement() {
		list = new DoublyLinkedList<>();
		list.append(0);
		assertEquals(1, list.length());
		list.delete(-1);
		assertEquals(0, list.length());
	}

	@Test
	public void deleteFromStartFirst() {
		list.delete(0);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(1), list.get(0));
		assertEquals(Integer.valueOf(9), list.get(list.length() - 1));
	}

	@Test
	public void deleteFromEndFirst() {
		list.delete(-1);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(8), list.get(8));
		assertEquals(Integer.valueOf(8), list.get(list.length() - 1));
	}

	@Test
	public void deleteFromStart() {
		list.delete(1);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(2), list.get(1));
		assertEquals(Integer.valueOf(0), list.get(0));
	}
	
	@Test
	public void deleteFromEnd() {
		list.delete(-9);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(2), list.get(1));
		assertEquals(Integer.valueOf(0), list.get(0));
	}

	@Test
	public void deleteFromStartAtLast() {
		list.delete(9);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(8), list.get(8));
	}
	
	@Test
	public void deleteFromEndAtLast() {
		list.delete(-10);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(1), list.get(0));
	}

	@Test
	public void deleteFromStartAtMiddle() {
		list.delete(7);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(6), list.get(6));
		assertEquals(Integer.valueOf(8), list.get(7));
	}
	
	@Test
	public void deleteFromEndAtMiddle() {
		list.delete(-7);
		assertEquals(9, list.length());
		assertEquals(Integer.valueOf(2), list.get(2));
		assertEquals(Integer.valueOf(4), list.get(3));
	}

}
