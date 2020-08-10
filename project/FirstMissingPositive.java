package leetcode.project;

import java.util.Arrays;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				min = Math.min(min, nums[i]);
				index = i;
				break;
			}
		}
		if (min != 1)
			return 1;
		for (int i = index + 1; i < nums.length; i++) {
			if (nums[i] - min == 1)
				min = nums[i];
		}

		return min + 1;
	}

	public static int firstMissingPositive1(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				min = Math.min(min, nums[i]);
		}
		if (min != 1)
			return 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				if (nums[i] - min == 0)
					min++;
				if (nums[i] - min == 1)
					min = nums[i] + 1;
			}
		}

		return min;
	}

	public static void main(String[] args) {
		System.out.println(firstMissingPositive1(new int[] { 4,1,2,3 }));

	}

}
