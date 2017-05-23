package com.learning.ads.math.numbertheory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PowerTest {
	
	private Power power = new Power();

	@Test
	public void powerToZero() {
		assertEquals(1, power.power(2, 0));
	}
	
	@Test
	public void powerOfPositiveIntToPositiveInt() {
		assertEquals(32, power.power(2, 5));
	}
	
	@Test
	public void powerOfPositiveIntToNegativeInt() {
		assertEquals(0.03125, power.power(2, -5), 100);
	}
	
	@Test
	public void powerOfNegativeIntToPositiveInt() {
		assertEquals(-32, power.power(-2, 5));
	}
	
	@Test
	public void powerOfNegativeIntToPositiveIntEven() {
		assertEquals(16, power.power(-2, 4));
	}
	
	@Test
	public void powerOfNegativeIntToNegativeInt() {
		assertEquals(-0.03125, power.power(-2, -5), 100);
	}
	
	@Test
	public void powerOfNegativeIntToNegativeIntEven() {
		assertEquals(0.0625, power.power(-2, -4), 100);
	}
}
