package leetcode.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KClosestPointsToOrigin {
	public static int[][] kClosest(int[][] points, int K) {
		int[][] result = new int[K][2];
		Map<Integer, List<Integer>> map = new TreeMap<>();
		int i = 0;
		for (int[] data : points) {
			int distance = (int) Math.pow(data[0], 2) + (int) Math.pow(data[1], 2);
			if (!map.containsKey(distance)) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(distance, list);
			} else
				map.get(distance).add(i);
			i++;
		}
		int limit = 0;
		for (List<Integer> data : map.values()) {
			for (Integer dis : data) {
				if (limit == K)
					break;
				result[limit++] = points[dis];
			}
			if (limit == K)
				break;
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		System.out.println(Arrays.toString(kClosest(arr, 2)));
	}

}
