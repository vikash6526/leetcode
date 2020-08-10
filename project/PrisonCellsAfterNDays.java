package leetcode.project;

import java.util.Arrays;

public class PrisonCellsAfterNDays {

	public static int[] prisonAfterNDays(int[] cells, int N) {
		int[] previousDay = new int[cells.length];
		for (int i = 1; i <= N; i++) {
			previousDay = Arrays.copyOf(cells, cells.length);
			for (int j = 1; j <= cells.length - 2; j++) {
				if (previousDay[j - 1] == previousDay[j + 1])
					cells[j] = 1;
				else
					cells[j] = 0;
			}
			cells[0] = 0;
			cells[cells.length - 1] = 0;
		}
		return cells;
	}

	public static void main(String[] args) {
		int[] cells = new int[] { 1, 0, 0, 1, 0, 0, 1, 0 };
		int[] test = Arrays.copyOf(cells, cells.length);
		System.out.println(Arrays.toString(test));
		test[0] = 1;
		System.out.println(Arrays.toString(cells));
		System.out.println(Arrays.toString(test));
//		System.out.println(Arrays.toString(prisonAfterNDays(cells, 1000000000)));

	}

}
