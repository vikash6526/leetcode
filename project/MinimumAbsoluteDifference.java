package leetcode.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			min = Math.min(min, arr[i + 1] - arr[i]);
		}
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] == min) {
				List<Integer> childList = new ArrayList<>();
				childList.add(arr[i]);
				childList.add(arr[i + 1]);
				list.add(childList);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		minimumAbsDifference(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 });

	}

}
