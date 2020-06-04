package com.learning.ads.dynamicprogramming;
/**
 * Given a string find a substring which is the longest palindrome
 */
public class LongestPalindromicSubString {
	/**
	 * Time Complexity: O(len(s)^3)
	 * @param s
	 * @return
	 */
	public String lps(String s) {
		if (s.equals(""))
			return "";
		int start = 0, end = 0;
		for (int length = 1; length <= s.length(); length++) {
			int endIndex = s.length() - length;
			for (int i = 0; i <= endIndex; i++) {
				int j = i + length - 1;
				int f = i, l = j;
				boolean isPalindrome = true;
				while (f < l) {
					if (s.charAt(f++) != s.charAt(l--)) {
						isPalindrome = false;
						break;
					}
				}
				if (isPalindrome && j - i > end - start) {
					start = i;
					end = j;
				}
			}
		}
		return s.substring(start, end + 1);
	}

	/**
	 * Time Complexity: O(len(s)^2)
	 * Space Complexity: O(len(s)^2)
	 * @param s
	 * @return
	 */
	public String lpsBottomUp(String s) {
		if (s.equals(""))
			return "";
		int[][] dp = new int[s.length()][s.length()];
		int start = 0, end = 0;
		for (int length = 1; length <= s.length(); length++) {
			int endIndex = s.length() - length;
			for (int i = 0; i <= endIndex; i++) {
				int j = i + length - 1;
				int f = i + 1, l = j - 1;
				int pre = f < l ? dp[f][l] : 0;
				if (pre != -1 && s.charAt(i) == s.charAt(j)) {
					if(j - i > end - start) {
						start = i;
						end = j;
					}
					dp[i][j] = i;
				} else {
					dp[i][j] = -1;
				}
			}
		}
		return s.substring(start, end + 1);
	}
}
