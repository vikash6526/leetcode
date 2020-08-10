package leetcode.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleFavoriteCompanies {

	public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
		List<Integer> result = new ArrayList<>();
		int i = 0;
		Map<String, List<Integer>> map = new HashMap<>();
		for (List<String> listStr : favoriteCompanies) {
			for (String str : listStr) {
				if (!map.containsKey(str)) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					map.put(str, list);
				} else
					map.get(str).add(i);
			}
			i++;
		}
		for (List<Integer> list : map.values()) {
			if (list.size() == 1)
				result.add(list.get(0));
		}
		i = 0;
		Collections.sort(result);
		return result;
	}

	public static List<Integer> peopleIndexes1(List<List<String>> favoriteCompanies) {
		List<Integer> result = new ArrayList<>();
		int i = 0;
		Map<String, List<Integer>> map = new HashMap<>();
		for (List<String> listStr : favoriteCompanies) {
			for (String str : listStr) {
				if (!map.containsKey(str)) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					map.put(str, list);
				} else
					map.get(str).add(i);
			}
			i++;
		}
		for (List<Integer> list : map.values()) {
			if (list.size() == 1)
				result.add(list.get(0));
		}
		Collections.sort(result);
		return result;
	}

	public static void main(String[] args) {
		List<List<String>> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		list1.add("leetcode");
		list1.add("google");
		list1.add("facebook");
		list.add(list1);

		List<String> list2 = new ArrayList<>();
		list2.add("google");
		list2.add("microsoft");
		list.add(list2);

		List<String> list3 = new ArrayList<>();
		list3.add("google");
		list3.add("facebook");
		list.add(list3);

		List<String> list4 = new ArrayList<>();
		list4.add("google");
		list.add(list4);

		List<String> list5 = new ArrayList<>();
		list5.add("amazon");
		list.add(list5);

		System.out.println(peopleIndexes(list));
	}

}
