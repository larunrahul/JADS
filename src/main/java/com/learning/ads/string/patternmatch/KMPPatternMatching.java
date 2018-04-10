package com.learning.ads.string.patternmatch;

public class KMPPatternMatching {

	/**
	 * https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
	 * 
	 * https://www.youtube.com/watch?v=t4xUA-aHzy8
	 * 
	 * https://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
	 * 
	 * Complexity: O(n) (for comparison) + O(m) (for creating lps array) where n is
	 * length of text and m is length of pattern
	 * 
	 * @param text
	 *            Whole text in which we want to search for a pattern
	 * @param pattern
	 *            String which we want to search in text
	 * 
	 * @return Index of the pattern in the text if matched, otherwise -1
	 */
	public int search(String text, String pattern) {
		// O(m)
		int[] lps = computeLPS(pattern);
		int n = text.length();
		int m = pattern.length();
		int remainingLength = m;
		int j = 0;
		// O(n-m)
		for (int i = 0; i <= n - m; i++) {
			while (j < remainingLength && text.charAt(i + j) == pattern.charAt(j)) {
				j++;
			}
			if (j == m) {
				return i;
			}
			if (j == remainingLength) {
				return i - lps[j - 1];
			}
			j = lps[(j - 1) < 0 ? 0 : j - 1];
			remainingLength = m - j;
		}
		return -1;
	}

	/*
	 * Finding length of longest proper suffix which is also a proper prefix for
	 * every index in pattern.
	 * 
	 * Complexity: O(m) where m is length of pattern
	 */
	private int[] computeLPS(String pattern) {
		int[] lps = new int[pattern.length()];
		lps[0] = 0;
		for (int i = 1; i < lps.length; i++) {
			if (pattern.charAt(lps[i - 1]) == pattern.charAt(i)) {
				lps[i] = lps[i - 1] + 1;
			} else if (pattern.charAt(i - 1) == pattern.charAt(i)) {
				lps[i] = lps[i - 1];
			} else {
				lps[i] = 0;
			}
		}
		return lps;
	}

}
