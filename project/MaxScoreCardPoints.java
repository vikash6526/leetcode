package leetcode.project;

public class MaxScoreCardPoints {
	public static int maxScore(int[] cardPoints, int k) {
		int size = cardPoints.length;
		int sumPrifix[] = new int[100005];
		sumPrifix[0] = 0;
		for (int i = 0; i < size; i++) {
			sumPrifix[i + 1] = sumPrifix[i] + cardPoints[i];
		}
		int max_sum = 0;
		for (int i = 0; i <= k; i++) {
			max_sum = Math.max(max_sum, sumPrifix[i] + sumPrifix[size] - sumPrifix[size - k + i]);
		}
		return max_sum;
	}

	public static void main(String[] args) {
		System.out.println(maxScore(new int[] { 1, 79, 80, 1, 1, 1, 200, 1 }, 3));

	}

}
