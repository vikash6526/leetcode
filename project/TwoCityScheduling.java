package leetcode.project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TwoCityScheduling {
	public static int twoCitySchedCost1(int[][] costs) {
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for (int i = 0; i < costs.length; i++) {
			map.put(i, costs[i][1] - costs[i][0]);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.offer(entry);
		}
		int length = 0;
		int totalCost = 0;
		while (!pq.isEmpty()) {
			if (length < costs.length / 2)
				totalCost += costs[pq.poll().getKey()][1];
			else
				totalCost += costs[pq.poll().getKey()][0];
			length++;
		}
		return totalCost;
	}

	public static int twoCitySchedCost(int[][] costs) {
		int N = costs.length / 2;
		int[] refund = new int[N * 2];
		int minCost = 0, index = 0;
		for (int[] cost : costs) {
			refund[index++] = cost[1] - cost[0];
			minCost += cost[0];
		}
		Arrays.sort(refund);
		for (int i = 0; i < N; i++) {
			minCost += refund[i];
		}
		return minCost;
	}

	public static void main(String[] args) {
		int[][] costs = new int[][] { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 },
				{ 577, 469 } };
		System.out.println(twoCitySchedCost(costs));

	}

}
