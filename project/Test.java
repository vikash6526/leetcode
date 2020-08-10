package leetcode.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Test {
	public static int minReorder(int n, int[][] connections) {
		int count = 0;
		for (int[] data : connections) {
			if (data[1] > data[0])
				count++;
		}
		return count;
	}

	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		int width = 0;
		int hight = 0;
		Arrays.sort(horizontalCuts);
		hight = Math.max(horizontalCuts[0] - 0, h - horizontalCuts[horizontalCuts.length - 1]);
		for (int i = 1; i < horizontalCuts.length; i++) {
			hight = Math.max(hight, horizontalCuts[i] - horizontalCuts[i - 1]);
		}
		Arrays.sort(verticalCuts);
		width = Math.max(verticalCuts[0] - 0, w - verticalCuts[verticalCuts.length - 1]);
		for (int i = 1; i < verticalCuts.length; i++) {
			width = Math.max(width, verticalCuts[i] - verticalCuts[i - 1]);
		}
		return hight * width;
	}

	public static int maxProduct(int[] nums) {
		Arrays.sort(nums);
		int product = (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
		return product;
	}

	public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int count = 0;
		for (int i = 0; i < startTime.length; i++) {
			if (queryTime >= startTime[i] && queryTime <= endTime[i])
				count++;
		}

		return count;
	}

	public static String arrangeWords1(String text) {
		String result = "";

		return result;
	}

	public static String arrangeWords(String text) {
		String[] str = text.split(" ");
		TreeMap<Integer, List<String>> map = new TreeMap<>();
		TreeMap<String, List<Integer>> index = new TreeMap<>();
		for (int i = 0; i < str.length; i++) {
			if (!map.containsKey(str[i].length())) {
				List<String> listString = new ArrayList<>();
				listString.add(str[i]);
				map.put(str[i].length(), listString);
			} else {
				map.get(str[i].length()).add(str[i]);
			}
			if (!index.containsKey(str[i])) {
				List<Integer> listInteger = new ArrayList<>();
				listInteger.add(i);
				index.put(str[i], listInteger);
			} else {
				index.get(str[i]).add(i);
			}
		}
		String result = "";
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		for (List<String> lStr : map.values()) {
			if (lStr.size() > 1) {
				for (String childStr : lStr) {
					int indexStr = index.get(childStr).get(0);
					treeMap.put(indexStr, childStr);
					index.get(childStr).remove(0);
				}
				for (String str1 : treeMap.values()) {
					result = result + str1 + " ";
				}
				treeMap.clear();
			} else {
				result = result + lStr.get(0) + " ";
			}
		}
		result = result.substring(0, 1).toUpperCase() + result.substring(1, result.length()).toLowerCase();

		return result.trim();
	}

	public static void main(String[] args) {
//		int[] startTime = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		int[] endTime = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10 };
//		System.out.println(busyStudent(startTime, endTime, 5));
		// String str = "B a ba bbba b aaba aaaa ba a bbb a bbbb baa baaa baa bb bab bab
		// a aaba ba baa aaab aaa baab babb b aaab bb bbba b ab ba a b a bbba ab aaab bb
		// b a a aab b a aaa b ba a baaa a bb b bbbb a bbab b aa b aabb aaba a bbaa abb
		// a a ba bbb bbab b baba aa a abbb b aa bb aba aa abba baa aa aa babb bbab abaa
		// a a aa ba a b a aa ab bbab ab aaab aaba ab bbaa b bb aabb b a bbab aaba a ba
		// bab ab bb abab bbba aba a b bb a aabb bbba bb aaab bab abbb b aaaa abbb b aa
		// b bba a aaaa baba b aa ab a aaa b bab a aaa abba baab ab abb abab bbbb ba b
		// aaba aaaa aa aaa ba a baa ba bb bba ab baab baba abb bb b ba a bb a ab bbb ab
		// bb b aab aaab bba b baa aaa ab a aba bbbb abb abbb baaa";
		// String str = "B a ba bbba b aaba aaaa ba a bbb a";
		// System.out.println(arrangeWords(str));
//		String str = "hello how are you";
//		System.out.println(str.substring(0, 1).toUpperCase() + str.substring(1, str.length()).toLowerCase());
		int[] horizontalCuts = new int[] { 3, 1, 2 };
		int[] verticalCuts = new int[] { 1 };
		//System.out.println(maxArea(5, 2, horizontalCuts, verticalCuts)); 716637737
		int i=47483647;
		System.out.println((long)i*i%1000000007);
		String str="<p>true</p>";
		str=Boolean.toString(str.contains("true"));
		System.out.println(str);
	}
}
