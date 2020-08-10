package leetcode.project;

public class FibonacciNumber {

	// recursion
	public static int fibRecursion(int N) {
		if (N <= 1)
			return N;
		return fibRecursion(N - 1) + fibRecursion(N - 2);
	}

	// dynamic programing
	public static int fibDynamic(int N) {
		int[] arr = new int[N + 2];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		return arr[N];
	}

	public static void main(String[] args) {
		System.out.println(fibDynamic(9));

	}

}
