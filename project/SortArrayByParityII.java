package leetcode.project;

import java.util.Arrays;

public class SortArrayByParityII {

	public static int[] sortArrayByParityII(int[] A) {
		int j = 1;
		for (int i = 0; i < A.length; i += 2) {
			if (A[i] % 2 == 1) {
				while (A[j] % 2 == 1)
					j += 2;
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
			}
		}
		return A;
	}

	public static int[] sortArrayByParityII1(int[] A) {
		int j = 0;
		for (int i = 0; i < A.length; i++) {
			if (i % 2 == 0 && A[i] % 2 != 0) {
				j = i + 1;
				while (j < A.length) {
					if (A[j] % 2 == 0) {
						int temp = A[j];
						A[j] = A[i];
						A[i] = temp;
						j++;
						break;
					}
				}
			} else if (i % 2 != 0 && A[i] % 2 == 0) {
				j = i + 1;
				while (j < A.length) {
					if (A[j] % 2 != 0) {
						int temp = A[j];
						A[j] = A[i];
						A[i] = temp;
						j++;
						break;
					}
				}
			}
			j = i;
		}
		return A;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortArrayByParityII(new int[] { 3, 1, 4, 2 })));

	}

}
