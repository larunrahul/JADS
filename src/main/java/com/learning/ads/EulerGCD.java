package com.learning.ads;

public class EulerGCD {
	
	/**
	 * A recursive implementation of EULER GCD algorithm
	 * @param a
	 * @param b
	 * @return gcd of a and b
	 */
	public static int gcd(int a, int b){
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
	}

	public static void main(String[] args) {
		System.out.println(gcd(1071,462));
	}

}
