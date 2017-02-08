package com.learning.ads.math.numbertheory;

public class Power {
	/*
	 *   T(n) = k            if n is 1
	 *   T(n) = k * T(n-1)   if n is odd
	 *   T(n) = square(T(n/2))       if n is even 
	 */
	public static long power(int variable, int exponent){
		if(exponent == 1){
			return variable;
		}
		if((exponent & 1) == 1){ //odd exponent
			return variable * power(variable, exponent-1);
		}else{
			long intProduct = power(variable, exponent/2);
			return intProduct * intProduct;
		}
	}

	public static void main(String[] args) {
		System.out.println(power(2,5));
	}

}
