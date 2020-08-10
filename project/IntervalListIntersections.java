package leetcode.project;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		if (A.length < 1 || B.length < 1)
			return new int[0][0];

		int prevMax = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int k = 0;
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < A.length && i < B.length; i++) {
			min = Math.min(A[i][0], B[i][0]);
			max = Math.max(A[i][0], B[i][0]);
			if (prevMax == min) {
				List<Integer> childList = new ArrayList<>();
				childList.add(min);
				childList.add(min);
				list.add(childList);
			}
			min = Math.min(A[i][1], B[i][1]);
			prevMax = Math.max(A[i][1], B[i][1]);
			if (max <= min) {
				List<Integer> childList = new ArrayList<>();
				childList.add(max);
				childList.add(min);
				list.add(childList);
			}
		}
		int[][] result = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			result[i][0] = list.get(i).get(0);
			result[i][1] = list.get(i).get(1);
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] A = new int[][] { { 14, 16 } };
		int[][] B = new int[][] { { 7, 13 }, { 16, 20 } };
		intervalIntersection(A, B);

	}

}
