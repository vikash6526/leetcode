package leetcode.project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
	public static int[] fairCandySwap(int[] A, int[] B) {
		int aSum = 0;
		for (int i = 0; i < A.length; i++) {
			aSum = aSum + A[i];
		}
		int bSum = 0;
		for (int i = 0; i < A.length; i++) {
			bSum = bSum + B[i];
		}
		int diff = (bSum - aSum) / 2;
		Set<Integer> setB = new HashSet<>();
		for (int x : B)
			setB.add(x);

		for (int x : A)
			if (setB.contains(x + diff))
				return new int[] { x, x + diff };
		return null;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(fairCandySwap(new int[] { 2 }, new int[] { 1, 3 })));

	}

}
