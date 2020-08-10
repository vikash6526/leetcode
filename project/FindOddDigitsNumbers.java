package leetcode.project;

public class FindOddDigitsNumbers {

	public static int findNumbers(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int length = String.valueOf(nums[i]).length();
			if (length % 2 == 0)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(findNumbers(new int[] { 12, 2, 3, 3456, 34 }));

	}

}
