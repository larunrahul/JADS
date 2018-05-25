package com.learning.ads.math.numbertheory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LCMTest {

	private LCM lcm = new LCM();

	@Test
	public void lcm() {
		assertEquals(36, lcm.findLCM(12, 18));
	}

}
