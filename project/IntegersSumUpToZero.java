package leetcode.project;

public class IntegersSumUpToZero {

	public static int[] sumZero(int n) {
		int[] result = new int[n];
		int mid = n / 2;
		if (n == 1)
			result[0] = 0;
		if (n % 2 != 0) {
			for (int i = 0; i < n; i++) {
				result[i] = i - mid;
			}
		} else {
			for (int i = 0; i <= mid - 1; i++)
				result[i] = i - mid;
			for (int i = mid; i < n; i++)
				result[i] = i - mid + 1;
		}

		return result;
	}

	public static void main(String[] args) {
		sumZero(4);
	}

}
