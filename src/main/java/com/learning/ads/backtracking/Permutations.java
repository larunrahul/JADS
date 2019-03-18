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

	public static void main(String[] args) {
		Permutations p = new Permutations();
		p.getAllPermutationsNaive("abcd");
	}
}
