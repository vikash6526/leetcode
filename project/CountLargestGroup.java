package leetcode.project;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {
	public static int countLargestGroupArray(int n) {

		int[] arr = new int[37];
		int maxSize = 0;
		for (int i = 1; i <= n; i++) {
			int curr = digitSum(i);
			arr[curr]++;
			maxSize = Math.max(maxSize, arr[curr]);
		}
		int res = 0;
		for (int value : arr) {
			if (value == maxSize)
				res++;
		}
		return res;

	}

	public static int countLargestGroupHashMap(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxSize = 0;
		for (int i = 1; i <= n; i++) {
			int curr = digitSum(i);
			map.put(curr, map.getOrDefault(curr, 0) + 1);
			maxSize = Math.max(maxSize, map.get(curr));
		}
		int num = 0;
		for (Integer value : map.keySet()) {
			if (map.get(value) == maxSize)
				num++;
		}
		return num;
	}

	private static int digitSum(int n) {
		int res = 0;
		while (n > 0) {
			res += (n % 10);
			n /= 10;
		}
		return res;
	}

	public static void main(String[] args) {

		System.out.println(countLargestGroupArray(300));

	}

}
