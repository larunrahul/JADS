package com.learning.ads.bitmanipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SetBitCounterTest {
	
	private SetBitCounter sbCounter = new SetBitCounter();

	@Test
	public void count() {
		assertEquals(10,sbCounter.count(76533));
		assertEquals(7,sbCounter.count(12890));
		assertEquals(6,sbCounter.count(3466));
	}
	
	@Test
	public void BrianKernighanCounter() {
		assertEquals(10,sbCounter.BrianKernighanCounter(76533));
		assertEquals(7,sbCounter.BrianKernighanCounter(12890));
		assertEquals(6,sbCounter.BrianKernighanCounter(3466));
	}
	
	@Test
	public void lookupTableCounter() {
		assertEquals(10,sbCounter.lookupTableCounter(76533));
		assertEquals(7,sbCounter.lookupTableCounter(12890));
		assertEquals(6,sbCounter.lookupTableCounter(3466));
	}

}
