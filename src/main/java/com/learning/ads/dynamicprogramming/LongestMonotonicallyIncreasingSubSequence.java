package com.learning.ads.dynamicprogramming;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/solution/
 * 
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * @author Arun Rahul
 * 
 */
public class LongestMonotonicallyIncreasingSubSequence {

	/**
	 * 
	 * Time Complexity: O(2^n) where n is size of array
	 * 
	 * Find all paths which have increasing sequence
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		return lengthofLIS(nums, Integer.MIN_VALUE, 0);
	}

	private int lengthofLIS(int[] nums, int prev, int curpos) {
		if (curpos == nums.length) {
			return 0;
		}
		int taken = 0;
		if (nums[curpos] > prev) {
			taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
		}
		int nottaken = lengthofLIS(nums, prev, curpos + 1);
		return Math.max(taken, nottaken);
	}

	/**
	 * 
	 * Time Complexity: O(n^2) where n is size of array 
	 * 
	 * Space Complexity: O(n^2) where n is size of array
	 * 
	 * Find all paths which have increasing sequence
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLISTopDown(int[] nums) {
		int[][] dp = new int[nums.length + 1][nums.length];
		return lengthofLISTopDown(dp, nums, -1, 0);
	}

	private int lengthofLISTopDown(int[][] dp, int[] nums, int prevpos, int curpos) {
		if (curpos == nums.length) {
			return 0;
		}
		if (dp[prevpos + 1][curpos] != 0)
			return dp[prevpos + 1][curpos];
		int taken = 0;
		if (prevpos == -1 || nums[curpos] > nums[prevpos]) {
			taken = 1 + lengthofLISTopDown(dp, nums, curpos, curpos + 1);
		}
		int nottaken = lengthofLISTopDown(dp, nums, prevpos, curpos + 1);
		return dp[prevpos + 1][curpos] = Math.max(taken, nottaken);
	}

	/**
	 * 
	 * Time Complexity: O(n^2) where n is size of array
	 * 
	 * Spce Complexity: O(n) where n is size of array
	 * 
	 * @param sequence
	 * @return
	 */
	public int lengthOfLISBottomUp(int[] nums) {
		if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
	}

	/**
	 * 
	 * Time Complexity: O(nlogn) where n is size of array
	 * 
	 * Spce Complexity: O(n) where n is size of array
	 * 
	 * @param sequence
	 * @return
	 */
	public int lengthOfLISEfficient(int[] sequence) {
		int[] tails = new int[sequence.length];
		int length = 0;
		for (int num : sequence) {
			int i = getFirstBigOrEqual(tails, length - 1, num);
			tails[i] = num;
			if (i == length)
				length++;
		}
		return length;
	}

	private int getFirstBigOrEqual(int[] tails, int l, int num) {
		int f = 0;
		if (l < 0) return 0;
		while (f < l) {
			int mid = (f + l) / 2;
			if (tails[mid] < num) f = mid + 1;
			else l = mid;
		}
		return tails[f] >= num ? f : f + 1;
	}

}
