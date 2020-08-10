package leetcode.project;

public class IsPerfectSquare {
	public static boolean isPerfectSquare(int num) {
		int left = 1, right = num / 2 + 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid * mid == num)
				return true;
			if (mid * mid < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		long i = 2147483647;
		System.out.println(10 * i + 10);
		long j = 536870912;
		System.out.println((j * j) % (2 * i + 2));

		System.out.println(isPerfectSquare(2147483647));

	}

}
