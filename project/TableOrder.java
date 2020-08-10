package leetcode.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class TableOrder {

	public static List<List<String>> tableOrder(List<List<String>> list) {
		List<String> list1 = new ArrayList<String>();
		SortedMap<Integer, Map<String, Integer>> map = new TreeMap<Integer, Map<String, Integer>>();
		list1.add("Table");
		for (List<String> s : list) {
			if (!list1.contains(s.get(2)))
				list1.add(s.get(2));
		}
		Collections.sort(list1.subList(1, list1.size() - 1));
		for (List<String> s : list) {
			Map<String, Integer> childmap = new HashMap<>();
			for (int i = 1; i < list1.size(); i++) {
				childmap.put(list1.get(i), 0);
			}
			map.put(Integer.parseInt(s.get(1)), childmap);
		}

		for (List<String> s : list) {
			int count = map.get(Integer.parseInt(s.get(1))).get(s.get(2)) + 1;
			map.get(Integer.parseInt(s.get(1))).put(s.get(2), count);
		}

		List<List<String>> listResult = new ArrayList<>();
		listResult.add(list1);

		for (Entry<Integer, Map<String, Integer>> s : map.entrySet()) {
			List<String> list2 = new ArrayList<>();
			list2.add(String.valueOf(s.getKey()));
			Map<String, Integer> child = s.getValue();
			for (String str : list1) {
				if (child.get(str) != null)
					list2.add(String.valueOf(child.get(str)));
			}
			listResult.add(list2);
		}
		return listResult;
	}

	public static void main(String[] args) {

		List<List<String>> list = new ArrayList<>();
		List<String> childlist = new ArrayList<>();
		childlist.add("James");
		childlist.add("12");
		childlist.add("Fried Chicken");
		list.add(childlist);
		List<String> childlist1 = new ArrayList<>();
		childlist1.add("Ratesh");
		childlist1.add("12");
		childlist1.add("Fried Chicken");
		list.add(childlist1);
		List<String> childlist2 = new ArrayList<>();
		childlist2.add("Amadeus");
		childlist2.add("3");
		childlist2.add("Fried Chicken");
		list.add(childlist2);
		List<String> childlist3 = new ArrayList<>();
		childlist3.add("Adam");
		childlist3.add("1");
		childlist3.add("Canadian Waffles");
		list.add(childlist3);
		List<String> childlist4 = new ArrayList<>();
		childlist4.add("Adam");
		childlist4.add("1");
		childlist4.add("Canadian Waffles");
		list.add(childlist4);

		tableOrder(list);

	}
}
