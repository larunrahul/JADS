package math.numbertheory;

public class LCM {

	/**
	 * LCM(a,b) = |a.b|/GCD(a,b) == (|a|/GCD(a,b))*|b|
	 */
	public static int findLCM(int first, int second) {
		return (Math.abs(first) / EuclidGCD.gcd(first, second)) * Math.abs(second);
	}

	public static void main(String[] args) {
		System.out.println(findLCM(12, 18));
	}

}
