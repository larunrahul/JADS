package com.learning.ads;

public class EulerGCD {
	
	public static int gcd(int a, int b){
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
	}

	public static void main(String[] args) {
		System.out.println(gcd(1071, 462));
		System.out.println(gcd(462, 1071));
		System.out.println(gcd(0, 45));
		System.out.println(gcd(45, 0));
	}

}
