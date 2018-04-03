package com.learning.ads.string;

/**
 * Different algorithms for String search
 * 
 * @author Arun Rahul
 *
 */
public class StringSearch {

	/**
	 * 
	 * Brute force string matching algorithm
	 * 
	 * Complexity: O(n*m) where n is length of text and m is length of pattern
	 * 
	 * @param text
	 *            Whole text in which we want to search for a pattern
	 * @param pattern
	 *            String which we want to search in text
	 * @return
	 */
	public boolean bruteForce(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		char[] texts = text.toCharArray();
		char[] patterns = pattern.toCharArray();
		for (int i = 0; i < n - m; i++) {
			int j = 0;
			while (j < m && texts[i + j] == patterns[j]) {
				j++;
			}
			if (j == m) {
				return true;
			}
		}
		return false;
	}

}
