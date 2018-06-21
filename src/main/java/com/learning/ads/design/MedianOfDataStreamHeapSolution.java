package com.learning.ads.design;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.hackerrank.com/challenges/find-the-running-median/problem
 * 
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 * 
 * Complexity: O(n) where n is the size of stream
 * 
 * @author Arun Rahul
 *
 */
public class MedianOfDataStreamHeapSolution {

	private PriorityQueue<Integer> leftPQ, rightPQ;

	public MedianOfDataStreamHeapSolution() {
		rightPQ = new PriorityQueue<>();// min heap
		leftPQ = new PriorityQueue<>(Comparator.reverseOrder());// max heap
	}

	public double[] runningMedian(int[] a) {
		leftPQ.clear();
		rightPQ.clear();
		double[] result = new double[a.length];
		for (int i = 0, j = 0; i < a.length; i++) {
			addNum(a[i]);
			result[j++] = findMedian();
		}
		return result;
	}

	private void addNum(int num) {
		if (leftPQ.size() > rightPQ.size()) {
			if (leftPQ.size() != 0 && num <= leftPQ.peek()) {
				rightPQ.add(leftPQ.poll());
				leftPQ.add(num);
			} else {
				rightPQ.add(num);
			}
		} else {
			if (rightPQ.size() != 0 && num >= rightPQ.peek()) {
				leftPQ.add(rightPQ.poll());
				rightPQ.add(num);
			} else {
				leftPQ.add(num);
			}
		}
	}

	private double findMedian() {
		if (leftPQ.size() > rightPQ.size()) {
			return leftPQ.peek();
		}
		if (rightPQ.size() > leftPQ.size()) {
			return rightPQ.peek();
		}
		return (leftPQ.peek() + rightPQ.peek()) / 2D;
	}

}
