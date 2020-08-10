package leetcode.project;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class KWeakestRows {

	public static int[] kWeakestRows(int[][] mat, int k) {
		int[] result = new int[k];
		TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
		for (int i = 0; i < mat.length; i++) {
			int ones = 0;
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1)
					ones++;
			}
			if (map.containsKey(ones))
				map.get(ones).add(i);
			else {
				Set<Integer> set = new TreeSet<>();
				set.add(i);
				map.putIfAbsent(ones, set);
			}
		}
		int i = 0;
		for (Integer data : map.keySet()) {
			for (Integer row : map.get(data)) {
				result[i++] = row;
				if (i == k)
					break;
			}
			if (i == k)
				break;
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 },
				{ 1, 1, 1, 1, 1 } };
		System.out.println(Arrays.toString(kWeakestRows(mat, 3)));

	}

}
