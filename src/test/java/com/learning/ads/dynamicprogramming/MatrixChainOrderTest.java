package com.learning.ads.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.learning.ads.dynamicprogramming.MatrixChainOrder.Result;

public class MatrixChainOrderTest {

	MatrixChainOrder chainOrder = new MatrixChainOrder();

	@Test
	public void calculateMultiplications() {
		Result result = chainOrder.calculateMultiplications(new int[] { 30, 35, 15, 5, 10, 20, 25 });
		assertEquals(15125, result.finalScalarMuls);
		assertEquals("((A1(A2A3))((A4A5)A6))", result.parenthesizedChain);
	}
	
	@Test
	public void calculateMultiplicationsRec() {
		Result result = chainOrder.calculateMultiplicationsRec(new int[] { 30, 35, 15, 5, 10, 20, 25 });
		assertEquals(15125, result.finalScalarMuls);
		assertEquals("((A1(A2A3))((A4A5)A6))", result.parenthesizedChain);
	}

}
