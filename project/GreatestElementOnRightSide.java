package leetcode.project;

import java.util.Arrays;

public class GreatestElementOnRightSide {

	public static int[] replaceElements(int[] arr) {
		int max = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = max;
			max = Math.max(max, temp);
		}
		arr[arr.length - 1] = -1;

		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(replaceElements(new int[] { 17, 18, 5, 4, 6, 1 })));

	}

}
