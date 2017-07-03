package com.learning.ads.math.numbertheory;

import com.learning.ads.bitmanipulation.SetBitCounter;

/**
 * Resources used: 
 * http://www.geeksforgeeks.org/program-to-find-whether-a-no-is-power-of-two
 * @author Arun Rahul
 *
 */
public class Power {

	public long power(int base, int exponent) {
		if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return 1 / power(base, -exponent); // a^-b = 1 / a^b
        }
        if ((exponent & 1) == 1) { //if exponent is odd
            return base * power(base, exponent - 1);
        } else {
            long pow = power(base, exponent >> 1); //divide exponent by 2
            return pow * pow;
        }
	}
	/**
	 * Keep dividing the number by 2 iteratively and if in any of the iteration if remainder of division
	 * is not zero, then it is not a power of 2
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo(int n){
		if (n == 0)
		    return false;
		  while (n != 1)
		  {
		    if (n%2 != 0)
		      return false;
		    n = n/2;
		  }
		  return true;
	}
	
	/**
	 * Any number which is a power of two has only one set bit in its binary representation
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwoCountSetBitsMethod(int n){
		return new SetBitCounter().BrianKernighanCounter(n) == 1;
	}
	
	/**
	 * Subtraction of 1 from a number toggles all the bits (from right to left) till the rightmost set bit(including the righmost set bit). 
	 * So if we subtract a number by 1 and do bitwise & with itself (n & (n-1)), we unset the rightmost set bit. 
	 * Also, when a number is a power of two there is only one set bit in its binary representation. 
	 * Hence, when we do (n & (n-1)), if it yields to 0, then it is a power of two.
	 * @return
	 */
	public boolean isPowerOfTwoBrianKernighanIdea(int n){
		return n != 0 && (n & (n-1)) == 0;
	}

}
