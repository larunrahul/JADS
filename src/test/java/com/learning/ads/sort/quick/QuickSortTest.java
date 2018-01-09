package com.learning.ads.sort.quick;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void test() {
		Partition<Integer> p = new LomutoPartition<>();
		QuickSort<Integer, Partition<Integer>> sort = new QuickSort<>(p);
		Integer[] array = { 2, 8, 7, 1, 3, 5, 6, 4 };
		sort.sort(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
	}

}
