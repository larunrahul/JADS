package com.learning.ads.math.numbertheory.prime;

import java.util.HashMap;
import java.util.Map;

public class Primality {

	/**
	 * https://www.topcoder.com/community/data-science/data-science-tutorials/mathematics-for-topcoders/
	 * 
	 * @param number
	 * @return
	 */
	public boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		if (number == 2) {
			return true;
		}
		if ((number & 1) == 0) {
			return false;
		}
		double root = Math.sqrt(number);
		for (int i = 3; i <= root; i = i + 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;

	}

	public Map<Integer, Integer> factors(int number) {
		Map<Integer, Integer> factors = new HashMap<>();

		return factors;
	}

}
