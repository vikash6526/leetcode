package leetcode.project;

public class MaxSubarraySumCircular {
	public static int maxSubarraySumCircular(int[] A) {
		int sum = 0;
		int max_sum = 0;
		int min_sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
			max_sum = Math.max(A[i], max_sum + A[i]);
			max = Math.max(max, max_sum);
			min_sum = Math.min(A[i], min_sum + A[i]);
			min = Math.min(min, min_sum);
		}
		if (max > 0)
			return Math.max(max, sum - min);
		return max;

	}

	public static void main(String[] args) {
		System.out.println(maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
	}

}
