package com.learning.ads.design;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MedianOfDataStreamHeapSolutionTest {

	MedianOfDataStreamHeapSolution heapSolution = new MedianOfDataStreamHeapSolution();

	@Test
	public void runningMedian() {
		assertArrayEquals(new double[] { 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5 },
				heapSolution.runningMedian(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }), 0);
		assertArrayEquals(new double[] { 10.0, 9.5, 9.0, 8.5, 8.0, 7.5, 7.0, 6.5, 6.0, 5.5 },
				heapSolution.runningMedian(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }), 0);
		assertArrayEquals(new double[] { 12.0, 8.0, 5.0, 4.5, 5.0, 6.0 },
				heapSolution.runningMedian(new int[] { 12, 4, 5, 3, 8, 7 }), 0);
	}

}
