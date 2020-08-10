package leetcode.project;

import java.util.Arrays;

public class FindTheDistanceValue {

	public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		Arrays.sort(arr2);
		int res = 0;
		for (int n : arr1) {
			int id = Arrays.binarySearch(arr2, 0, arr2.length, n);
			if (id < 0)
				id = -(id + 1);
			int diff;
			if (id == 0) {
				diff = Math.abs(n - arr2[id]);
			} else if (id == arr2.length) {
				diff = Math.abs(n - arr2[id - 1]);
			} else {
				diff = Math.min(Math.abs(n - arr2[id - 1]), Math.abs(n - arr2[id]));
			}
			res += diff <= d ? 0 : 1;
		}
		return res;
	}

	public static int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {
		int count = 0;
		boolean distance = true;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] - d <= arr2[j] && arr2[j] <= arr1[i] + d)
					distance = false;
			}
			if (distance)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(findTheDistanceValue(new int[] { 4, 5, 8 }, new int[] { 10, 9, 1, 8 }, 2));

	}

}
