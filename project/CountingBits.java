package leetcode.project;

public class CountingBits {
	public static int[] countBits(int num) {
		int[] arr = new int[num + 1];
		for (int i = 1; i < num + 1; i++)
			arr[i] = arr[i & (i - 1)] + 1;
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(8&7);
		//System.out.println(countBits(10));

	}

}
