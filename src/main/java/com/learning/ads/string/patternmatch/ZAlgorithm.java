package com.learning.ads.string.patternmatch;

import java.util.Arrays;

/**
 * http://codeforces.com/blog/entry/3107
 * 
 * https://ivanyu.me/blog/2013/10/15/z-algorithm/
 * 
 * https://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
 * 
 * Complexity: O(n + m) where n is the length of pattern and m is length of text
 * 
 * 
 * @author Arun Rahul
 *
 */
public class ZAlgorithm {

	public int search(String text, String pattern) {
		String finalText = new StringBuilder(pattern).append("$").append(text).toString();
		int[] zArray = new int[finalText.length()];
		// Always maintain left and right window which has maximum right
		int left = 0, right = 0;
		for (int i = 1; i < finalText.length(); i++) {

			/*
			 * If i is outside of current window, we don't know anything about i and hence
			 * we have to match character by character from i with start (prefix) of string.
			 * In the below code, instead of using finalText.charAt(0), we derived the index
			 * using left and right variables which we are already maintaining
			 */
			if (i > right) {
				left = right = i;
				while (right < finalText.length() && finalText.charAt(right) == finalText.charAt(right - left)) {
					right++;
				}
				zArray[i] = right - left;
				right--;
			} else { // i belongs to current window
				/*
				 * k is number of characters in the current window that are matching with start
				 * (prefix) of string i.e., k corresponds to the index from the start of the
				 * string to that of the position of i in the current window
				 */
				int k = i - left;
				/*
				 * if z value of k is less than the remaining elements in current window
				 * (elements from i to last), that means z value of i should be z value of k.
				 * This is true because, if we start from i we cant match more thatn zArray[k]
				 * values from the start of string
				 */
				if (zArray[k] < right - i + 1) {
					zArray[i] = zArray[k];
				} else {
					/*
					 * if z value of k is at least the size of remaining elements in current window
					 * (elements from i to right), then we have to start matching the characters from
					 * right+1 with that of characters at corresponding indexes from start of the
					 * string
					 */
					left = i;
					while (right < finalText.length() && finalText.charAt(right) == finalText.charAt(right - left)) {
						right++;
					}
					zArray[i] = right - left;
					right--;
				}
			}
			if (zArray[i] == pattern.length()) {
				return i - pattern.length() - 1;
			}
		}
		System.out.println(Arrays.toString(zArray));
		return -1;
	}

}
