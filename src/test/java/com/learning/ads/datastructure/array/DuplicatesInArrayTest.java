package com.learning.ads.datastructure.array;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DuplicatesInArrayTest {

	DuplicatesInArray duplicatesInArray = new DuplicatesInArray();

	@Test
	public void duplicates() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(6);
		assertArrayEquals(list.toArray(), duplicatesInArray.duplicates(new int[] { 1, 2, 3, 1, 3, 6, 6 }).toArray());
	}

}
