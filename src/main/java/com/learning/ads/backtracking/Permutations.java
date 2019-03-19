package com.learning.ads.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.topcoder.com/blog/generating-permutations/
 * 
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * 
 * @author Arun Rahul
 *
 */
public class Permutations {

	List<String> permutations = new ArrayList<>();

	/**
	 * Print all permutations of all the characters in given string.
	 * 
	 * Basic idea is how we calculate permutations by hand: for a given string of
	 * length n there are n! permutations This can be calculated as
	 * 
	 * n! = n * (n-1)! = n * (n -1) * (n-2)! and so on.
	 * 
	 * 1) Swap first char with the char to be present at first in the output
	 * 
	 * 2) Recurse the remaining part (2..n)
	 * 
	 * 3) Undo the swap to conitnue for next permutation
	 * 
	 * Time complexity: O(n!)
	 * 
	 * @param input
	 */
	public List<String> getAllPermutationsNaive(String input) {
		permutations = new ArrayList<>();
		permuteNaive(input.toCharArray(), 0, input.length() - 1);
		return permutations;
	}

	/**
	 * This is bottom-up approach
	 * 
	 * Insert the nth element at all possible locations of the (n-1)! remaining
	 * permutations.
	 * 
	 * For input string "abc", take 'a'. Now add 'b' at every position in 'a' i.e.,
	 * "ba", "ab". Now add 'c' at every position in "ba" and "ab". This gives rise
	 * to "cba", "bca", "bac" and "cab", "acb", "abc". Do this process in bottom up
	 * fashion recursively.
	 * 
	 * @param input
	 * @return
	 */
	public List<String> getAllPermutationBottomup(String input) {
		return getAllPermutationBottomup(input, input.length() - 1);
	}

	private List<String> getAllPermutationBottomup(String input, int end) {
		String endChar = input.substring(end, end + 1);
		List<String> thisPerms = new ArrayList<>();
		if (end == 0) {
			thisPerms.add(endChar);
			return thisPerms;
		}
		List<String> perms = getAllPermutationBottomup(input, end - 1);
		for (String str : perms) {
			char[] chars = str.toCharArray();
			char[] newChars = new char[chars.length + 1];
			for(int pos = 0 ; pos < newChars.length; pos++) {
				for (int i = 0; i < newChars.length; i++) {
					if(i == pos) {
						newChars[i] = input.charAt(end);
					}else if (i > pos) {
						newChars[i] = chars[i-1];
					}else {
						newChars[i] = chars[i];
					}
				}
				thisPerms.add(String.valueOf(newChars));
			}
		}
		return thisPerms;
	}

	/**
	 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
	 * 
	 * Steinhaus–Johnson–Trotter algorithm
	 * 
	 * This method generates the next permutation for given permutation in
	 * lexicographic order
	 * 
	 * @param permutation
	 * @return
	 */
	public String nextPermutationSJT(String permutation) {
		return null;
	}

	private void permuteNaive(char[] input, int start, int end) {
		if (start == end) {
			permutations.add(String.valueOf(input));
			return;
		}
		for (int i = start; i <= end; i++) {
			swap(input, start, i);
			permuteNaive(input, start + 1, end);
			swap(input, i, start);
		}
	}

	private void swap(char[] input, int from, int to) {
		char temp = input[from];
		input[from] = input[to];
		input[to] = temp;
	}

}
