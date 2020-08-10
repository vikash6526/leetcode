package leetcode.project;

import java.util.HashMap;
import java.util.Map;

public class FrequencyGame {
	public static int LargButMinFreq(int arr[], int n) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
			}
		}
		int minFreq = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (minFreq > entry.getValue()) {
				maxValue = Math.max(maxValue, entry.getKey());
			}
		}
		return maxValue;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 2, 5, 50, 1 };
		System.out.println(LargButMinFreq(arr, 5));
	}

}
