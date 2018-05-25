package com.learning.ads.math.numbertheory;

public class LCM {

	/**
	 * LCM(a,b) = |a.b|/GCD(a,b) == (|a|/GCD(a,b))*|b|
	 */
	public int findLCM(int first, int second) {
		return (Math.abs(first) / new EuclidGCD().gcd(first, second)) * Math.abs(second);
	}

}
