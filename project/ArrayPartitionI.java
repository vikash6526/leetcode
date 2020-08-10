package leetcode.project;

import java.util.Arrays;

public class ArrayPartitionI {

	public static int arrayPairSum(int[] nums) {

		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i <= nums.length-2; i+=2) {
			sum = sum + nums[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(arrayPairSum(new int[] { 1, 4, 3, 2 }));
	}

}
