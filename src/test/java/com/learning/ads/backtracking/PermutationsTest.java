package com.learning.ads.backtracking;

import org.junit.Assert;
import org.junit.Test;

public class PermutationsTest {

	@Test
	public void getAllPermutationsNaive() {
		String[] result = { "abcd", "abdc", "acbd", "acdb", "adcb", "adbc", "bacd", "badc", "bcad", "bcda", "bdca",
				"bdac", "cbad", "cbda", "cabd", "cadb", "cdab", "cdba", "dbca", "dbac", "dcba", "dcab", "dacb",
				"dabc" };
		Assert.assertArrayEquals(result, new Permutations().getAllPermutationsNaive("abcd").toArray());
	}

	@Test
	public void getAllPermutationsBottomup() {
		String[] result = { "dcba", "cdba", "cbda", "cbad", "dbca", "bdca", "bcda", "bcad", "dbac", "bdac", "badc",
				"bacd", "dcab", "cdab", "cadb", "cabd", "dacb", "adcb", "acdb", "acbd", "dabc", "adbc", "abdc",
				"abcd" };
		Assert.assertArrayEquals(result, new Permutations().getAllPermutationBottomup("abcd").toArray());

	}

}
