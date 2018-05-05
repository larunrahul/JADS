package com.learning.ads.string.patternmatch;

import com.learning.ads.hash.RollingHash;

public class RabinKarpPattenMatching {

	private static final int MOD = 1000000007;
	private static final int BASE = 31;
	
	private RollingHash rollingHash = new RollingHash(BASE, MOD);

	/**
	 * https://en.wikipedia.org/wiki/Rabin%E2%80%93Karp_algorithm
	 * 
	 * https://www.topcoder.com/community/data-science/data-science-tutorials/introduction-to-string-searching-algorithms/
	 * 
	 * Complexity:
	 * 
	 * Worst case - O(n * m) where n is length of text and m is length of pattern
	 * 
	 * Best case - O(n + m) where n is length of text and m is length of pattern
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
		long patternHash = rollingHash.firstHash(pattern, m);
		long textHash = 0;
		for (int i = 0; i <= n - m; i++) {
			if ((textHash = rollingHash.hash(text, i, i + m, textHash)) == patternHash) {
				int j = 0;
				while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
					j++;
				}
				if (j == m) {
					return i;
				}
			}
		}
		return -1;
	}

}
