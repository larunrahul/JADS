package com.learning.ads.search;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LinearSearchTest {
	
	private LinearSearch linearSearch = new LinearSearch();

	@Test
	public void search() {
		assertEquals(4, linearSearch.search(new int[]{4,1,7,3,5,9,2}, 3));
	}

}
