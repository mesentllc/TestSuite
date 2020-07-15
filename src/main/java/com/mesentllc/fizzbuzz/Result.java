package com.mesentllc.fizzbuzz;

class Result {
	public static void fizzBuzz(int n) {
		for (int ptr = 1; ptr <= n; ptr++) {
			int printed = 0;
			if (ptr % 3 == 0) {
				System.out.print("Fizz");
				printed++;
			}
			if (ptr % 5 == 0) {
				System.out.print("Buzz");
				printed++;
			}
			if (printed > 0) {
				System.out.println();
			}
			else {
				System.out.println(ptr);
			}
		}
	}
}