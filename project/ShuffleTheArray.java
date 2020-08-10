package leetcode.project;

public class ShuffleTheArray {
	public static int[] shuffle(int[] nums, int n) {
		int[] arr = new int[nums.length];
		int mid = n;
		int k = 0;
		for (int i = 0; i < n; i++) {
			arr[k++] = nums[i];
			arr[k++] = nums[i + mid];
		}
		return arr;

	}

	public static void main(String[] args) {
		shuffle(new int[] { 1, 1, 2, 2 }, 2);

	}

}
