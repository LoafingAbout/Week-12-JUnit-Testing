package com.promineotech;

import java.util.Random;
import java.util.function.IntPredicate;

public class TestDemo {
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive");
		}
	}
	public double multiplyThenDivide(double a, double b, double c) {
		return (a * b)/ c;
	}
	public int randomNumberSquared() {
		int randomNumber = getRandomInt();
		int result = randomNumber * randomNumber;
		
		return result;
	}
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}
