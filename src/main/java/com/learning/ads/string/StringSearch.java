package com.learning.ads.string;

/**
 * Different algorithms for String search
 * 
 * @author Arun Rahul
 *
 */
public class StringSearch {

	private static final int MOD = 1000000007;
	private static final int BASE = 31;

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
	public int bruteForce(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		char[] texts = text.toCharArray();
		char[] patterns = pattern.toCharArray();
		for (int i = 0; i <= n - m; i++) {
			int j = 0;
			while (j < m && texts[i + j] == patterns[j]) {
				j++;
			}
			if (j == m) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * https://en.wikipedia.org/wiki/Rabin%E2%80%93Karp_algorithm
	 * 
	 * Complexity: Worst case - O(n * m) where n is length of text and m is length
	 * of pattern Best case - O(n + m) where n is length of text and m is length of
	 * pattern
	 * 
	 * @param text
	 *            Whole text in which we want to search for a pattern
	 * @param pattern
	 *            String which we want to search in text
	 * 
	 * @return Index of the pattern in the text if matched, otherwise -1
	 */
	public int RabinKarp(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		char[] texts = text.toCharArray();
		char[] patterns = pattern.toCharArray();
		long patternHash = rollingHash(patterns, 0, patterns.length, 0);
		long textHash = 0;
		for (int i = 0; i <= n - m; i++) {
			if ((textHash = rollingHash(texts, i, i + m - 1, textHash)) == patternHash) {
				int j = 0;
				while (j < m && texts[i + j] == patterns[j]) {
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
	private long rollingHash(char[] array, int start, int end, long previousHash) {
		long hash = previousHash;
		// first time
		if (start == 0) {
			firstHash(array, start, end);
		} else {
			successiveHash(array, start, end, previousHash);
		}
		return hash;
	}

	/*
	 * https://en.wikipedia.org/wiki/Horner%27s_method
	 */
	private long firstHash(char[] array, int start, int end) {
		long hash = 0;
		for (int i = start; i < end; i++) {
			hash = (hash * BASE + array[i]) % MOD;
		}
		return hash;
	}

	/**
	 * https://stackoverflow.com/questions/20412405/rolling-hash-in-rabin-karp
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @param previousHash
	 * @return
	 */
	private long successiveHash(char[] array, int start, int end, long previousHash) {
		long base = 1;
		for (int i = start; i < end; i++) {
			base = (base * BASE);
		}
		return (previousHash * BASE - ((array[start - 1] * base) % MOD) + array[end - 1]) % MOD;
	}

}
