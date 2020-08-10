package leetcode.project;

public class PermutationInString {
	public static boolean checkInclusion(String s1, String s2) {

		int[] arr = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i) - 'a']++;
		}
		int start = 0;
		int end = 0;
		while (end < s2.length()) {
			if (arr[s2.charAt(end) - 'a'] > 0) {
				arr[s2.charAt(end++) - 'a']--;
				if (end - start == s1.length())
					return true;
			} else if (start == end) {
				start++;
				end++;
			} else {
				arr[s2.charAt(start++) - 'a']++;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));

	}

}
