package com.learning.ads.datastructure.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	Queue<Integer> queue = new Queue<>();

	@Before
	public void setUp() throws Exception {
		queue = new Queue<>();
		assertFalse(queue.isFull());
		assertEquals(0, queue.length());
	}

	@Test
	public void bulkFilledQueue() {
		queue = new Queue<>(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		assertEquals(10, queue.length());
		assertEquals(Integer.valueOf(10), queue.tail());
		assertEquals(Integer.valueOf(1), queue.head());
		queue.deQueue();
		assertEquals(9, queue.length());
		assertEquals(Integer.valueOf(10), queue.tail());
		assertEquals(Integer.valueOf(2), queue.head());
		queue.enQueue(11);
		assertEquals(10, queue.length());
		assertEquals(Integer.valueOf(11), queue.tail());
		assertEquals(Integer.valueOf(2), queue.head());
		queue.enQueue(12);
		assertEquals(11, queue.length());
		assertEquals(Integer.valueOf(12), queue.tail());
		assertEquals(Integer.valueOf(2), queue.head());
	}

	@Test
	public void allOperations() {
		queue.enQueue(1);
		assertEquals(1, queue.length());
		assertEquals(Integer.valueOf(1), queue.tail());
		assertEquals(Integer.valueOf(1), queue.head());
		queue.deQueue();
		assertEquals(0, queue.length());
		queue.enQueue(1);
		assertEquals(1, queue.length());
		assertEquals(Integer.valueOf(1), queue.tail());
		assertEquals(Integer.valueOf(1), queue.head());
		queue.enQueue(2);
		assertEquals(2, queue.length());
		assertEquals(Integer.valueOf(2), queue.tail());
		assertEquals(Integer.valueOf(1), queue.head());
		queue.deQueue();
		assertEquals(1, queue.length());
		assertEquals(Integer.valueOf(2), queue.tail());
		assertEquals(Integer.valueOf(2), queue.head());
		queue.deQueue();
		assertEquals(0, queue.length());
		queue.enQueue(1);
		queue.enQueue(2);
		assertEquals(2, queue.length());
		assertEquals(Integer.valueOf(2), queue.tail());
		assertEquals(Integer.valueOf(1), queue.head());
		queue.deQueue();
		assertEquals(1, queue.length());
		assertEquals(Integer.valueOf(2), queue.tail());
		assertEquals(Integer.valueOf(2), queue.head());
		queue.deQueue();
		assertEquals(0, queue.length());
		queue.enQueue(1);
		assertEquals(1, queue.length());
		assertEquals(Integer.valueOf(1), queue.tail());
		assertEquals(Integer.valueOf(1), queue.head());
		queue.enQueue(2);
		assertEquals(2, queue.length());
		assertEquals(Integer.valueOf(2), queue.tail());
		assertEquals(Integer.valueOf(1), queue.head());
		queue.enQueue(3);
		assertEquals(3, queue.length());
		assertEquals(Integer.valueOf(3), queue.tail());
		assertEquals(Integer.valueOf(1), queue.head());
		queue.enQueue(4);
		assertEquals(4, queue.length());
		assertEquals(Integer.valueOf(4), queue.tail());
		assertEquals(Integer.valueOf(1), queue.head());
		queue.deQueue();
		assertEquals(3, queue.length());
		assertEquals(Integer.valueOf(4), queue.tail());
		assertEquals(Integer.valueOf(2), queue.head());
		queue.enQueue(5);
		assertEquals(4, queue.length());
		assertEquals(Integer.valueOf(5), queue.tail());
		assertEquals(Integer.valueOf(2), queue.head());
		queue.enQueue(6);
		assertEquals(5, queue.length());
		assertEquals(Integer.valueOf(6), queue.tail());
		assertEquals(Integer.valueOf(2), queue.head());
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(9);
		assertEquals(8, queue.length());
		assertEquals(Integer.valueOf(9), queue.tail());
		assertEquals(Integer.valueOf(2), queue.head());
		queue.deQueue();
		assertEquals(7, queue.length());
		assertEquals(Integer.valueOf(9), queue.tail());
		assertEquals(Integer.valueOf(3), queue.head());
		queue.enQueue(10);
		assertEquals(8, queue.length());
		assertEquals(Integer.valueOf(10), queue.tail());
		assertEquals(Integer.valueOf(3), queue.head());
		queue.deQueue();
		queue.enQueue(11);
		assertEquals(8, queue.length());
		assertEquals(Integer.valueOf(11), queue.tail());
		assertEquals(Integer.valueOf(4), queue.head());
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		assertEquals(3, queue.length());
		assertEquals(Integer.valueOf(11), queue.tail());
		assertEquals(Integer.valueOf(9), queue.head());
		queue.deQueue();
		assertEquals(2, queue.length());
		assertEquals(Integer.valueOf(11), queue.tail());
		assertEquals(Integer.valueOf(10), queue.head());
		queue.deQueue();
		assertEquals(1, queue.length());
		assertEquals(Integer.valueOf(11), queue.tail());
		assertEquals(Integer.valueOf(11), queue.head());
		queue.deQueue();
		assertEquals(0, queue.length());
		try {
			queue.tail();
			fail("shouldn't be here");
		} catch (RuntimeException e) {

		}
		try {
			queue.head();
			fail("shouldn't be here");
		} catch (RuntimeException e) {

		}
	}

}
