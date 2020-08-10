package leetcode.project;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = nums[index] * -1;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				int missing = i + 1;
				list.add(missing);
			}
		}
		return list;
	}

	public static List<Integer> findDisappearedNumbers1(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int[] arr = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]]++;
		}
		for (int i = 1; i <= nums.length; i++) {
			if (arr[i] == 0)
				list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));

	}

}
