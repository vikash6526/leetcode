package leetcode.project;

import java.util.TreeMap;

public class LongestContinuousSubarray {

	public static int longestSubarray(int[] nums, int limit) {
		if (nums.length == 1)
			return 1;
		int length = 0, j = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			while (!(map.lastKey() - map.firstKey() <= limit)) {
				int value = nums[j];
				map.put(value, map.get(value) - 1);
				if (map.get(value).equals(0)) {
					map.remove(value);
				}
				j++;
			}
			length = Math.max(length, i - j + 1);
		}
		return length;
	}

	public static void main(String[] args) {
		int[] arr = new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
		System.out.println(longestSubarray(new int[] { 4, 2, 2, 2, 4, 4, 2, 2 }, 0));
		// System.out.println(longestSubarray(arr, 6));
	}

}
