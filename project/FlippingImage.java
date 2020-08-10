package leetcode.project;

import java.util.Arrays;

public class FlippingImage {

	public static int[][] flipAndInvertImage(int[][] A) {
		int row = A.length;
		int col = A[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col / 2; j++) {
				if (A[i][j] != A[i][col - 1 - j]) {
					int temp = A[i][j];
					A[i][j] = 1- A[i][col - 1 - j];
					A[i][col - 1 - j] = 1- temp;
				}
			}
		}
		return A;
	}
	
	

	public static void main(String[] args) {
		System.out.println(Arrays.toString(flipAndInvertImage(new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } })));
	}

}
