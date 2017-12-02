package com.learning.ads.divideandconquer;

public class MaximumSubarray {
	private int[] array;

	public MaximumSubarray(int[] array) {
		this.array = array;
	}

	/**
	 * This runs in {@code O(nlogn)}.
	 * 
	 * @return An array containing indices that form the max sum and max sum itself.
	 */
	public int[] findMaximumSubarray() {
		return findMaximumSubarray(0, array.length - 1);
	}

	/**
	 * This runs in {@code O(n}<sup>{@code 2}</sup>{@code )}.
	 * 
	 * @return An array containing indices that form the max sum and max sum itself.
	 */
	public int[] findMaximumSubarrayInefficient() {
		int min = 0, max = 0, sum = 0, maxSum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = array[i];
			for (int j = i + 1; j < array.length; j++) {
				sum = sum + array[j];
				if (sum > maxSum) {
					min = i;
					max = j;
					maxSum = sum;
				}
			}
		}
		return new int[] { min, max, maxSum };
	}

	private int[] findMaximumSubarray(int low, int high) {
		if (high == low) {
			return new int[] { low, high, array[low] };
		}
		int mid = (low + high) / 2;
		int[] left = findMaximumSubarray(low, mid);
		int[] right = findMaximumSubarray(mid + 1, high);
		int[] cross = maxCrossingSubArray(low, mid, high);
		if (left[2] >= right[2] && left[2] >= cross[2]) {
			return left;
		} else if (right[2] >= left[2] && right[2] >= cross[2]) {
			return right;
		}
		return cross;
	}

	/**
	 * This runs in {@code O(n)}
	 * 
	 * @param low
	 * @param mid
	 * @param high
	 * @return An array containing indices that form the max sum and max sum itself
	 *         within given range.
	 */
	private int[] maxCrossingSubArray(int low, int mid, int high) {
		int leftMaxSum = array[mid], leftMaxElement = mid, sum = leftMaxSum;
		for (int i = mid - 1; i >= 0; i--) {
			sum += array[i];
			if (sum > leftMaxSum) {
				leftMaxSum = sum;
				leftMaxElement = i;
			}
		}
		int rightMaxSum = array[mid + 1], rightMaxElement = mid + 1;
		sum = rightMaxSum;
		for (int i = mid + 2; i <= high; i++) {
			sum += array[i];
			if (sum > rightMaxSum) {
				rightMaxSum = sum;
				rightMaxElement = i;
			}
		}
		return new int[] { leftMaxElement, rightMaxElement, leftMaxSum + rightMaxSum };
	}

}
