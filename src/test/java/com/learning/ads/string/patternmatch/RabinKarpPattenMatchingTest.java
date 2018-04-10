package com.learning.ads.string.patternmatch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RabinKarpPattenMatchingTest {

	private RabinKarpPattenMatching rabinKarpPattenMatching = new RabinKarpPattenMatching();

	@Test
	public void search() {
		String text = "Hello there! Hope all are good and doing well";
		// match at start
		assertEquals(0, rabinKarpPattenMatching.search(text, "Hello there!"));
		assertEquals(-1, rabinKarpPattenMatching.search(text, "Hi Hello there!"));
		// match at middle
		assertEquals(18, rabinKarpPattenMatching.search(text, "all are good"));
		assertEquals(-1, rabinKarpPattenMatching.search(text, "good are all"));
		// match at end
		assertEquals(35, rabinKarpPattenMatching.search(text, "doing well"));
		assertEquals(-1, rabinKarpPattenMatching.search(text, "doing well yeah"));
	}

}
