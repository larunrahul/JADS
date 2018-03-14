package com.learning.ads.datastructure.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

	Stack<Integer> s;

	@Before
	public void setUp() throws Exception {
		s = new Stack<>();
		assertFalse(s.isFull());
	}

	@Test
	public void emptyStack() {
		assertEquals(0, s.length());
	}

	@Test
	public void push() {
		assertEquals(0, s.length());
		s.push(10);
		assertTrue(s.isFull());
		assertEquals(1, s.length());
		s.push(11);
		assertTrue(s.isFull());
		s.push(12);
		assertFalse(s.isFull());
		s.push(13);
		assertEquals(4, s.length());
		assertTrue(s.isFull());
	}

	@Test(expected = RuntimeException.class)
	public void popWithEmptyStack() {
		s.pop();
	}

	public void pop() {
		assertEquals(0, s.length());
		s.push(10);
		assertTrue(s.isFull());
		assertEquals(1, s.length());
		s.pop();
		assertFalse(s.isFull());
		assertEquals(0, s.length());
		s.push(11);
		assertTrue(s.isFull());
		s.push(12);
		assertTrue(s.isFull());
		s.push(13);
		assertFalse(s.isFull());
		assertEquals(1, s.length());
		s.pop();
		s.pop();
		s.pop();
		assertFalse(s.isFull());
		assertEquals(0, s.length());
		try {
			s.pop();
			fail("shouldn't be here");
		} catch (RuntimeException e) {
		}
	}

	@Test(expected = RuntimeException.class)
	public void peekWithEmptyStack() {
		s.peek();
	}

	@Test
	public void peek() {
		assertEquals(0, s.length());
		s.push(10);
		assertTrue(s.isFull());
		assertEquals(1, s.length());
		assertEquals(Integer.valueOf(10), s.peek());
		assertEquals(1, s.length()); // length don't change if we call peek, as it just returns the top element but
										// not remove it
		s.push(11);
		assertTrue(s.isFull());
		s.push(12);
		assertFalse(s.isFull());
		s.push(13);
		assertTrue(s.isFull());
		assertEquals(4, s.length());
		assertEquals(Integer.valueOf(13), s.peek());
		assertEquals(4, s.length());
	}

	@Test
	public void bulkInitAndPush() {
		s = new Stack<>(10, 11, 12, 13);
		assertEquals(4, s.length());
		assertEquals(Integer.valueOf(13), s.peek());
		assertTrue(s.isFull());
		s.push(14);
		assertFalse(s.isFull());
		assertEquals(5, s.length());
		assertEquals(Integer.valueOf(14), s.peek());
	}
 
	@Test
	public void bulkInitAndPop() {
		s = new Stack<>(10, 11, 12, 13);
		assertEquals(4, s.length());
		assertEquals(Integer.valueOf(13), s.peek());
		assertTrue(s.isFull());
		s.pop();
		assertFalse(s.isFull());
		assertEquals(3, s.length());
		assertEquals(Integer.valueOf(12), s.peek());
	}

}
