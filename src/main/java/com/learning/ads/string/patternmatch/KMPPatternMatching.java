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
		// O(n)
		for (int i = 0, j = 0; i < n;) {
			while (i < n && j < m && text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			// if all characters in pattern matches
			if (j == m) {
				return i - j;
			}
			// if no character in pattern matches
			if (j == 0) {
				i++;
			} else { // if few characters in pattern matches
				j = lps[j - 1];
			}
		}
		return -1;
	}

	/*
	 * Finding length of longest proper suffix which is also a proper prefix for
	 * every index in pattern.
	 * 
	 * For every substring 0...i, we find longest proper prefix which is also suffix
	 * 
	 * Complexity: O(m) where m is length of pattern
	 */
	private int[] computeLPS(String pattern) {
		int[] lps = new int[pattern.length()];
		int i = 1, len = 0;
		lps[0] = 0; //first 
		while(i < pattern.length()){
			if(pattern.charAt(i) == pattern.charAt(len)){ //example: abcd...abcd, for last index of d
				len++;
				lps[i] = len;
				i++;
			}else {
				if(len == 0){
					//here lps[i] is 0, so just increment it since array element at this index is already 0
					i++;
				}else {
					len = lps[len - 1];
				}
			}
		}
		return lps;
	}

}
