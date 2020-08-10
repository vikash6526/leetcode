package leetcode.project;

public class DistanceBetweenBusStops {
	public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int totalDistance = 0;
		for (int i = 0; i < distance.length; i++) {
			totalDistance = totalDistance + distance[i];
		}
		int newDist = 0;
		int totalPath = 0;
		if (destination < start) {
			totalPath = distance.length - start + destination;
		} else
			totalPath = destination - start;
		for (int i = start; totalPath > 0; i++) {
			if (i == distance.length)
				i = i % distance.length;
			newDist = newDist + distance[i];
			totalPath--;
		}
		return Math.min(newDist, totalDistance - newDist);
	}

	public static void main(String[] args) {
		int[] distance = new int[] { 6, 47, 48, 31, 10, 27, 46, 33, 52, 33, 38, 25, 32, 45, 36, 3, 0, 33, 22, 53, 8, 13,
				18, 1, 44, 41, 14, 5, 38, 25, 48 };
		int[] dist = new int[] { 1, 2, 3, 4 };
		System.out.println(distanceBetweenBusStops(distance, 22, 0));

	}

}
