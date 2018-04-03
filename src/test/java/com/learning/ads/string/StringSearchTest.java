package com.learning.ads.string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringSearchTest {

	StringSearch bruteForceStringSearch = new StringSearch();

	@Test
	public void bruteForce() {
		assertTrue(bruteForceStringSearch.bruteForce("Hello there! Hope all are good and doing well", "all are good"));
		assertFalse(bruteForceStringSearch.bruteForce("Hello there! Hope all are good and doing well", "good are all"));
	}

}
