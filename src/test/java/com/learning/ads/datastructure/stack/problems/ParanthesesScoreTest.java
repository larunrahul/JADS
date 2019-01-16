package com.learning.ads.datastructure.stack.problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParanthesesScoreTest {

	ParenthesesScore score = new ParenthesesScore();

	@Test
	public void scoreOfParenthesesStack() {
		assertEquals(1, score.scoreOfParenthesesStack("()"));
		assertEquals(2, score.scoreOfParenthesesStack("(())"));
		assertEquals(2, score.scoreOfParenthesesStack("()()"));
		assertEquals(6, score.scoreOfParenthesesStack("(()(()))"));
	}

	@Test
	public void scoreOfParenthesesStackAnother() {
		assertEquals(1, score.scoreOfParenthesesStackAnother("()"));
		assertEquals(2, score.scoreOfParenthesesStackAnother("(())"));
		assertEquals(2, score.scoreOfParenthesesStackAnother("()()"));
		assertEquals(6, score.scoreOfParenthesesStackAnother("(()(()))"));
	}

	@Test
	public void scoreOfParenthesesBest() {
		assertEquals(1, score.scoreOfParenthesesBest("()"));
		assertEquals(2, score.scoreOfParenthesesBest("(())"));
		assertEquals(2, score.scoreOfParenthesesBest("()()"));
		assertEquals(6, score.scoreOfParenthesesBest("(()(()))"));
	}

}
