package leetcode.project;

import java.util.ArrayList;
import java.util.List;

public class CheckStraightLine {
	public static int countTriplets(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int a = 0;
			for (int j = i; j < arr.length; j++) {
				int b = 0;
				a = a ^ arr[j];
				for (int k = j + 1; k < arr.length; k++) {
					b = b ^ arr[k];
					if (a == b)
						count++;
				}
			}
		}
		return count;
	}

	public static List<String> buildArray(int[] target, int n) {
		List<String> list = new ArrayList<>();
		int k = 0;
		for (int i = 1; i <= n && k < target.length; i++) {
			if (i == target[k]) {
				list.add("Push");
				k++;
			} else {
				list.add("Push");
				list.add("Pop");
			}
		}
		return list;
	}

	public static boolean checkStraightLine(int[][] coordinates) {
		if ((coordinates[1][0] - coordinates[0][0]) == 0)
			return false;
		double slop = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
		for (int i = 2; i < coordinates.length; i++) {
			if ((coordinates[i][0] - coordinates[0][0] == 0))
				return false;
			double j = (double) (coordinates[i][1] - coordinates[0][1])
					/ (double) (coordinates[i][0] - coordinates[0][0]);
			if (j != slop)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// int[][] arr = new int[][] { { -7, -3 }, { -7, -1 }, { -2, -2 }, { 0, -8 }, {
		// 2, -2 }, { 5, -6 }, { 5, -5 },
		// { 1, 7 } };
		// System.out.println(checkStraightLine(arr));
		// buildArray(new int[] { 1, 2 }, 4);
		System.out.println(countTriplets(new int[] { 2, 3, 1, 6, 7 }));

	}

}
