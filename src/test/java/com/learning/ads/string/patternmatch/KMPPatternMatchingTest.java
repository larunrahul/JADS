package com.learning.ads.string.patternmatch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KMPPatternMatchingTest {

	private KMPPatternMatching kmpPatternMatching = new KMPPatternMatching();

	@Test
	public void search() {
		String text = "Hello there! Hope all are good and doing well";

		// match at start
		assertEquals(0, kmpPatternMatching.search("ABABDABACDABABCABAB", "ABABDABA"));
		assertEquals(0, kmpPatternMatching.search(text, "H"));
		assertEquals(35, kmpPatternMatching.search(text, "doing well"));
		assertEquals(-1, kmpPatternMatching.search(text, "Hi Hello there!"));
		// match at middle
		assertEquals(6, kmpPatternMatching.search("ABABDABACDABABCABAB", "BACDABAB"));
		assertEquals(18, kmpPatternMatching.search(text, "all are good"));
		assertEquals(-1, kmpPatternMatching.search(text, "good are all"));
		// match at end
		assertEquals(15, kmpPatternMatching.search("ABCDABCXABXABCDABCDABCY", "ABCDABCY"));
		assertEquals(11, kmpPatternMatching.search("ABABDABACDABABCABAB", "BABCABAB"));
		assertEquals(5, kmpPatternMatching.search("ABABCD", "D"));
		assertEquals(35, kmpPatternMatching.search(text, "doing well"));
		assertEquals(-1, kmpPatternMatching.search(text, "doing well yeah"));

	}

}
