package leetcode.project;

public class BackSpaceStringCompare {

	public static boolean backspaceCompare(String S, String T) {
		while (S.lastIndexOf("#") > 0) {
			int i = S.indexOf("#", 1);
			if (i >= 2)
				S = S.substring(0, i - 1) + S.substring(i + 1, S.length());
			else
				S = S.substring(i + 1, S.length());
		}
		S = S.replaceAll("#", "");

		while (T.lastIndexOf("#") > 0) {
			int j = T.indexOf("#", 1);
			if (j >= 2)
				T = T.substring(0, j - 1) + T.substring(j + 1, T.length());
			else
				T = T.substring(j + 1, T.length());
		}
		T = T.replaceAll("#", "");

		if (S.equalsIgnoreCase(T))
			return true;

		return false;
	}

	public static void main(String[] args) {
		String str1 = "y#fo##f";
		String str2 = "y#f#o##f";
		// System.out.println(str1.substring(0, 1)+ str1.substring(2, 4));
		System.out.println(backspaceCompare(str1, str2));

	}

}
