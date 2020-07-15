package com.mesentllc.comparator;

class Comparator {
	public boolean compare(String source, String target) {
		return source.equals(target);
	}

	public boolean compare(int source, int target) {
		return source == target;
	}

	public boolean compare(int[] source, int[] target) {
		if (source.length != target.length) {
			return false;
		}
		for (int ptr = 0; ptr < source.length; ptr++) {
			if (source[ptr] != target[ptr]) {
				return false;
			}
		}
		return true;
	}
}