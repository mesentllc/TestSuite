package com.mesentllc.minmax;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class Candles {
	static int birthdayCakeCandles(int[] ar) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int value : ar) {
			Integer count = map.computeIfAbsent(value, k -> new Integer("0"));
			count++;
			map.put(value, count);
			if (max < value) {
				max = value;
			}
		}
		return map.get(max);
	}

	public static void main(String[] args) {
		int[] ar = {3, 2, 1, 3};
		Assert.assertEquals(2, birthdayCakeCandles(ar));
	}
}