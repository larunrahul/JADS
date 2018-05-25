package com.learning.ads.math.numbertheory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EuclidGCDTest {

	private EuclidGCD euclidGCD = new EuclidGCD();

	@Test
	public void gcd() {
		assertEquals(21, euclidGCD.gcd(1071, 462));
		assertEquals(21, euclidGCD.gcd(462, 1071));
		assertEquals(45, euclidGCD.gcd(45, 0));
		assertEquals(45, euclidGCD.gcd(0, 45));
	}

}
