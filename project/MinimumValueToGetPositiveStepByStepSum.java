package leetcode.project;

import java.util.Arrays;

public class MinimumValueToGetPositiveStepByStepSum {

	public static int minStartValue1(int[] nums) {
		int min = 1;
		int sum = 0;
		for (int i : nums) {
			sum += i;
			if (sum < 0 && sum < min) {
				min = sum;
			}
		}
		return min == 1 ? 1 : min * -1 + 1;

	}

	public static int minStartValue(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
		}
		Arrays.sort(nums);
		return nums[0] < 1 ? 1 - nums[0] : 1;

	}

	public static void main(String[] args) {
		System.out.println(minStartValue(new int[] { -3, 2, -3, 4, 2 }));
	}

}
