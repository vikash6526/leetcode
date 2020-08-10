package leetcode.project;

public class VisitAllPoints {

	public static int minTimeToVisitAllPoints(int[][] points) {
		int result = 0;
		for (int i = 1; i < points.length; i++) {
			result += Math.max(Math.abs(points[i - 1][0] - points[i][0]), Math.abs(points[i - 1][1] - points[i][1]));
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(minTimeToVisitAllPoints(new int[][] { { 1, 1 }, { 3, 4 }, { -1, 0 } }));

	}

}
