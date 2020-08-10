package leetcode.project;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int peri = 0;
		int r = grid.length, c = grid[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1) {
					if (i == 0 || (i > 0 && grid[i - 1][j] == 0))
						peri++;
					if (j == 0 || (j > 0 && grid[i][j - 1] == 0))
						peri++;
					if (i == r - 1 || (i < r - 1 && grid[i + 1][j] == 0))
						peri++;
					if (j == c - 1 || (j < c - 1 && grid[i][j + 1] == 0))
						peri++;
				}
			}
		}

		return peri;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
