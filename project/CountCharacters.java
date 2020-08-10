package leetcode.project;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountCharacters {
	public static int countCharacters(String[] words, String chars) {
		int length = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < chars.length(); i++) {
			map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i), 0) + 1);
		}
		for (String str : words) {
			Map<Character, Integer> childMap = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				childMap.put(str.charAt(i), childMap.getOrDefault(str.charAt(i), 0) + 1);
			}
			int j = 0;
			for (Character ch : childMap.keySet()) {
				if (!map.containsKey(ch) || childMap.get(ch) > map.get(ch))
					break;
				else
					j += childMap.get(ch);
			}
			if (j == str.length())
				length = length + str.length();
		}

		return length;
	}

	public static void main(String[] args) {
		System.out.println('t' - 'a');
		int[] count = new int[26];
		String s1 = "cat";
		String s2 = "atach";
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s2.length(); i++) {
			count[s2.charAt(i) - 'a']--;
		}
		System.out.println(countCharacters(new String[] { "hello", "world", "leetcode" }, "welldonehoneyr"));

	}

}
