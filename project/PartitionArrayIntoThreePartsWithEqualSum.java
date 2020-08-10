package leetcode.project;

public class PartitionArrayIntoThreePartsWithEqualSum {
	public static boolean canThreePartsEqualSum(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
		}
		int count = 0;
		int subSum = 0;
		for (int i = 0; i < A.length; i++) {
			subSum = subSum + A[i];
			if (subSum == sum / 3) {
				subSum = 0;
				count++;
			}
			if (i == A.length - 1 && count >= 3)
				return true;
		}
		return count == 3 ? true : false;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, -10, 10, -10, 10, -10, 10, -10 };
		System.out.println(canThreePartsEqualSum(arr));

	}

}
