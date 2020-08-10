package leetcode.project;

import java.util.ArrayList;
import java.util.List;

public class DecompressRLElist {

	public static int[] decompressRLElist(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length - 1; i += 2) {
			int j = nums[i];
			while (j > 0) {
				list.add(nums[i + 1]);
			}
		}
		int[] arr = new int[list.size()];
		int k = 0;
		for (Integer data : list) {
			arr[k] = data;
			k++;
		}
		return arr;
	}

	public static void main(String[] args) {
		decompressRLElist(new int[] { 1, 2, 3, 4 });

	}

}
