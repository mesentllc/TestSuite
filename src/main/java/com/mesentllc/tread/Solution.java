package com.mesentllc.tread;

import java.util.Scanner;

public class Solution {

	// Complete the staircase function below.
	static void staircase(int n) {
		String tread = "";

		for (int ptr = 0; ptr < n; ptr++) {
			tread += "#";
			int spaces = n - ptr - 1;
			if (spaces > 0) {
				System.out.println(String.format("%" + spaces + "s%s", "",tread));
			}
			else {
				System.out.println(String.format("%s", tread));
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		staircase(n);

		scanner.close();
	}
}
