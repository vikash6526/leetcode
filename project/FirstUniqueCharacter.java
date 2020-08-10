package leetcode.project;

public class FirstUniqueCharacter {
	public static int firstUniqChar(String s) {
		int index = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (s.indexOf(c) == s.lastIndexOf(c)) {
				index = s.indexOf(c);
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));

	}

}
