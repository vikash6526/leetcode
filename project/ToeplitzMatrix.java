package leetcode.project;

import java.util.HashMap;
import java.util.Map;

public class ToeplitzMatrix {
	public static boolean isToeplitzMatrix1(int[][] matrix) {
		Map<Integer, Integer> groups = new HashMap<>();
		for (int r = 0; r < matrix.length; ++r) {
			for (int c = 0; c < matrix[0].length; ++c) {
				if (!groups.containsKey(r - c))
					groups.put(r - c, matrix[r][c]);
				else if (groups.get(r - c) != matrix[r][c])
					return false;
			}
		}
		return true;
	}

	public static boolean isToeplitzMatrix2(int[][] matrix) {
		for (int r = 0; r < matrix.length; ++r)
			for (int c = 0; c < matrix[0].length; ++c)
				if (r > 0 && c > 0 && matrix[r - 1][c - 1] != matrix[r][c])
					return false;
		return true;
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		int count = 0;
		for (int j = 0; j < matrix[0].length; j++) {
			int row = 0;
			int col = j;
			int num = matrix[row][col];
			while (row < matrix.length && col < matrix[0].length) {
				if (matrix[row++][col++] == num)
					count++;
				else
					break;

			}
		}
		for (int i = 1; i < matrix.length; i++) {
			int row = i;
			int col = 0;
			int num = matrix[row][col];
			while (row < matrix.length && col < matrix[0].length) {
				if (matrix[row++][col++] == num)
					count++;
				else
					break;
			}
		}
		if (count == matrix.length * matrix[0].length)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
		System.out.println(isToeplitzMatrix(arr));

	}

}
