package leetcode.project;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate1(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]))
				map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			else
				map.put(nums[i], 1);
		}
		for (Integer data : map.values()) {
			if (data > 1)
				return true;
		}
		return false;

	}

	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int data : nums) {
			if (set.contains(data))
				return true;
			else
				set.add(data);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));

	}

}
