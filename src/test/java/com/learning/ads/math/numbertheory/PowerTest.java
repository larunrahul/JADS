package com.learning.ads.math.numbertheory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PowerTest {
	
	private Power power = new Power();

	@Test
	public void power() {
		assertEquals(32, power.power(2, 5));
	}

}
