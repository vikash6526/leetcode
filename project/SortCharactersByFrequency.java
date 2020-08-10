package leetcode.project;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SortCharactersByFrequency {
	public static String frequencySort(String s) {

		if (s == null || s.length() == 0)
			return "";

		Map<Character, Integer> map = new HashMap<>();
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.offer(entry);
		}

		char[] arr = new char[s.length()];
		int count = 0;

		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> entry = pq.poll();
			char ch = entry.getKey();
			for (int i = 0; i < entry.getValue(); i++) {
				arr[count++] = ch;
			}
		}

		return new String(arr);
	}

	public static String frequencySort1(String s) {
		String result = "";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), 1);
			else
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		Map<Integer, String> treeMap = new TreeMap<>();
		for (Character ch : map.keySet()) {
			if (!treeMap.containsKey(map.get(ch)))
				treeMap.put(map.get(ch), ch.toString());
			else {
				treeMap.put(map.get(ch), treeMap.getOrDefault(map.get(ch), "") + ch);
			}
		}
		for (Integer data : treeMap.keySet()) {
			String str = treeMap.get(data);
			if (data > 1 && str.length() > 1) {
				for (int i = 0; i < str.length(); i++) {
					int limit = data;
					while (limit > 0) {
						result = str.charAt(i) + result;
						limit--;
					}
				}
			} else if (data == 1)
				result = str + result;
			else if (data > 1 && str.length() == 1) {
				while (data > 0) {
					result = str + result;
					data--;
				}
			}
		}
		return result;
	}
	public void priorityQueue() {
		// System.out.println(frequencySort(str));
				PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
				pq.offer(3);
				pq.offer(7);
				pq.offer(1);
				pq.offer(2);
				while (!pq.isEmpty())
					System.out.println(pq.poll());
	}

	public static void main(String[] args) {
		String str = "tree";
		// System.out.println(frequencySort(str));
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		pq.offer(3);
		pq.offer(7);
		pq.offer(1);
		pq.offer(2);
		while (!pq.isEmpty())
			System.out.println(pq.poll());
	}

}