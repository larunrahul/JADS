package com.learning.ads.math.numbertheory.prime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrimalityTest {

	Primality primality = new Primality();

	@Test
	public void isPrime() {
		assertFalse(primality.isPrime(1));
		assertTrue(primality.isPrime(2));
		assertTrue(primality.isPrime(3));
		assertFalse(primality.isPrime(4));
		assertTrue(primality.isPrime(5));
		assertTrue(primality.isPrime(7));
		assertTrue(primality.isPrime(17));
		assertFalse(primality.isPrime(27));
		assertTrue(primality.isPrime(1000000007));
		assertFalse(primality.isPrime(87));
	}

}
