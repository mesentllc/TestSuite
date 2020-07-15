package com.mesentllc.minmax;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	static void miniMaxSum(int[] arr) {
		List<Integer> sortedCollection = new ArrayList<>();
		for (int ptr = 0; ptr < arr.length; ptr++) {
			sortedCollection.add(arr[ptr]);
		}
		Collections.sort(sortedCollection);
		BigInteger min = new BigInteger(sortedCollection.get(0).toString()).add(BigInteger.valueOf(sortedCollection.get(1)))
				.add(BigInteger.valueOf(sortedCollection.get(2))).add(BigInteger.valueOf(sortedCollection.get(3)));
		BigInteger max = new BigInteger(sortedCollection.get(1).toString()).add(BigInteger.valueOf(sortedCollection.get(2)))
				.add(BigInteger.valueOf(sortedCollection.get(3))).add(BigInteger.valueOf(sortedCollection.get(4)));
		System.out.println(String.format("%d %d",min,max));
	}

	public static void main(String[] args) {
		int[] arr = {256741038, 623958417, 467905213, 714532089, 938071625};
		miniMaxSum(arr);
	}
}
