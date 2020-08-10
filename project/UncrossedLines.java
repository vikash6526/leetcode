package leetcode.project;

public class UncrossedLines {
	public static int maxUncrossedLines1(int[] A, int[] B) {
		int[][] dp = new int[A.length][B.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				dp[i][j] = -1;
			}
		}

		return lcs(A, B, 0, 0, dp);
	}

	public static int lcs(int[] A, int[] B, int i, int j, int[][] dp) {
		if (i == A.length || j == B.length) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (A[i] == B[j]) {
			return dp[i][j] = 1 + lcs(A, B, i + 1, j + 1, dp);
		} else {
			return dp[i][j] = Math.max(lcs(A, B, i + 1, j, dp), lcs(A, B, i, j + 1, dp));
		}
	}

	public static int maxUncrossedLines(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];

		for (int i = A.length - 1; i >= 0; i--) {
			for (int j = B.length - 1; j >= 0; j--) {
				dp[i][j] = (A[i] == B[j] ? dp[i + 1][j + 1] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]));
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 1, 3, 5, 3, 3, 5, 5, 1, 1 };
		int[] B = new int[] { 2, 3, 2, 1, 3, 5, 3, 2, 2, 1 };
		System.out.println(maxUncrossedLines(A, B));
	}

}
