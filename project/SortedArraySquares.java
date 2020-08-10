package leetcode.project;

import java.util.Arrays;

public class SortedArraySquares {

	public static int[] sortedSquares(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] = (int) Math.pow(A[i], 2);
		}
		Arrays.sort(A);
		return A;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));

	}

}
