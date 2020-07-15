package com.mesentllc.recursion;

public class ReversePrint {
	char[] reversed;
	int ptr = 0;

	public char[] reverseString(char[] s) {
		reversed = new char[s.length];
		return printReversed(s, 0);
	}

	private char[] printReversed(char[] chars, int position) {
		if (chars.length == 0 || position >= chars.length) {
			return chars;
		}
		printReversed(chars, position + 1);
		reversed[ptr++] = chars[position];
		return reversed;
	}

	public static void main(String[] args) {
		ReversePrint reversePrint = new ReversePrint();
		String testString = "Hello There!";
		char[] chars = testString.toCharArray();
		chars = reversePrint.reverseString(chars);
		System.out.println(chars);
	}
}
