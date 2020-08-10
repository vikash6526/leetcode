package leetcode.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class QueueReconstructionByHeight {
	public static int[][] reconstructQueue1(int[][] people) {
		int[][] arr = new int[people.length][2];
		List<int[]> list = new ArrayList<>();
		Map<Integer, Set<Integer>> map = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < people.length; i++) {
			if (!map.containsKey(people[i][0])) {
				Set<Integer> peopleList = new TreeSet<>();
				peopleList.add(people[i][1]);
				map.put(people[i][0], peopleList);
			} else
				map.get(people[i][0]).add(people[i][1]);
		}
		for (Integer key : map.keySet()) {
			Set<Integer> data = map.get(key);
			for (Integer pep : data) {
				int[] newArr = new int[2];
				newArr[0] = key;
				newArr[1] = pep;
				list.add(pep, newArr);
			}
		}
		int k = 0;
		for (int[] peopleList : list) {
			arr[k++] = peopleList;
		}

		return arr;
	}

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < people.length; i++) {
			list.add(people[i][1], people[i]);
		}
		return list.toArray(people);
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 9, 0 }, { 7, 0 }, { 1, 9 }, { 3, 0 }, { 2, 7 }, { 5, 3 }, { 6, 0 }, { 3, 4 },
				{ 6, 2 }, { 5, 2 } };
		System.out.println(Arrays.toString(reconstructQueue1(arr)));
	}

}
