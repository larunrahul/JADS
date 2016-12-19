package com.learning.ads.math.numbertheory.prime;

public class LCM {
	
	private int first;
	private int second;
	
	public LCM(int first, int second){
		this.first = first;
		this.second = second;
	}
	/**
	 * LCM(a,b) = |a.b|/GCD(a,b)
	 * LCM(a,b) = (|a|/GCD(a,b))*|b|
	 * @return
	 */
	
	public int findLCM(){
		return (Math.abs(first)/EuclidGCD.gcd(first, second))*Math.abs(second);
	}

	public static void main(String[] args) {
		System.out.println(new LCM(12,18).findLCM());
	}

}
