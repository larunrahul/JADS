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
		
		assertEquals(8, rabinKarpPattenMatching.search("ABCDABCXAAAAA", "AAAA"));
		assertEquals(0, rabinKarpPattenMatching.search("AAAAAAAAAAAAA", "AAAA"));
		assertEquals(0, rabinKarpPattenMatching.search("A", "A"));
		// match at start
		assertEquals(0, rabinKarpPattenMatching.search("ABABDABACDABABCABAB", "ABABDABA"));
		assertEquals(0, rabinKarpPattenMatching.search(text, "H"));
		assertEquals(4, rabinKarpPattenMatching.search(text, "o"));
		assertEquals(35, rabinKarpPattenMatching.search(text, "doing well"));
		assertEquals(-1, rabinKarpPattenMatching.search(text, "Hi Hello there!"));
		// match at middle
		assertEquals(6, rabinKarpPattenMatching.search("ABABDABACDABABCABAB", "BACDABAB"));
		assertEquals(18, rabinKarpPattenMatching.search(text, "all are good"));
		assertEquals(-1, rabinKarpPattenMatching.search(text, "good are all"));
		// match at end
		assertEquals(15, rabinKarpPattenMatching.search("ABCDABCXABXABCDABCDABCY", "ABCDABCY"));
		assertEquals(11, rabinKarpPattenMatching.search("ABABDABACDABABCABAB", "BABCABAB"));
		assertEquals(5, rabinKarpPattenMatching.search("ABABCD", "D"));
		assertEquals(35, rabinKarpPattenMatching.search(text, "doing well"));
		assertEquals(-1, rabinKarpPattenMatching.search(text, "doing well yeah"));
		// repeating sequences
		assertEquals(-1, rabinKarpPattenMatching.search("ABCDABCXABXABCDABCDABCY", "ABCYAD"));
		assertEquals(15, rabinKarpPattenMatching.search("ABCDABCXABXABCDABCDABCY", "ABCDABCY"));
		assertEquals(0, rabinKarpPattenMatching.search("ABCDABCXABCDABCYABCDABCZABCDABCKABCDABCL", "ABCDABCX"));
		assertEquals(8, rabinKarpPattenMatching.search("ABCDABCXABCDABCYABCDABCZABCDABCKABCDABCL", "ABCDABCY"));
		assertEquals(16, rabinKarpPattenMatching.search("ABCDABCXABCDABCYABCDABCZABCDABCKABCDABCL", "ABCDABCZ"));
		assertEquals(32, rabinKarpPattenMatching.search("ABCDABCXABCDABCYABCDABCZABCDABCKABCDABCL", "ABCDABCL"));
	}

}
