package com.learning.ads.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two sequence of characters, find the longest sequence of characters which appears on both the sequences
 * 
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). 
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * 
 * @author Arun Rahul
 */
public class LongestCommonSubsequence {

	/**
	 * Time Complexity: O(2^n) where n is the lenght of longest sequence
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public char[] lcs(String first, String second) {
		List<Character> result = recLcs(first.toCharArray(), second.toCharArray(), first.length() - 1, second.length() - 1);
		return listToArray(result);
	}

	private List<Character> recLcs(char[] first, char[] second, int i, int j) {
		if (i < 0 || j < 0) {
			return new ArrayList<>();
		}
		if (first[i] == second[j]) {
			List<Character> pre = recLcs(first, second, i - 1, j - 1);
			pre.add(first[i]);
			return pre;
		}
		List<Character> preFirst = recLcs(first, second, i - 1, j);
		List<Character> preSecond = recLcs(first, second, i, j - 1);
		if (preFirst.size() < preSecond.size()) {
			return preSecond;
		}
		return preFirst;
	}

	/**
	 * Time Complexity: O(n^2) where n is the length of longest sequence
	 * Space Complexity: O(n^2) where n is the length of longest sequence
	 * @param first
	 * @param second
	 * @return
	 */
	public char[] lcsBottomUp(String first, String second) {
		int[][] count = new int[first.length() + 1][second.length() + 1];
		for (int i = 1; i <= first.length(); i++) {
			for (int j = 1; j <= second.length(); j++) {
				if (first.charAt(i - 1) == second.charAt(j - 1)) 
					count[i][j] = count[i - 1][j - 1] + 1;
				else
					count[i][j] = Math.max(count[i][j], Math.max(count[i - 1][j], count[i][j - 1]));
			}
		}
		return prepareSequence(count, first, second);
	}

	/**
	 * Time Complexity: O(n^2) where n is the length of longest sequence
	 * Space Complexity: O(n^2) where n is the length of longest sequence
	 * @param first
	 * @param second
	 * @return
	 */
	public char[] lcsTopDown(String first, String second) {
		int[][] count = new int[first.length() + 1][second.length() + 1];
		for (int i = 0; i < count.length; i++) {
			Arrays.fill(count[i], -1);
		}
		lcsTopDownRec(first, second, first.length(), second.length(), count);
		return prepareSequence(count, first, second);
	}

	private int lcsTopDownRec(String first, String second, int f, int s, int[][] count) {
		if (f == 0 || s == 0) {
			return 0;
		}
		if (count[f][s] != -1) {
			return count[f][s];
		}
		if (first.charAt(f - 1) == second.charAt(s - 1)) {
			count[f][s] = 1 + lcsTopDownRec(first, second, f - 1, s - 1, count);
		} else {
			count[f][s] = Math.max(lcsTopDownRec(first, second, f - 1, s, count),
					lcsTopDownRec(first, second, f, s - 1, count));
		}
		return count[f][s];
	}

	private char[] prepareSequence(int[][] count, String first, String second) {
		List<Character> result = prepareSequenceRec(count, count.length - 1, count[0].length - 1, first, second);
		return listToArray(result);
	}

	private List<Character> prepareSequenceRec(int[][] count, int f, int s, String first, String second) {
		if (f == 0 || s == 0) {
			return new ArrayList<>();
		}
		if (first.charAt(f - 1) == second.charAt(s - 1)) {
			List<Character> result = prepareSequenceRec(count, f - 1, s - 1, first, second);
			result.add(first.charAt(f - 1));
			return result;
		}
		if (count[f - 1][s] == count[f][s]) {
			return prepareSequenceRec(count, f - 1, s, first, second);
		}
		return prepareSequenceRec(count, f, s - 1, first, second);
	}

	private char[] listToArray(List<Character> array) {
		char[] answer = new char[array.size()];
		int i = 0;
		for (char c : array) {
			answer[i++] = c;
		}
		return answer;
	}

}
