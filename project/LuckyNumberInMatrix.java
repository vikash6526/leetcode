package leetcode.project;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInMatrix {

	public static List<Integer> luckyNumbers(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		List<Integer> list = new ArrayList<>();
		int colIndex = 0;
		for (int i = 0; i < row; i++) {
			int rowMin = Integer.MAX_VALUE;
			int colMax = Integer.MIN_VALUE;
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] < rowMin) {
					rowMin = Math.min(rowMin, matrix[i][j]);
					colIndex = j;
				}
			}
			for (int l = 0; l < row; l++) {
				colMax = Math.max(colMax, matrix[l][colIndex]);
			}
			if (rowMin == colMax)
				list.add(rowMin);
		}
		return list;
	}

	public static void main(String[] args) {
		luckyNumbers(new int[][] { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } });

	}

}
