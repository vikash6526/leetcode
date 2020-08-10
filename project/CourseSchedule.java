package leetcode.project;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	static int[] visited;

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		visited = new int[numCourses];
		List<Integer>[] graph = new ArrayList[numCourses];
		for (int i = 0; i <= numCourses; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] data : prerequisites) {
			graph[data[0]].add(data[1]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0 && !dfs(graph, visited, i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean dfs(List<Integer>[] graph, int[] visited, int i) {
		visited[i] = 1;
		for (Integer courses : graph[i])
			if (dfs(graph, visited, courses))
				return false;
		visited[i] = 2;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}

}
