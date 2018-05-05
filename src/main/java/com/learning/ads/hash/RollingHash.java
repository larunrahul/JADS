package com.learning.ads.hash;

public class RollingHash {

	private int base;
	private int mod;

	public RollingHash(int base, int mod) {
		this.base = base;
		this.mod = mod;
	}

	/**
	 * Calculates the hash for the given text from given start point (inclusive) to
	 * given end point (exclusive).
	 * 
	 * If start is zero, it ignores the previousHash value.
	 * 
	 * Following algorithm uses Horner's method to calculate the hash for the string
	 * (array of characters). It treats every string of length n a polynomial of
	 * degree n-1.
	 * 
	 * Also, the following algorithm applies modulo to result in every step to
	 * prevent overflows
	 * 
	 * http://makble.com/hash-function-algorithm-modular-arithmetic-and-horners-method
	 * 
	 * https://en.wikipedia.org/wiki/Horner%27s_method
	 * 
	 * https://stackoverflow.com/questions/20412405/rolling-hash-in-rabin-karp
	 * 
	 * @param text
	 *            text for which we want to calculate the hash
	 * @param start
	 *            Start position in array, inclusive
	 * @param end
	 *            end position in array, exclusive
	 * @param previousHash
	 *            previously computed hash value which will be used to compute
	 *            current hash value
	 * @return calculated hash value
	 */
	public long hash(String text, int start, int end, long previousHash) {
		long hash = previousHash;
		if (start == 0) {
			hash = firstHash(text, end);
		} else {
			hash = successiveHash(text, start, end, previousHash);
		}
		return hash;
	}

	/**
	 * 
	 * Calculate the hash for the given array elements from index 0 to end
	 * (exclusive)
	 * 
	 * Following algorithm uses Horner's method to calculate the hash for the string
	 * (array of characters). It treats every string of length n a polynomial of
	 * degree n-1.
	 * 
	 * Also, the following algorithm applies modulo to result in every step to
	 * prevent overflows
	 * 
	 * http://makble.com/hash-function-algorithm-modular-arithmetic-and-horners-method
	 * 
	 * https://en.wikipedia.org/wiki/Horner%27s_method
	 * 
	 * https://stackoverflow.com/questions/20412405/rolling-hash-in-rabin-karp
	 * 
	 * @param text
	 *            text for which we want to calculate the hash
	 * @param end
	 *            end position in array, exclusive
	 * @return calculated hash value
	 */
	public long firstHash(String text, int end) {
		long hash = 0;
		for (int i = 0; i < end; i++) {
			hash = ((hash * base) % mod + text.charAt(i)) % mod;
		}
		return hash;
	}

	/**
	 * 
	 * Calculate the hash for the given array elements from index start(inclusive)
	 * to end (exclusive)
	 * 
	 * Following algorithm uses Horner's method to calculate the hash for the string
	 * (array of characters). It treats every string of length n a polynomial of
	 * degree n-1.
	 * 
	 * Also, the following algorithm applies modulo to result in every step to
	 * prevent overflows
	 * 
	 * http://makble.com/hash-function-algorithm-modular-arithmetic-and-horners-method
	 * 
	 * https://en.wikipedia.org/wiki/Horner%27s_method
	 * 
	 * https://stackoverflow.com/questions/20412405/rolling-hash-in-rabin-karp
	 * 
	 * In this algorithm, we first multiply the previous hash with base and then
	 * remove the term with highest degree(which we can obtain by multiplying the
	 * first term in previous hash with base raised to the power of n where n is
	 * length of text) in polynomial.
	 * 
	 * For example, if our string is "abcde" and we want to calculate hash for 4
	 * chars b,c,d,e as follows.
	 * 
	 * previousHash (for chars a,b,c,d) = a*x^3 + b*x^2 + c*x + d -- This is passed
	 * to this function
	 * 
	 * newHash (for chars b,c,d,e) = x*( a*x^3 + b*x^2 + c*x + d ) - a*x^4 + e =
	 * b*x^3 + c*x^2 + d*x + e
	 * 
	 * @param text
	 *            text for which we want to calculate the hash
	 * @param start
	 *            Start position in array, inclusive
	 * @param end
	 *            end position in array, exclusive
	 * @param previousHash
	 *            previously computed hash value which will be used to compute
	 *            current hash value
	 * @return calculated hash value
	 */
	public long successiveHash(String text, int start, int end, long previousHash) {
		long preTerm = 1;
		for (int i = start; i < end; i++) {
			preTerm = (preTerm * base) % mod;
		}
		return (previousHash * base - ((text.charAt(start - 1) * preTerm) % mod) + text.charAt(end - 1)) % mod;
	}

	/**
	 * 
	 * Calculate the hash for the given array elements from index start(inclusive)
	 * to end (exclusive)
	 * 
	 * Following algorithm uses Horner's method to calculate the hash for the string
	 * (array of characters). It treats every string of length n a polynomial of
	 * degree n-1.
	 * 
	 * Also, the following algorithm applies modulo to result in every step to
	 * prevent overflows
	 * 
	 * In this algorithm, we first remove the term with highest degree(which we can
	 * obtain by multiplying the first term in previous hash with base raised to the
	 * power of n-1 where n is length of text) and then multiply with base. There is
	 * a good chance that we can get negative hash while subtracting and hence we
	 * add mod value to nullify it as per the rule (A-B) % M = ( A % M - B % M + M )
	 * % M
	 * 
	 * For example, if our string is "abcde" and we want to calculate hash for 4
	 * chars b,c,d,e as follows.
	 * 
	 * previousHash (for chars a,b,c,d) = a*x^3 + b*x^2 + c*x + d -- This is passed
	 * to this function
	 * 
	 * newHash (for chars b,c,d,e) = x*( a*x^3 + b*x^2 + c*x + d - a*x^3) + e =
	 * b*x^3 + c*x^2 + d*x + e
	 * 
	 * http://makble.com/hash-function-algorithm-modular-arithmetic-and-horners-method
	 * 
	 * https://en.wikipedia.org/wiki/Horner%27s_method
	 * 
	 * https://stackoverflow.com/questions/20412405/rolling-hash-in-rabin-karp
	 * 
	 * @param text
	 *            text for which we want to calculate the hash
	 * @param start
	 *            Start position in array, inclusive
	 * @param end
	 *            end position in array, exclusive
	 * @param previousHash
	 *            previously computed hash value which will be used to compute
	 *            current hash value
	 * @return calculated hash value
	 */
	public long successiveHash2(String text, int start, int end, long previousHash) {
		long preTerm = 1;
		for (int i = start; i < end - 1; i++) {
			preTerm = (preTerm * base) % mod;
		}
		long newHash = (base * (previousHash - ((text.charAt(start - 1) * preTerm) % mod) + mod) + text.charAt(end - 1))
				% mod;
		return newHash;
	}
}
