package leetcode.project;

import java.util.Arrays;

public class RandomPickwithWeight {
	int[] arr;
	int sum = 0;

	public void Solution(int[] w) {
		for (int i = 0; i < w.length; i++) {
			sum = sum + w[i];
			arr[i] = sum;
		}
	}

	public int pickIndex() {
		int idx = (int) (Math.random() * sum);
		return binarySearch(idx + 1);
	}

	private int binarySearch(int val) {
		int l = 0;
		int r = arr.length - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] < val) {
				l = mid + 1;
			} else
				r = mid;
		}
		return l;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 4, 7, 9, 15 };
		System.out.println(Arrays.binarySearch(arr, 4));
		System.out.println(Math.abs(Arrays.binarySearch(arr, 4) + 1));
	}

}
