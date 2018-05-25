package com.learning.ads.math.numbertheory;

public class EuclidGCD {

	public int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

}
