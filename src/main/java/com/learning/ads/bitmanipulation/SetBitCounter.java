package com.learning.ads.bitmanipulation;

/**
 * Resources used:
 * http://www.geeksforgeeks.org/?p=1176
 * @author Arun Rahul
 *
 */
public class SetBitCounter {

	/**
	 * Shift the bits to right, one per iteration. In each iteration, if we do bitwise & with 1
	 * all the bits will be zero except the rightmost bit, which yields to 1 if it is 1
	 * in the shifted integer or 0 if it is 0 in the shifted integer.
	 * 
	 * Complexity : O(n) where n = size of input data type (typically 32 for int, 64 for long)
	 * 
	 * @param n
	 * @return number of set bits
	 */
	public int count(int n) {
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}
	
	/**
	 * Subtraction of 1 from a number toggles all the bits (from right to left) till the rightmost set bit(including the righmost set bit). 
	 * So if we subtract a number by 1 and do bitwise & with itself (n & (n-1)), we unset the rightmost set bit. 
	 * If we do n & (n-1) in a loop and count the no of times loop executes we get the set bit count.
	 * Beauty of the this solution is number of times it loops is equal to the number of set bits in a given integer.
	 * 
	 * Complexity : O(v) where v = number of set bits
	 * 
	 * @param n
	 * @return number of set bits
	 */
	public int BrianKernighanCounter(int n) {
		int count = 0;
		while (n != 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}

	/**
	 * For each set of four bits(16 permutations) we are storing the number of set bits.
	 * Then querying that store for each right most four bits.
	 * Complexity : O(n/4) where n = size of input data type (typically 32 for int, 64 for long)
	 * @param n
	 * @return
	 */
	public int lookupTableCounter(int n) {
		int[] lookupTable = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
		int count = 0;
		while (n != 0) {
			count += lookupTable[n & 0xF];
			n >>= 4;
		}
		return count;
	}

	public static void main(String[] args) {
		SetBitCounter sbCounter = new SetBitCounter();
		System.out.println(sbCounter.lookupTableCounter(50));
	}

}
