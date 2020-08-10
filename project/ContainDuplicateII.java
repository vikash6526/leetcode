package leetcode.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(nums[i], list);
			} else
				map.get(nums[i]).add(i);
		}
		for (List<Integer> list : map.values()) {
			if (list.size() > 1) {
				int i = 1;
				while (i < list.size()) {
					if (list.get(i) - list.get(i - 1) <= k)
						return true;
					i++;
				}
			}
		}
		return false;
	}

	public boolean containsNearbyDuplicate1(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (i - map.get(nums[i]) <= k) {
					return true;
				}
			}
			map.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));

	}

}
