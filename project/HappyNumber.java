package leetcode.project;

import java.util.HashSet;

public class HappyNumber {

	public static boolean isHappy(int n) {
		int sum = 0;
		HashSet<Integer> set=new HashSet<>();
		while (!set.contains(n)) {
			set.add(n);
			while (n != 0) {
				sum = (int) (sum + Math.pow(n % 10, 2));
				n /= 10;
			}
			n = sum;
			if (sum == 1)
				return true;
			else if (set.contains(sum))
				return false;
			sum=0;
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(2));

	}

}
