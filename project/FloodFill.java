package leetcode.project;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor)
			return image;
		dfs(image, sr, sc, image[sr][sc], newColor);

		return image;
	}

	public void dfs(int[][] image, int row, int col, int color, int newColor) {
		if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != color)
			return;
		image[row][col] = newColor;
		dfs(image, row + 1, col, color, newColor);
		dfs(image, row - 1, col, color, newColor);
		dfs(image, row, col + 1, color, newColor);
		dfs(image, row, col - 1, color, newColor);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
