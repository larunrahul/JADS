package com.learning.ads.divideandconquer;

public class MaximumSubarray {
	private int[] array;

	public MaximumSubarray(int[] array) {
		this.array = array;
	}

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

	public int[] findMaximumSubarray(int low, int high) {
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

	public static void main(String[] args) {
		
	}

}
