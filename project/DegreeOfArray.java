package leetcode.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfArray {
	public static int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, int[]> index = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
			if (!index.containsKey(nums[i])) {
				int[] arr = new int[2];
				arr[0] = i;
				index.put(nums[i], arr);
			} else {
				int[] newArr = index.get(nums[i]);
				newArr[1] = Math.max(newArr[1], i);
				index.put(nums[i], newArr);
			}
		}
		int max = Integer.MIN_VALUE;
		for (Integer key : map.keySet()) {
			max = Math.max(max, map.get(key));
		}
		int min = Integer.MAX_VALUE;
		for (Integer key : map.keySet()) {
			if (max == map.get(key)) {
				int[] result = index.get(key);
				int indexLength = result[1] > result[0] ? result[1] - result[0] + 1 : 1;
				min = Math.min(min, indexLength);
			}
		}
		return min;
	}

	public static void main(String[] args) {
		System.out.println(findShortestSubArray(new int[] { 2, 1 }));

	}

}
