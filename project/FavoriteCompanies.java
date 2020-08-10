package leetcode.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteCompanies {
	public static List<Integer> peopleIndexes1(List<List<String>> favoriteCompanies) {
		List<Integer> index = new ArrayList<>();
		Map<Integer, List<String>> map = new HashMap<>();
		for (int i = 0; i < favoriteCompanies.size(); i++) {
			for (String childStr : favoriteCompanies.get(i)) {
				if (!map.containsKey(i)) {
					List<String> list = new ArrayList<>();
					list.add(childStr);
					map.put(i, list);
				} else
					map.get(i).add(childStr);
			}
		}
		return index;
	}

	public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
		List<Integer> index = new ArrayList<>();
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < favoriteCompanies.size(); i++) {
			for (String childStr : favoriteCompanies.get(i)) {
				if (!map.containsKey(childStr)) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					map.put(childStr, list);
				} else
					map.get(childStr).add(i);
			}
		}
		for (int i = 0; i < favoriteCompanies.size(); i++) {
			for (String childStr : favoriteCompanies.get(i)) {
				int ind = map.get(childStr).get(0);
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
