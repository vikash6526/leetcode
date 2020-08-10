package leetcode.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDiagonalOrder {

	public static int[] findDiagonalOrder(List<List<Integer>> nums) {
		int max_key = 0, n = 0, i = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int r = nums.size() - 1; r >= 0; r--) {
			for (int c = 0; c < nums.get(r).size(); c++) {
				map.putIfAbsent(r + c, new ArrayList<>());
				map.get(r + c).add(nums.get(r).get(c));
				max_key = Math.max(max_key, r + c);
				n++;
			}
		}

		int[] result = new int[n];
		for (int key = 0; key <= max_key; ++key) {
			List<Integer> value = map.get(key);
			if (value == null)
				continue;
			for (int v : value)
				result[i++] = v;
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list.add(list1);
		List<Integer> list2 = new ArrayList<>();
		list2.add(6);
		list2.add(7);
		list.add(list2);
		List<Integer> list3 = new ArrayList<>();
		list3.add(8);
		list.add(list3);
		List<Integer> list4 = new ArrayList<>();
		list4.add(9);
		list4.add(10);
		list4.add(11);
		list.add(list4);
		List<Integer> list5 = new ArrayList<>();
		list5.add(12);
		list5.add(13);
		list5.add(14);
		list5.add(15);
		list5.add(16);
		list.add(list5);

		findDiagonalOrder(list);

	}

}
