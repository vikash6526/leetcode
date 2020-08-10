package leetcode.project;

public class LargestpalindromeNumber {

	public static int palindromeNumber() {
		int pNumber = 0;
		for (int i = 100; i <= 999; i++) {
			for (int j = 100; j <= 999; j++) {
				int num = i * j;
				if (num == reverseNumber(num) && num > pNumber) {
					pNumber = num;
				}
			}
		}
		return pNumber;
	}

	public static int reverseNumber1(int n) {
		int reverseno = 0;
		int x = n;
		if (x < 0)
			x = Math.abs(x);
		while (x > 0) {
			reverseno = reverseno * 10 + x % 10;
			x = x / 10;
		}
		if (n < 0)
			return reverseno - 2 * reverseno;
		return reverseno;
	}

	public static int reverseNumber(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	public static void main(String[] args) {
		// System.out.println(palindromeNumber());
		System.out.println(reverseNumber(121));
		//System.out.println(reverseNumber(-123));

	}

}
