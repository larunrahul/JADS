package com.learning.ads.datastructure.queue;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxPriorityQueueTest {

	@Test
	public void heapInsert() {
		Integer[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		MaxPriorityQueue<Integer> queue = new MaxPriorityQueue<>(array, Integer.MIN_VALUE);
		assertArrayEquals(new Integer[] { 16, 14, 10, 8, 7, 9, 3, 2, 4, 1 }, array);
		assertEquals(array.length, queue.getQueueLength());
		assertEquals(Integer.valueOf(16), queue.extratMaximum());
		assertEquals(array.length - 1, queue.getQueueLength());
		queue.heapInsert(15);
		assertArrayEquals(new Integer[] {15, 14, 10, 4, 8, 9, 3, 2, 1, 7}, array);
		assertEquals(array.length, queue.getQueueLength());
	}
	
	@Test
	public void heapDelete() {
		Integer[] array = { 25, 20, 16, 10, 18, 9, 13, 1, 2, 17 };
		MaxPriorityQueue<Integer> queue = new MaxPriorityQueue<>(array, Integer.MIN_VALUE);
		assertArrayEquals(new Integer[] { 25, 20, 16, 10, 18, 9, 13, 1, 2, 17 }, array);
		assertEquals(array.length, queue.getQueueLength());
		queue.heapDelete(0);
		assertEquals(array.length - 1, queue.getQueueLength());
		assertArrayEquals(new Integer[] {20, 18, 16, 10, 17, 9, 13, 1, 2, 25},array);
		queue.heapInsert(35);
		assertArrayEquals(new Integer[] {35, 20, 16, 10, 18, 9, 13, 1, 2, 17}, array);
		assertEquals(array.length, queue.getQueueLength());
	}

}
