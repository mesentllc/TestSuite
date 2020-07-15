package com.mesentllc.matrix;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagDiff {
		/*
		 * Complete the 'diagonalDifference' function below.
		 *
		 * The function is expected to return an INTEGER.
		 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
		 */

		public static int diagonalDifference(List<List<Integer>> arr) {
			int pos = 0;
			int max = arr.size() - 1;
			Integer ltor = 0;
			Integer rtol = 0;

			for (List list : arr) {
				ltor += (Integer)list.get(pos);
				rtol += (Integer)list.get(max - pos++);
			}
			return Math.abs(ltor - rtol);
		}

	}

	class Solution {
		public static void main(String[] args) throws IOException {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

			int n = Integer.parseInt(bufferedReader.readLine().trim());

			List<List<Integer>> arr = new ArrayList<>();

			IntStream.range(0, n).forEach(i -> {
				try {
					arr.add(
							Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
									.map(Integer::parseInt)
									.collect(toList())
					);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			});

			int result = DiagDiff.diagonalDifference(arr);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();

			bufferedReader.close();
			bufferedWriter.close();
		}
	}

