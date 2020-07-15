package com.mesentllc.balance;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.ArrayDeque;
import java.util.Deque;

public class Balance {
	static boolean isBalanced(String s) {
		Deque<String> stack = new ArrayDeque<>();

		for (char character : s.toCharArray()) {
			if (character == '[') {
				stack.push("bracket");
			}
			if (character == ']' && !expected(stack, "bracket")) {
				return false;
			}
			if (character == '{') {
				stack.push("brace");
			}
			if (character == '}' && !expected(stack, "brace")) {
				return false;
			}
			if (character == '(') {
				stack.push("paren");
			}
			if (character == ')' && !expected(stack, "paren")) {
				return false;
			}
		}

		return stack.isEmpty();
	}

	private static boolean expected(Deque<String> stack, String type) {
		if (stack.isEmpty()) {
			return false;
		}
		return type.equals(stack.pop());
	}

	public static void main(String[] args) {
		JUnitCore.main("com.mesentllc.balance.Balance");
	}

	@Test
	public void isBalanced_embeddedSequence_balanced() {
		Assert.assertTrue(isBalanced("{[()]}"));
	}

	@Test
	public void isBalanced_braceBracketParenSequence_balanced() {
		Assert.assertTrue(isBalanced("{[]()}"));
	}

	@Test
	public void isBalanced_badSequenceSingleOutOfOrder_notBalanced() {
		Assert.assertFalse(isBalanced("{[(])}"));
	}

	@Test
	public void isBalanced_badSequenceSeveralOutOfOrder_notBalanced() {
		Assert.assertFalse(isBalanced("{[[[]((]]]))}"));
	}

	@Test
	public void isBalanced_deepEmbeddedSequence_balanced() {
		Assert.assertTrue(isBalanced("{{[[(())]]}}"));
	}

	@Test
	public void isBalanced_onlyClosingBrace_notBalanced() {
		Assert.assertFalse(isBalanced("]"));
	}

	@Test
	public void isBalanced_missingClosingBrace_notBalanced() {
		Assert.assertFalse(isBalanced("[()"));
	}
}
