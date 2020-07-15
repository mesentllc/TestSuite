package com.mesentllc.power;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PowerOfTwo {
	private static final Deque<Integer>[] stack = new ArrayDeque[2];

	public static long countPairs(List<Integer> arr) {
		stack[0] = new ArrayDeque<>();
		stack[1] = new ArrayDeque<>();
		for (int value : arr) {
			stack[0].push(value);
		}
		int count = 0;
		int stackToUse = 0;
		while (!stack[stackToUse].isEmpty()) {
			count += process(stackToUse);
			stackToUse = (stackToUse + 1) % 2;
		}
		return count;
	}

	private static int process(int stackToUse) {
		int count = 0;
		int otherStack = (stackToUse + 1) % 2;
		int top = stack[stackToUse].pop();
		while (!stack[stackToUse].isEmpty()) {
			int value = stack[stackToUse].pop();
			stack[otherStack].push(value);
			double result = (Math.log(top & value) / Math.log(2));
			if (result == (double)(int)result) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		List<Integer> data = new ArrayList<>();
		data.add(10);
		data.add(7);
		data.add(2);
		data.add(8);
		data.add(3);
		long x = PowerOfTwo.countPairs(data);
		System.exit(0);
	}
}
