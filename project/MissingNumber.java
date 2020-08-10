package leetcode.project;

import java.util.Arrays;

public class MissingNumber {
	public static int missingNumber2(int[] nums) {
		int[] arr = new int[nums.length + 1];
		int missNo = 0;
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]] = 1;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				missNo = i;
			}
		}
		return missNo;
	}

	public static int missingNumber1(int[] nums) {
		int expectedSum = nums.length * (nums.length + 1) / 2;
		int actualSum = 0;
		for (int num : nums)
			actualSum += num;
		return expectedSum - actualSum;
	}

	public static int missingNumber(int[] nums) {
		int missing = nums.length;
		for (int i = 0; i < nums.length; i++) {
			System.out.println(missing);
			missing ^= i ^ nums[i];
		}
		return missing;
	}

	public static int findDuplicate(int[] nums) {
		// Find the intersection point of the two runners.
		System.out.println(Arrays.binarySearch(nums, 1));
		int tortoise = nums[0];
		int hare = nums[0];
		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (tortoise != hare);

		// Find the "entrance" to the cycle.
		tortoise = nums[0];
		while (tortoise != hare) {
			tortoise = nums[tortoise];
			hare = nums[hare];
		}
		return hare;
	}

	public static void main(String[] args) {
		// System.out.println(missingNumber(new int[] { 1, 6, 4, 2, 3, 5, 7, 0, 9 }));
		System.out.println(findDuplicate(new int[] { 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 }));
		// System.out.println(9 ^ (0 ^ 1) ^ (1 ^ 6) ^ (2 ^ 4) ^ (3 ^ 2) ^ (4 ^ 3) ^ (5 ^
		// 5) ^ (6 ^ 7) ^ (7 ^ 0) ^ (8 ^ 9));
		// System.out.println(7 ^ 9);
	}
}
