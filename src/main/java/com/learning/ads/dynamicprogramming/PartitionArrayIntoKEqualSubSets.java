package com.learning.ads.dynamicprogramming;

public class PartitionArrayIntoKEqualSubSets {

	public int ways(int[] array, int k) {
		int[] sums = new int[array.length];
		sums[array.length - 1] = array[array.length - 1];
		for (int i = array.length - 2; i >= 0; i--) {
			sums[i] = sums[i + 1] + array[i];
		}
		return waysRec(array, k, 0, sums[0], sums);
	}

	public int waysRec(int[] array, int k, int i, int sum, int[] sums) {
		if (i >= array.length || k <= 0)
			return 0;
		if(k == 1 && sums[i] == sum) return 1;
		int ways = 0, lsum = 0;
		for (int j = i; j <= array.length - k; j++) {
			lsum += array[j];
			ways += waysRec(array, k - 1, j + 1, sum - lsum, sums);
		}
		return ways;
	}

	public static void main(String[] args) {
		PartitionArrayIntoKEqualSubSets p = new PartitionArrayIntoKEqualSubSets();
		System.out.println(p.ways(new int[] { 1, -1, 1, -1 }, 2));
		//System.out.println(-2%5);
	}
}
