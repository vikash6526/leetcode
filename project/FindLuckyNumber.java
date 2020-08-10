package leetcode.project;

public class FindLuckyNumber {

	public static int findLucky(int[] arr) {
		int[] lucky = new int[500];
		for (int i = 0; i < arr.length; i++) {
			lucky[arr[i]] += 1;
		}
		for (int i = lucky.length - 1; i > 0; i--) {
			if (i == lucky[i])
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findLucky(new int[] { 1, 3, 3, 3, 498, 498 }));

	}

}
