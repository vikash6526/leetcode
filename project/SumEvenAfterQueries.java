package leetcode.project;

import java.util.Arrays;

public class SumEvenAfterQueries {
	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] arr = new int[A.length];
		int k = 0;
		int sum = 0;
		for (int j = 0; j < A.length; j++) {
			if (A[j] % 2 == 0)
				sum = sum + A[j];
		}
		for (int i = 0; i < queries.length; i++) {
			if (A[queries[i][1]] % 2 != 0) {
				if (queries[i][0] % 2 != 0) {
					sum = sum + A[queries[i][1]] + queries[i][0];
					A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
				} else if (queries[i][0] % 2 == 0) {
					A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
				}
			} else if (A[queries[i][1]] % 2 == 0) {
				if (queries[i][0] % 2 != 0) {
					sum = sum - A[queries[i][1]];
					A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
				} else if (queries[i][0] % 2 == 0) {
					sum = sum + queries[i][0];
					A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
				}
			}
			arr[k++] = sum;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4 };
		int[][] matrix = new int[][] { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } };
		System.out.println(Arrays.toString(sumEvenAfterQueries(arr, matrix)));

	}

}
