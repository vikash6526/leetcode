package leetcode.project;

public class ArrangingCoins {
	public static int arrangeCoins(int n) {
		int count = 0;
		int steps=n;
		for (int i = 1; i <= steps / 2; i++) {
			if (n >= i)
				count++;
			else
				break;
			n = n - i;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(arrangeCoins(5));
	}
}
