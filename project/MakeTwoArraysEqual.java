package leetcode.project;

import java.util.HashMap;
import java.util.Map;

public class MakeTwoArraysEqual {
	public static boolean canBeEqual(int[] target, int[] arr) {
		Map<Integer, int[]> map = new HashMap<>();
		for (Integer data : target) {
			if (map.containsKey(data)) {
				int[] newarr = map.get(data);
				newarr[0] += 1;
				map.put(data, newarr);
			} else {
				int[] newarr = new int[2];
				newarr[0] = 1;
				map.put(data, newarr);
			}
		}
		for (Integer data : arr) {
			if (map.containsKey(data)) {
				int[] newarr = map.get(data);
				newarr[1] += 1;
				map.put(data, newarr);
			} else {
				int[] newarr = new int[2];
				newarr[1] = 1;
				map.put(data, newarr);
			}
		}
		for (int[] data : map.values()) {
			if (data[0] != data[1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] target = new int[] { 1, 1, 1, 1, 1 };
		int[] arr = new int[] { 1, 1, 1, 1, 1 };

		System.out.println(canBeEqual(target, arr));
	}

}
