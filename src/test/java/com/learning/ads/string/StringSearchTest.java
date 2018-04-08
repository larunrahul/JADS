package com.learning.ads.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringSearchTest {

	StringSearch stringSearch = new StringSearch();

	@Test
	public void bruteForce() {
		String text = "Hello there! Hope all are good and doing well";
		// match at start
		assertEquals(0, stringSearch.bruteForce(text, "Hello there!"));
		assertEquals(-1, stringSearch.bruteForce(text, "Hi Hello there!"));
		// match at middle
		assertEquals(18, stringSearch.bruteForce(text, "all are good"));
		assertEquals(-1, stringSearch.bruteForce(text, "good are all"));
		// match at end
		assertEquals(35, stringSearch.bruteForce(text, "doing well"));
		assertEquals(-1, stringSearch.bruteForce(text, "doing well yeah"));
	}
	
	@Test
	public void RabinKarp() {
		String text = "Hello there! Hope all are good and doing well";
		// match at start
		assertEquals(0, stringSearch.RabinKarp(text, "Hello there!"));
		assertEquals(-1, stringSearch.RabinKarp(text, "Hi Hello there!"));
		// match at middle
		assertEquals(18, stringSearch.RabinKarp(text, "all are good"));
		assertEquals(-1, stringSearch.RabinKarp(text, "good are all"));
		// match at end
		assertEquals(35, stringSearch.RabinKarp(text, "doing well"));
		assertEquals(-1, stringSearch.RabinKarp(text, "doing well yeah"));
	}

}
