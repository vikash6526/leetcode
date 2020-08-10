package leetcode.project;

public class KPlacesAway {
	public static boolean kLengthApart(int[] nums, int k) {
		int start = -1;
		int end = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1 && start == -1)
				start = i;
			else if (nums[i] == 1 && end == -1 && start > -1)
				end = i;
			if (start > -1 && end > -1 && (end - start - 1) >= k) {
				start = end;
				end = -1;
			}
			if (start > -1 && end > -1 && (end - start - 1) < k) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(kLengthApart(new int[] { 0, 1, 0, 1 }, 1));

	}

}
