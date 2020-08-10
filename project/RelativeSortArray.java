package leetcode.project;

import java.util.Arrays;
import java.util.TreeMap;

public class RelativeSortArray {
	public static int[] relativeSortArray1(int[] arr1, int[] arr2) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < arr1.length; i++) {
			map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
		}
		int j = 0;
		for (int i = 0; i < arr2.length; i++) {
			while (map.get(arr2[i]) > 0) {
				arr1[j++] = arr2[i];
				map.put(arr2[i], map.get(arr2[i]) - 1);
			}
		}
		for (Integer data : map.keySet()) {
			if (map.get(data) != 0) {
				while (map.get(data) > 0) {
					arr1[j++] = data;
					map.put(data, map.get(data) - 1);
				}
			}
		}

		return arr1;
	}

	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] countMap = new int[1001];
		for (int each : arr1) {
			countMap[each] += 1;
		}
		int i = 0;
		for (int each : arr2) {
			while (countMap[each] > 0) {
				arr1[i++] = each;
				countMap[each] -= 1;
			}
		}

		for (int j = 0; j < countMap.length; j++) {
			while (countMap[j] > 0) {
				arr1[i] = j;
				i++;
				countMap[j] -= 1;
			}
		}
		return arr1;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int[] arr2 = new int[] { 2, 1, 4, 3, 9, 6 };
		System.out.println(Arrays.toString(relativeSortArray1(arr1, arr2)));

	}

}
