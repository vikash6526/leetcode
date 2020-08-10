package leetcode.project;

public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0 && j >= 0; k--) {
			nums1[k] = (i < 0 || nums1[i] < nums2[j]) ? nums2[j--] : nums1[i--];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 0 };
		int[] nums2 = new int[] { 1 };
		merge(nums1, 0, nums2, 1);
	}
}
