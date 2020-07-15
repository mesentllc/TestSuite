package com.mesentllc.matrix;

import java.util.Scanner;

public class PlusMinusZero {

	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		int[] matrix = {0, 0, 0};

		for (int value : arr) {
			switch ((int)(Math.signum(value))) {
				case 1:
					matrix[0]++;
					break;
				case -1:
					matrix[1]++;
					break;
				default:
					matrix[2]++;
			}
		}
		for (int value : matrix) {
			System.out.println(((float)value) / arr.length);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}
}
