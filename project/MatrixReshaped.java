package leetcode.project;

import java.util.Arrays;

public class MatrixReshaped {
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int row = nums.length;
		int col = nums[0].length;
		if (r * c > row * col)
			return nums;
		int[] arr = new int[row * col];
		int k = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[k++] = nums[i][j];
			}
		}
		k = 0;
		int[][] matrix = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				matrix[i][j] = arr[k++];
			}
		}

		return matrix;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2 }, { 3, 4 } };
		System.out.println(Arrays.toString(matrixReshape(arr, 1, 4)));

	}

}
