package com.learning.ads.string.patternmatch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZAlgorithmTest {

	private ZAlgorithm zAlgorithm = new ZAlgorithm();

	@Test
	public void search() {
		String text = "Hello there! Hope all are good and doing well";
		assertEquals(8, zAlgorithm.search("ABCDABCXAAAAA", "AAAA"));
		assertEquals(0, zAlgorithm.search("AAAAAAAAAAAAA", "AAAA"));
		assertEquals(0, zAlgorithm.search("A", "A"));
		// match at start
		assertEquals(0, zAlgorithm.search("ABABDABACDABABCABAB", "ABABDABA"));
		assertEquals(0, zAlgorithm.search(text, "H"));
		assertEquals(4, zAlgorithm.search(text, "o"));
		assertEquals(35, zAlgorithm.search(text, "doing well"));
		assertEquals(-1, zAlgorithm.search(text, "Hi Hello there!"));
		// match at middle
		assertEquals(6, zAlgorithm.search("ABABDABACDABABCABAB", "BACDABAB"));
		assertEquals(18, zAlgorithm.search(text, "all are good"));
		assertEquals(-1, zAlgorithm.search(text, "good are all"));
		// match at end
		assertEquals(15, zAlgorithm.search("ABCDABCXABXABCDABCDABCY", "ABCDABCY"));
		assertEquals(11, zAlgorithm.search("ABABDABACDABABCABAB", "BABCABAB"));
		assertEquals(5, zAlgorithm.search("ABABCD", "D"));
		assertEquals(35, zAlgorithm.search(text, "doing well"));
		assertEquals(-1, zAlgorithm.search(text, "doing well yeah"));
		// repeating sequences
		assertEquals(-1, zAlgorithm.search("ABCDABCXABXABCDABCDABCY", "ABCYAD"));
		assertEquals(15, zAlgorithm.search("ABCDABCXABXABCDABCDABCY", "ABCDABCY"));
		assertEquals(0, zAlgorithm.search("ABCDABCXABCDABCYABCDABCZABCDABCKABCDABCL", "ABCDABCX"));
		assertEquals(8, zAlgorithm.search("ABCDABCXABCDABCYABCDABCZABCDABCKABCDABCL", "ABCDABCY"));
		assertEquals(16, zAlgorithm.search("ABCDABCXABCDABCYABCDABCZABCDABCKABCDABCL", "ABCDABCZ"));
		assertEquals(32, zAlgorithm.search("ABCDABCXABCDABCYABCDABCZABCDABCKABCDABCL", "ABCDABCL"));
	}

}
