package com.learning.ads.string.patternmatch;

public class NaivePatternMatching {
	/**
	 * 
	 * Brute force string matching algorithm
	 * 
	 * Complexity: O(n * m) where n is length of text and m is length of pattern
	 * 
	 * @param text
	 *            Whole text in which we want to search for a pattern
	 * @param pattern
	 *            String which we want to search in text
	 * 
	 * @return Index of the pattern in the text if matched, otherwise -1
	 */
	public int search(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		for (int i = 0; i <= n - m; i++) {
			int j = 0;
			while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
				j++;
			}
			if (j == m) {
				return i;
			}
		}
		return -1;
	}
}
