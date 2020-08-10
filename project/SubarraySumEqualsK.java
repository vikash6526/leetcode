package leetcode.project;

public class SubarraySumEqualsK {
	public static int subarraySum(int[] nums, int k) {
		if (nums.length == 1 && nums[0] == k)
			return 1;
		int count = 0;
		int start = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (nums[i] > k) {
				sum = 0;
				start = i;
			} else if (nums[i] == k) {
				count++;
				start = i;
			} else if (sum == k) {
				count++;
				sum = 0;
				start++;
				i = start - 1;
			} else if (nums[i] < k && sum <= nums[i]) {
				sum = nums[i];
				start = i;
			} else if (sum > k) {
				sum = 0;
				start = i - 1;
				i = start;
			}

		}
		return count;
	}

	public static int subarraySum1(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			if (nums[i] > k)
				continue;
			else if (nums[i] == k) {
				count++;
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum < k)
					continue;
				else if (sum == k) {
					count++;
					break;
				} else if (nums[j] == k) {
					count++;
					i = j;
					break;
				} else if (nums[j] > k) {
					sum = 0;
					i = j;
					break;
				} else if (sum > k) {
					sum = 0;
					break;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 1, 23, 21, 3, 1, 2, 1, 1, 1, 1,
		// 1, 12, 2, 3, 2, 3, 2, 2 };
		int[] arr = new int[] { -1, -1, 1 };
		System.out.println(subarraySum1(arr, 0));
	}

}
