package com.mesentllc.triplets;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Triplets {
	// Complete the compareTriplets function below.
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		Integer[] pointScores = {0, 0};

		for (int ptr = 0; ptr < a.size(); ptr++) {
			if (a.get(ptr) > b.get(ptr)) {
				pointScores[0]++;
			}
			if (a.get(ptr) < b.get(ptr)) {
				pointScores[1]++;
			}
		}
		return (Arrays.asList(pointScores));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> result = compareTriplets(a, b);

		bufferedWriter.write(
				result.stream()
						.map(Object::toString)
						.collect(joining(" "))
						+ "\n"
		);
		bufferedReader.close();
		bufferedWriter.close();
	}
}
