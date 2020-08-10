package leetcode.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

public class CommonCharacters {

	public static List<String> commonChars(String[] A) {
		int[][] aMatrix = new int[A.length][26];
		for (int i = 0; i < A.length; i++) {
			String word = A[i];
			for (char a : word.toCharArray()) {
				int col = (int) a - 'a';
				aMatrix[i][col]++;
			}
		}
		List<String> result = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			int min = Integer.MAX_VALUE;
			boolean include = true;
			for (int j = 0; j < A.length; j++) {
				if (aMatrix[j][i] != 0) {
					min = Math.min(min, aMatrix[j][i]);
				} else {
					include = false;
					break;
				}
			}
			if (include) {
				while (min > 0) {
					result.add(Character.toString((char) (i + 'a')));
					min--;
				}
			}
		}
		return result;
	}

	public static List<String> commonChars1(String[] A) {
		List<String> result = new ArrayList<>();
		String leastStr = "";
		int leastLength = Integer.MAX_VALUE;
		for (String str : A) {
			if (str.length() < leastLength) {
				leastLength = str.length();
				leastStr = str;
			}
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < leastStr.length(); i++) {
			map.put(leastStr.charAt(i), map.getOrDefault(leastStr.charAt(i), 0) + 1);
		}
		for (char ch : map.keySet()) {
			int totalcount = 0;
			for (String str : A) {
				Matcher matcher = Pattern.compile(str.valueOf(ch)).matcher(str);
				int count = 0;
				while (matcher.find())
					count++;
				if (count != 0) {
					totalcount++;
					map.put(ch, Math.min(map.get(ch), count));
				}
			}
			if (totalcount == A.length)
				while (map.get(ch) > 0) {
					result.add(Character.toString(ch));
					map.put(ch, map.get(ch) - 1);
				}
		}
		return result;
	}

	public static void main(String[] args) {
		commonChars(new String[] { "bella", "label", "roller" });

	}

}
