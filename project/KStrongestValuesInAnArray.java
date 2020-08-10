package leetcode.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KStrongestValuesInAnArray {
	public static int[] getStrongest(int[] arr, int k) {
		int[] result = new int[k];
		int[] newArr = new int[arr.length];
		int j = 0;
		for (int data : arr)
			newArr[j++] = data;
		Arrays.sort(newArr);
		int m = newArr[(newArr.length - 1) / 2];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int diff = Math.abs(arr[i] - m);
			if (!map.containsKey(diff)) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[i]);
				map.put(diff, list);
			} else
				map.get(diff).add(arr[i]);
		}
		for (Integer key : map.keySet()) {
			List<Integer> data = map.get(key);
			Collections.sort(data, Collections.reverseOrder());
			map.put(key, data);
		}
		PriorityQueue<Map.Entry<Integer, List<Integer>>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			pq.offer(entry);
		}
		int l = 0;
		while (!pq.isEmpty()) {
			Map.Entry<Integer, List<Integer>> entry = pq.poll();
			for (Integer listValues : entry.getValue()) {
				if (l == k)
					break;
				result[l++] = listValues;
			}
			if (l == k)
				break;
		}
		return result;
	}

	public static void main(String[] args) {
		getStrongest(new int[] { -7, 22, 17, 3 }, 2);

	}

}
