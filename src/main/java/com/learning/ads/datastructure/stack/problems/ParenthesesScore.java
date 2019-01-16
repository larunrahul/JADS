package com.learning.ads.datastructure.stack.problems;

import com.learning.ads.datastructure.stack.Stack;

/**
 * https://leetcode.com/problems/score-of-parentheses
 * 
 * All solutions except my solution are given at
 * https://leetcode.com/problems/score-of-parentheses/solution/
 * 
 * @author Arun Rahul
 *
 */

public class ParenthesesScore {

	/**
	 * My solution, which is little complex but still O(N) where N is length of the
	 * string
	 * 
	 * Space complexity is also O(N) where N is the size of string.
	 * 
	 * When char is '(', push it. When char is ')' calculate the score and push it.
	 * When previous character of ')' is '(', then current score is 1 and push it.
	 * When previous character of ')' is not '(', then score would be sum of all the
	 * sub scores that are already pushed. Push this new score to stack.
	 * 
	 * @param S String
	 * @return score
	 */
	public int scoreOfParenthesesStack(String S) {
		Stack<Object> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				stack.push(Character.valueOf(S.charAt(i)));
			} else {
				if (S.charAt(i - 1) == '(') {
					stack.pop();
					stack.push(1);
				} else {
					int sum = 0;
					while (!(stack.peek() instanceof Character)) {
						sum += (Integer) stack.pop();
					}
					stack.pop();
					stack.push(2 * sum);
				}

			}
		}
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += (Integer) stack.pop();
		}
		return sum;
	}

	/**
	 * This is best solution with Stack. Time complexity is O(N) where N is length
	 * of the string.
	 * 
	 * Space complexity is also O(N) where N is the size of string.
	 * 
	 * Every position in the string has a depth - some number of matching
	 * parentheses surrounding it. For example, the dot in (()(.())) has depth 2,
	 * because of these parentheses: (__(.__))
	 * 
	 * Our goal is to maintain the score at the current depth we are on. When we see
	 * an opening bracket, we increase our depth, and our score at the new depth is
	 * 0. When we see a closing bracket, we add twice the score of the previous
	 * deeper part - except when counting (), which has a score of 1.
	 * 
	 * @param S String
	 * @return score
	 */
	public int scoreOfParenthesesStackAnother(String S) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // The score of the current frame

		for (char c : S.toCharArray()) {
			if (c == '(')
				stack.push(0);
			else {
				int v = stack.pop();
				int w = stack.pop();
				stack.push(w + Math.max(2 * v, 1));
			}
		}

		return stack.pop();
	}

	/**
	 * Best of all solutions.
	 * 
	 * Time complexity: O(N) where N is length of the string Space complexity: O(1)
	 * 
	 * Intuition: The final sum will be a sum of powers of 2, as every core (a
	 * substring (), with score 1) will have it's score multiplied by 2 for each
	 * exterior set of parentheses that contains that core.
	 * 
	 * Algorithm: Keep track of the balance of the string, as defined in Approach
	 * #1. For every ) that immediately follows a (, the answer is 1 << balance, as
	 * balance is the number of exterior set of parentheses that contains this core.
	 * 
	 * 
	 * @param S String
	 * @return score
	 */
	public int scoreOfParenthesesBest(String S) {
		int ans = 0, bal = 0;
		for (int i = 0; i < S.length(); ++i) {
			if (S.charAt(i) == '(') {
				bal++;
			} else {
				bal--;
				if (S.charAt(i - 1) == '(')
					ans += 1 << bal; // bal * 2
			}
		}

		return ans;
	}

}
