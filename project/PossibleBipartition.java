package leetcode.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PossibleBipartition {
	static ArrayList<Integer>[] graph;
	static Map<Integer, Integer> color;

	public static boolean possibleBipartition(int N, int[][] dislikes) {
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i)
			graph[i] = new ArrayList<>();

		for (int[] edge : dislikes) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}

		color = new HashMap<>();
		for (int node = 1; node <= N; ++node)
			if (!color.containsKey(node) && !dfs(node, 0))
				return false;
		return true;
	}

	public static boolean dfs(int node, int c) {
		if (color.containsKey(node))
			return color.get(node) == c;
		color.put(node, c);

		for (int nei : graph[node])
			if (!dfs(nei, c ^ 1))
				return false;
		return true;
	}

	public static boolean possibleBipartition1(int N, int[][] dislikes) {
		Set<Integer> set = new TreeSet<>();
		Map<Integer, TreeSet<Integer>> map = new HashMap<>();
		for (int[] data : dislikes) {
			set.add(data[0]);
			set.add(data[1]);
			if (!map.containsKey(data[0])) {
				TreeSet<Integer> treeSet = new TreeSet<>();
				treeSet.add(data[1]);
				map.put(data[0], treeSet);
			} else
				map.get(data[0]).add(data[1]);
			if (!map.containsKey(data[1])) {
				TreeSet<Integer> treeSet = new TreeSet<>();
				treeSet.add(data[0]);
				map.put(data[1], treeSet);
			} else
				map.get(data[1]).add(data[0]);
		}
		List<TreeSet<Integer>> list = new ArrayList<>();
		for (Integer key : map.keySet()) {
			TreeSet<Integer> childTree = new TreeSet<>();

		}
		return false;
	}

	public static void main(String[] args) {
		int[][] dislikes = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } };
		System.out.println(possibleBipartition(4, dislikes));
	}

}
