package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubArraySumTest {
    private SubArraySum sas = new SubArraySum();

	@Test
	public void subsetSum() {
        assertEquals(true, sas.subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 9));
        assertEquals(false, sas.subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 30));
        assertEquals(true, sas.subsetSumTopDown(new int[]{3, 34, 4, 12, 5, 2}, 9));
        assertEquals(false, sas.subsetSumTopDown(new int[]{3, 34, 4, 12, 5, 2}, 30));
    }
    
    @Test
	public void subsetSumTopDown() {
        assertEquals(true, sas.subsetSumTopDown(new int[]{3, 34, 4, 12, 5, 2}, 9));
        assertEquals(false, sas.subsetSumTopDown(new int[]{3, 34, 4, 12, 5, 2}, 30));
        assertEquals(true, sas.subsetSumTopDown(new int[]{3, 34, 4, 12, 5, 2}, 9));
        assertEquals(false, sas.subsetSumTopDown(new int[]{3, 34, 4, 12, 5, 2}, 30));
	}
}