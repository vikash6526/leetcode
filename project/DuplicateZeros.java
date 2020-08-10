package leetcode.project;

import java.util.Arrays;

public class DuplicateZeros {
	public static int[] duplicateZeros1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = arr.length - 1; j >= i + 2; j--) {
					arr[j] = arr[j - 1];
				}
				if (i < arr.length - 1) {
					arr[i + 1] = 0;
					i++;
				}
			}
		}
		return arr;
	}

	public static int[] duplicateZeros(int[] arr) {
		int length = 0;
		int i = 0;
		int start = Integer.MAX_VALUE;
		while (i < arr.length) {
			if (arr[i] == 0) {
				length += 2;
				start = Math.min(i, start);
			} else
				length++;
			i++;
			if (length == arr.length || length > arr.length)
				break;
		}
		i--;
		int end = i;
		for (int j = arr.length - 1; j > 0 && i >= start; j--) {
			if (i == end && arr[end] == 0)
				arr[j] = arr[i--];
			else if (arr[i] == 0) {
				arr[j--] = 0;
				arr[j] = arr[i--];
			} else
				arr[j] = arr[i--];
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0, 2,
				3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0, 8, 8, 8, 8, 0,
				0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0 };
		// System.out.println(arr.length);
		int[] arr1 = new int[] { 1, 0, 2, 3, 0, 4, 5, 0 };
		System.out.println(Arrays.toString(duplicateZeros(arr)));
	}

}
