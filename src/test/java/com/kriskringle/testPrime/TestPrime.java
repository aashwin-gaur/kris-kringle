package com.kriskringle.testPrime;

import org.junit.Test;

public class TestPrime {

	@Test
	public void test() {

		//primesUpto(100000);
		firstPrimes(1000000);
	}

	public static boolean isPrime(int n) {
		if (n <= 3)
			return true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void primesUpto(int n) {
		int i = 1;	
		int totalPrimes = 0;
		for (i = 1; i <= n / 2; i++) {
			if (isPrime(i)) {
				System.out.println(i);
				totalPrimes++;
			}
		}
		System.out.println("Total Primes < " + n + " = " + totalPrimes);
	}

	public static void firstPrimes(int n) {
		int count = 0;
		int num = 2;
		while (count != n)// while count!= number of prime numbers entered keep searching..
		{
			boolean prime = true;// to determine whether the number is prime or not
			for (int i = 2; i <= Math.sqrt(num); i++)// efficiency matters
			{
				if (num % i == 0) {
					prime = false;// if number divides any other number its not a prime so set prime to false and
									// break the loop.
					break;
				}

			}
			if (prime) {
				count++;
				System.out.println(num);
			}
			num++;
		}
	}
}
