package com.learning.ads.greedy;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ActivitySelectorTest {

	@Test
	public void selectRecursive() {
		ActivitySelector as = new ActivitySelector();
		addActivities(as);
		int[][] selected = as.select();
		assertArrayEquals(new int[] { 1, 5, 8, 12 }, selected[0]);
		assertArrayEquals(new int[] { 4, 7, 11, 16 }, selected[1]);
	}

	public void selectIterative() {
		ActivitySelector as = new ActivitySelector();
		addActivities(as);
		int[][] selected = as.selectIterative();
		assertArrayEquals(new int[] { 1, 5, 8, 12 }, selected[0]);
		assertArrayEquals(new int[] { 4, 7, 11, 16 }, selected[1]);
	}

	private void addActivities(ActivitySelector as) {
		as.addActivity(1, 4);
		as.addActivity(8, 12);
		as.addActivity(3, 5);
		as.addActivity(3, 9);
		as.addActivity(8, 11);
		as.addActivity(12, 16);
		as.addActivity(5, 7);
		as.addActivity(0, 6);
		as.addActivity(6, 10);
		as.addActivity(5, 9);
		as.addActivity(2, 14);
	}

}
