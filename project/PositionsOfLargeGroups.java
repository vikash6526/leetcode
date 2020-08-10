package leetcode.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionsOfLargeGroups {
	public static List<List<Integer>> largeGroupPositions1(String S) {
		Map<Character, int[]> map = new HashMap<>();
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < S.length(); i++) {
			int[] range = new int[2];
			range[0] = i;
			char ch = S.charAt(i);
			int j = i + 1;
			while (j < S.length() && ch == S.charAt(j)) {
				j++;
			}
			range[1] = j - 1;
			i = j - 1;
			if (map.containsKey(ch)) {
				int[] arr = map.get(ch);
				if ((arr[1] - arr[0]) < range[1] - range[0])
					map.put(ch, range);
			} else if (!map.containsKey(ch) && range[1] - range[0] + 1 >= 3) {
				map.put(ch, range);
			}
		}

		for (int[] indexes : map.values()) {
			if (indexes[1] - indexes[0] + 1 >= 3) {
				List<Integer> childList = new ArrayList<>();
				childList.add(indexes[0]);
				childList.add(indexes[1]);
				list.add(childList);
			}
		}
		return list;
	}

	public static List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			int j = i + 1;
			while (j < S.length() && ch == S.charAt(j)) {
				j++;
			}
			if (j - i >= 3) {
				List<Integer> childList = new ArrayList<>();
				childList.add(i);
				childList.add(j - 1);
				list.add(childList);
			}
			i = j - 1;
		}
		return list;
	}

	public static void main(String[] args) {
		largeGroupPositions("abcdddeeeeaabbbcd");

	}

}
