package leetcode.project;

public class MedianOfTwoSortedArrays {
	public static double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		if (m > n) { // to ensure m<=n
			int[] temp = A;
			A = B;
			B = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j - 1] > A[i]) {
				iMin = i + 1; // i is too small
			} else if (i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1; // i is too big
			} else { // i is perfect
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}

				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int length = nums1.length + nums2.length;
		int[] arr = new int[length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				arr[k++] = nums1[i];
				i++;
			} else {
				arr[k++] = nums2[j];
				j++;
			}
		}
		if (i < nums1.length) {
			while (i < nums1.length) {
				arr[k++] = nums1[i];
				i++;
			}
		} else if (j < nums2.length) {
			while (j < nums2.length) {
				arr[k++] = nums2[j];
				j++;
			}
		}
		double median = 0;
		int mid = arr.length / 2;
		if (arr.length % 2 == 0) {
			median = (arr[mid - 1] + arr[mid]) / 2.0;
		} else
			median = arr[mid];
		return median;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2 };
		int[] B = new int[] { 3, 4 };
		System.out.println(findMedianSortedArrays(A, B));

	}

}
