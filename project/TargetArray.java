package leetcode.project;

import java.util.ArrayList;
import java.util.List;

public class TargetArray {

	public static int[] createTargetArray(int[] nums, int[] index) {
		int[] result = new int[nums.length];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(index[i], nums[i]);
		}
		int i = 0;
		for (Integer data : list) {
			result[i++] = data;
		}

		return result;
	}

	public static void main(String[] args) {
		createTargetArray(new int[] { 0, 1, 2, 3, 4 }, new int[] { 0, 1, 2, 2, 1 });

	}

}
