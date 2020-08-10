package leetcode.project;

public class MaxScoreString {

	public static int maxScore(String s) {
		int j = 0;
		int max_sum = 0;
		while (j < s.length() - 1) {
			int b1 = 0;
			int b2 = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (i <= j) {
					if (c == '0')
						b1++;
				} else {
					if (c == '1')
						b2++;
				}
			}
			j++;
			max_sum = Math.max(max_sum, b1 + b2);
		}
		return max_sum;
	}

	public static void main(String[] args) {
		System.out.println(maxScore("011101"));

	}

}
