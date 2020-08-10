package leetcode.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContainsDuplicateIII {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		List<Integer> set = new ArrayList<>();

		Map<Integer, List<Integer>> map = new TreeMap<>();
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
		for (int i = 0; i < map.size(); i++) {

		}
		return false;
	}

	public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
		TreeSet<Long> set = new TreeSet<Long>();

		for (int i = 0; i < nums.length; i++) {

			long val = (long) nums[i];
			Long floor = set.floor(val);

			if (floor != null && val - floor <= t)
				return true;
			Long ceil = set.ceiling(val);

			if (ceil != null && ceil - val <= t)
				return true;

			set.add(val);
			if (set.size() > k) {

				set.remove((long) nums[i - k]);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate1(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));
	}

}
