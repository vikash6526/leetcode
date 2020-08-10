package leetcode.project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumbersThanCurrent {

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] num = new int[nums.length];
		System.arraycopy(nums, 0, num, 0, nums.length);
		Arrays.sort(num);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < num.length; i++) {
			map.putIfAbsent(num[i], i);
		}
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = map.get(nums[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 });

	}

}
