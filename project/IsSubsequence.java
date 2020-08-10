package leetcode.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence {
	public static boolean isSubsequence1(String s, String t) {
		int index = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int newIndex = 0;
			if (map.containsKey(ch))
				newIndex = t.indexOf(ch, map.get(ch) + 1);
			else
				newIndex = t.indexOf(ch);
			if (newIndex > index) {
				map.put(ch, newIndex);
				index = newIndex;
			} else
				return false;
		}
		return index == -1 ? false : true;
	}

	public static boolean isSubsequence(String s, String t) {
		int index = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int newIndex = t.indexOf(ch, index + 1);
			if (newIndex > index) {
				index = newIndex;
			} else
				return false;
		}
		return index == -1 ? false : true;
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence("leeeeetcode", "leeeeeetcode"));

	}

}
