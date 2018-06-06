package com.learning.ads.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://www.geeksforgeeks.org/?p=9755
 * 
 * Constraints: Must be O(n) and O(1) extra space
 * 
 * Allowed to modify input array
 * 
 * @author Arun Rahul
 *
 * @param <T>
 */
public class DuplicatesInArray {
	public List<Integer> duplicates(int[] array) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[Math.abs(array[i])] >= 0) {
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];
			} else {
				list.add(Math.abs(array[i]));
			}
		}
		return list;
	}

}
