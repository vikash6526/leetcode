package leetcode.project;

import java.util.Arrays;

public class LastStoneWeight {

	public static int lastStoneWeight(int[] stones) {
		int length = stones.length;
		while (length > 1) {
			Arrays.sort(stones, 0, length);
			int diff = stones[length - 1] - stones[length - 2];
			if (diff > 0) {
				stones[length - 2] = diff;
				length--;
			} else {
				length = length - 2;
			}

		}
		return length == 0 ? 0 : stones[length - 1];
	}

	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));

	}

}
