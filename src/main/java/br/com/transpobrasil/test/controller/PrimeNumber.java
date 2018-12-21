package br.com.transpobrasil.test.controller;

public class PrimeNumber {
  //41 e 5002
	public static void main(String[] args) {
		for (int i = 41; i <= 5002; i++) {
			if (isPrimeNumber(i))
				System.out.println(i + " is prime number.");
		}
	}

	private static boolean isPrimeNumber(int number) {
		for (int j = 42; j < number; j++) {
			if (number % j == 0)
				return false;
		}
		return true;
	}
}
