package com.learning.ads.string.patternmatch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NaivePatternMatchingTest {

	private NaivePatternMatching naivePatternMatching = new NaivePatternMatching();

	@Test
	public void search() {
		String text = "Hello there! Hope all are good and doing well";
		// match at start
		assertEquals(0, naivePatternMatching.search(text, "Hello there!"));
		assertEquals(-1, naivePatternMatching.search(text, "Hi Hello there!"));
		// match at middle
		assertEquals(18, naivePatternMatching.search(text, "all are good"));
		assertEquals(-1, naivePatternMatching.search(text, "good are all"));
		// match at end
		assertEquals(35, naivePatternMatching.search(text, "doing well"));
		assertEquals(-1, naivePatternMatching.search(text, "doing well yeah"));
	}

}
