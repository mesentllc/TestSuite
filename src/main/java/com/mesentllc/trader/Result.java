package com.mesentllc.trader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Result {
	private static List<String> readFile() throws IOException {
		List<String> list = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("/test.txt"));
		while (br.ready()) {
			list.add(br.readLine().trim());
		}
		return list;
	}

	public static List<String> mostActive(List<String> customers) {
		Set<String> returnValues = new TreeSet<String>();
		Map<String, Integer> tradeMap = new HashMap<String, Integer>();

		for (String customer : customers) {
			Integer count = tradeMap.get(customer);
			if (count == null) {
				count = 0;
				tradeMap.put(customer, 1);
			}
			else {
				tradeMap.put(customer, ++count);
			}
		}
		for (String customer : tradeMap.keySet()) {
			int trades = tradeMap.get(customer);

			if (trades * 100 / customers.size() > 5) {
				returnValues.add(customer);
			}
		}
		return new ArrayList<String>(returnValues);
	}

	public static void main(String[] args) throws IOException {
		List<String> test = readFile();
		mostActive(test);
	}
}