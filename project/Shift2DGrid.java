package leetcode.project;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
	public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int[][] matrix = new int[grid.length][grid[0].length];
		int row = grid.length;
		int col = grid[0].length;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int increment = (j + k) / col;
				int nRow = (i + increment) % row;
				int nCol = (k + j) % col;
				matrix[nRow][nCol] = grid[i][j];
			}
		}
		List<List<Integer>> list = new ArrayList<>();
		for (int[] rowData : matrix) {
			List<Integer> childList = new ArrayList<>();
			for (Integer data : rowData) {
				childList.add(data);
			}
			list.add(childList);
		}
		return list;
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		shiftGrid(grid, 1);

	}

}
