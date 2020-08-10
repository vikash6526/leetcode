package leetcode.project;

import java.util.Arrays;

public class SortArrayByParity {

	public static int[] sortArrayByParity1(int[] A) {
		int end = A.length - 1;
		// i is the index before which all evens are there
		// end is the index after which all odds are there
		for (int i = 0; i < end; i++) {

			if ((A[i] & 1) != 0) {
				// swap with last even
				while (end > i && (A[end] & 1) != 0) {
					end--;
				}

				// swap
				int temp = A[end];
				A[end] = A[i];
				A[i] = temp;
				end--;
			}
		}
		return A;
	}

	public static int[] sortArrayByParity(int[] A) {
		int i = 0, j = A.length - 1;
		if (A.length == 1)
			return A;
		while (j > i) {
			if (A[i] % 2 != 0) {
				if (A[j] % 2 == 0) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
					i++;
					j--;
				} else
					j--;
			}
			if (A[i] % 2 == 0) {
				if (A[j] % 2 == 0)
					i++;
				else {
					i++;
					j--;
				}
			}
		}
		return A;
	}

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(sortArrayByParity1((new int[] { 0, 1
		// }))));
		int a = 99;
		System.out.println(a & 1);
	}

}
