package leetcode.project;

public class FindSpecialInteger {
	public static int findSpecialInteger(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] == arr[i + len / 4])
				return arr[i];
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 40, 10, 20, 30 };
		System.out.println(findSpecialInteger(arr));

	}

}
