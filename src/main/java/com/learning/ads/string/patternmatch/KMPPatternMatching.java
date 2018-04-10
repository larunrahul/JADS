package com.learning.ads.string.patternmatch;

public class KMPPatternMatching {

	/**
	 * https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
	 * 
	 * https://www.youtube.com/watch?v=t4xUA-aHzy8
	 * 
	 * https://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
	 * 
	 * Complexity: O(n) + O(m) for creating lps array where n is length of text and
	 * m is length of pattern
	 * 
	 * @param text
	 *            Whole text in which we want to search for a pattern
	 * @param pattern
	 *            String which we want to search in text
	 * 
	 * @return Index of the pattern in the text if matched, otherwise -1
	 */
	public int search(String text, String pattern) {
		return -1;
	}

	/*
	 * Finding length of longest suffix which is also a proper prefix for every
	 * index in pattern
	 */
	private int[] computeLPS(String pattern) {
		int[] lps = new int[pattern.length()];

		return lps;
	}

}
