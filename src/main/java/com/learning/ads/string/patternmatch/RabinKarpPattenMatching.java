package com.learning.ads.string.patternmatch;

public class RabinKarpPattenMatching {

	private static final int MOD = 1000000007;
	private static final int BASE = 31;

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
		long patternHash = firstHash(pattern, 0, m);
		long textHash = 0;
		for (int i = 0; i <= n - m; i++) {
			if ((textHash = rollingHash(text, i, i + m, textHash)) == patternHash) {
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

	/**
	 * Calculate the hash for the given array elements with given range.
	 * 
	 * Following algorithm uses Horner's method to calculate the hash for the string
	 * (array of characters). It treats every string a polynomial. Also, the
	 * following algorithm applies modulo to result in every step to prevent
	 * overflows
	 * 
	 * http://makble.com/hash-function-algorithm-modular-arithmetic-and-horners-method
	 * 
	 * https://en.wikipedia.org/wiki/Horner%27s_method
	 * 
	 * https://stackoverflow.com/questions/20412405/rolling-hash-in-rabin-karp
	 * 
	 * 
	 * 
	 * @param array
	 *            Input array to whose elements we have to calculate the hash
	 * @param start
	 *            Start position in array, inclusive
	 * @param end
	 *            end position in array, exclusive
	 * @param previousHash
	 *            previous hash used to calculate current hash in constant time
	 * @return
	 */
	private long rollingHash(String text, int start, int end, long previousHash) {
		long hash = previousHash;
		if (start == 0) {
			hash = firstHash(text, start, end);
		} else {
			hash = successiveHash(text, start, end, previousHash);
		}
		return hash;
	}

	/*
	 * https://en.wikipedia.org/wiki/Horner%27s_method
	 */
	private long firstHash(String text, int start, int end) {
		long hash = 0;
		for (int i = start; i < end; i++) {
			hash = ((hash * BASE) % MOD + text.charAt(i)) % MOD;
		}
		return hash;
	}

	/*
	 * https://stackoverflow.com/questions/20412405/rolling-hash-in-rabin-karp
	 */
	private long successiveHash(String text, int start, int end, long previousHash) {
		long base = 1;
		for (int i = start; i < end; i++) {
			base = (base * BASE) % MOD;
		}
		return (previousHash * BASE - ((text.charAt(start - 1) * base) % MOD) + text.charAt(end - 1)) % MOD;
	}

	/*
	 * Alternative implementation for successive hash
	 */
	// private long successiveHash(String text, int start, int end, long
	// previousHash) {
	// long base = 1;
	// for (int i = start; i < end - 1; i++) {
	// base = (base * BASE) % MOD;
	// }
	// long newHash = (BASE * (previousHash - ((text.charAt(start - 1) * base))) +
	// text.charAt(end - 1)) % MOD;
	// return newHash < 0 ? newHash + MOD : newHash;
	// }

}
