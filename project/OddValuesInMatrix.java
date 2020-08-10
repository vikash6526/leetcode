package leetcode.project;

public class OddValuesInMatrix {

	public static int oddCells(int n, int m, int[][] indices) {
		int[][] matrix = new int[n][m];
		int count = 0;
		int l = 0;
		while (l < indices.length) {
			int row = indices[l][0];
			for (int i = 0; i < m; i++) {
				matrix[row][i] += 1;
			}
			int col = indices[l][1];
			for (int i = 0; i < n; i++) {
				matrix[i][col] += 1;
			}
			l++;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] % 2 != 0)
					count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(oddCells(2, 3, new int[][] { { 0, 1 }, { 1, 1 } }));

	}

}
