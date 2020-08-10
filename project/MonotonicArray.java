package leetcode.project;

public class MonotonicArray {
	public static boolean isMonotonic(int[] A) {
		int incs = 0;
		int decs = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i + 1] - A[i] >= 0)
				incs++;
			if (A[i + 1] - A[i] <= 0)
				decs++;
		}
		if (incs == A.length - 1 || decs == A.length - 1)
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] { 1,1,1}));

	}

}
