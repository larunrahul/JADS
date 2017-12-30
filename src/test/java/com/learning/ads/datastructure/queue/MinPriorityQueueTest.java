package com.learning.ads.datastructure.queue;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinPriorityQueueTest {

	@Test
	public void heapInsert() {
		Integer[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		MinPriorityQueue<Integer> queue = new MinPriorityQueue<>(array, Integer.MAX_VALUE);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 7, 9, 10, 14, 8, 16 }, array);
		assertEquals(array.length, queue.getQueueLength());
		assertEquals(Integer.valueOf(1), queue.extratMinimum());
		assertEquals(array.length - 1, queue.getQueueLength());
		queue.heapInsert(1);
		assertEquals(array.length, queue.getQueueLength());
		assertArrayEquals(new Integer[] { 1, 2, 3, 8, 4, 9, 10, 14, 16, 7 }, array);
		assertEquals(Integer.valueOf(1), queue.minimum());
	}

	@Test
	public void heapDelete() {
		Integer[] array = { 25, 20, 16, 10, 18, 9, 13, 1, 2, 17 };
		MinPriorityQueue<Integer> queue = new MinPriorityQueue<>(array, Integer.MAX_VALUE);
		assertArrayEquals(new Integer[] { 1, 2, 9, 10, 17, 16, 13, 25, 20, 18 }, array);
		assertEquals(array.length, queue.getQueueLength());
		queue.heapDelete(0);
		assertEquals(array.length - 1, queue.getQueueLength());
		assertArrayEquals(new Integer[] { 2, 10, 9, 18, 17, 16, 13, 25, 20, 1 }, array);
		queue.heapInsert(3);
		assertEquals(array.length, queue.getQueueLength());
		assertArrayEquals(new Integer[] { 2, 3, 9, 18, 10, 16, 13, 25, 20, 17 }, array);
	}

}
