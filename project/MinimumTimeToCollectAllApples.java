package leetcode.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumTimeToCollectAllApples {
	HashMap<Integer, ArrayList<Integer>> g;
	int[] count;
	boolean[] ha;
	int ans = 0;

	public int minTime1(int n, int[][] edges, List<Boolean> hasApple) {
		g = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			g.put(i, new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			g.get(u).add(v);
			g.get(v).add(u);
		}
		count = new int[n];

		ha = new boolean[n];
		for (int i = 0; i < n; i++) {
			ha[i] = hasApple.get(i);
		}

		dfs(0, -1);

		ans = 0;
		dfs2(0, -1);
		return ans;
	}

	void dfs(int u, int p) {

		if (ha[u]) {
			count[u]++;
		}

		for (int v : g.get(u)) {
			if (v == p)
				continue;
			dfs(v, u);
			count[u] += count[v];
		}
	}

	void dfs2(int u, int p) {
		if (u != 0)
			ans += 2;
		for (int v : g.get(u)) {
			if (v == p)
				continue;
			if (count[v] == 0)
				continue;
			dfs2(v, u);
		}
	}

	public int minTime2(int n, int[][] edges, List<Boolean> hasApple) {

		Map<Integer, List<Integer>> graph = createGraph(edges); // to store the graph
		Map<Integer, Boolean> visited = new HashMap<>();

		return dfs(graph, 0, hasApple, 0, visited); // cost of reaching the root is 0. For all others, its 2.

	}

	private int dfs(Map<Integer, List<Integer>> graph, int node, List<Boolean> hasApple, int myCost,
			Map<Integer, Boolean> visited) {
		Boolean v = visited.getOrDefault(node, false);
		if (v) {
			return 0;
		}
		visited.put(node, true);

		int childrenCost = 0; // cost of traversing all children.

		for (int n : graph.getOrDefault(node, new ArrayList<>())) {
			childrenCost += dfs(graph, n, hasApple, 2, visited); // check recursively for all apples in subtrees.
		}

		if (childrenCost == 0 && hasApple.get(node) == false) {
			// If no child has apples, then we won't traverse the subtree, so cost will be
			// zero.
			// similarly, if current node also does not have the apple, we won't traverse
			// this branch at all, so cost will be zero.
			return 0;
		}

		return childrenCost + myCost;
	}

	private Map<Integer, List<Integer>> createGraph(int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < edges.length; i++) {
			List<Integer> list = graph.getOrDefault(edges[i][0], new ArrayList<>()); // Adjecency list representation.
			list.add(edges[i][1]);
			graph.put(edges[i][0], list);

			list = graph.getOrDefault(edges[i][1], new ArrayList<>()); // Adjecency list representation.
			list.add(edges[i][0]);
			graph.put(edges[i][1], list);
		}

		return graph;
	}

	int count1 = 0;

	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++)
			graph.add(new ArrayList<>());
		for (int[] e : edges) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}

		dfs(graph, 0, hasApple, new boolean[n]);
		return count1;
	}

	private boolean dfs(List<List<Integer>> graph, int curNode, List<Boolean> hasA, boolean[] visited) {
		if (visited[curNode])
			return false;

		visited[curNode] = true;
		boolean res = hasA.get(curNode);
		for (int i = 0; i < graph.get(curNode).size(); i++) {
			if (dfs(graph, graph.get(curNode).get(i), hasA, visited)) {
				count1 += 2;
				res = true;
			}
		}

		return res;
	}
	
	public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] == nums[m ^ 1]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return nums[h];
    }

	public static void main(String[] args) {
		List<Boolean> list = new ArrayList<>();
		list.add(false);
		list.add(false);
		list.add(true);
		list.add(false);
		list.add(true);
		list.add(true);
		list.add(false);
		MinimumTimeToCollectAllApples mta = new MinimumTimeToCollectAllApples();
//		System.out.println(
//				mta.minTime(7, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } }, list));

	}

}
