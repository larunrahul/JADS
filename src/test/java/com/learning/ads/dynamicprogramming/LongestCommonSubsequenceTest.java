package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;

public class LongestCommonSubsequenceTest {

	private LongestCommonSubsequence lcs = new LongestCommonSubsequence();

	@Test
	public void lcs() {
		String s1 = "ABCBDAB", s2 = "BDCABA";
		assertArrayEquals("BCBA".toCharArray(), lcs.lcs(s1, s2));
	}

	@Test
	public void lcsBottomUp() {
		String s1 = "ABCBDAB", s2 = "BDCABA";
		assertArrayEquals("BCBA".toCharArray(), lcs.lcsBottomUp(s1, s2));
		s1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
		s2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
		assertArrayEquals("GTCGTCGGAAGCCGGCCGAA".toCharArray(), lcs.lcsBottomUp(s1, s2));
	}
	
	@Test
	public void lcsTopDown() {
		String s1 = "ABCBDAB", s2 = "BDCABA";
		assertArrayEquals("BCBA".toCharArray(), lcs.lcsTopDown(s1, s2));
		s1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
		s2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
		assertArrayEquals("GTCGTCGGAAGCCGGCCGAA".toCharArray(), lcs.lcsTopDown(s1, s2));
	}

}
