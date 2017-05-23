package com.learning.ads.math.numbertheory;

public class Power {

	public long power(int base, int exponent) {
		if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return 1 / power(base, -exponent); // a^-b = 1 / a^b
        }
        if ((exponent & 1) == 1) { //if exponent is odd
            return base * power(base, exponent - 1);
        } else {
            long pow = power(base, exponent >> 1); //divide exponent by 2
            return pow * pow;
        }
	}

}
