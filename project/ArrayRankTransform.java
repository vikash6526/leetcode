package leetcode.project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ArrayRankTransform {
	public static int[] arrayRankTransform(int[] arr) {
		int[] rankMatrix = new int[arr.length];
		Set<Integer> set = new TreeSet<>();
		for (int num : arr) {
			set.add(num);
		}
		int rank = 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : set) {
			map.put(i, rank++);
		}
		int incr = 0;
		for (int i : arr) {
			rankMatrix[incr++] = map.get(i);
		}
		return rankMatrix;
	}

	public int[] arrayRankTransform2(int[] arr) {
		int[] clone = arr.clone();
		Arrays.sort(clone);
		Map<Integer, Integer> map = new HashMap<>();
		int c = 1;
		for (int i = 0; i < clone.length; ++i) {
			if (map.get(clone[i]) == null) {
				map.put(clone[i], c);
				++c;
			}
		}
		for (int i = 0; i < arr.length; ++i) {
			clone[i] = map.get(arr[i]);
		}
		return clone;
	}

	public static int[] arrayRankTransform1(int[] arr) {
		SortedSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = set.headSet(arr[i]).size() + 1;
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(arrayRankTransform(new int[] { 100, 100, 100 })));
	}

}
