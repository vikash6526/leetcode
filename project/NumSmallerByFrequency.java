package leetcode.project;

import java.util.Arrays;

public class NumSmallerByFrequency {
	public static int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] cnt = new int[12];
		for (String s : words)
			cnt[check(s)]++;
		for (int i = 9; i > 0; i--)
			cnt[i] += cnt[i + 1];
		int n = queries.length;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++)
			ans[i] = cnt[check(queries[i]) + 1];
		return ans;
	}

	public static int check(String s) {
		char l = 'z';
		int cnt = 0;
		for (char c : s.toCharArray()) {
			if (c == l)
				cnt++;
			else if (c < l) {
				l = c;
				cnt = 1;
			}
		}
		return cnt;
	}

	public static int[] numSmallerByFrequency1(String[] queries, String[] words) {
		int[] result = new int[queries.length];
		int[] q = new int[queries.length];
		int i = 0;
		for (String str : queries) {
			char[] tempArray = str.toCharArray();
			Arrays.sort(tempArray);
			str = new String(tempArray);
			q[i++] = (str.lastIndexOf(str.charAt(0)) - str.indexOf(str.charAt(0))) + 1;
		}
		int j = 0;
		int[] w = new int[words.length];
		for (String str : words) {
			char[] tempArray = str.toCharArray();
			Arrays.sort(tempArray);
			str = new String(tempArray);
			w[j++] = (str.lastIndexOf(str.charAt(0)) - str.indexOf(str.charAt(0))) + 1;
		}
		Arrays.sort(w);
		for (int l = 0; l < q.length; l++) {
			for (int m = 0; m < w.length; m++) {
				if (q[l] < w[m]) {
					result[l] = (w.length - m);
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] queries = new String[] { "bba", "abaaaaaa", "aaaaaa", "bbabbabaab", "aba", "aa", "baab", "bbbbbb",
				"aab", "bbabbaabb" };
		String[] words = new String[] { "aaabbb", "aab", "babbab", "babbbb", "b", "bbbbbbbbab", "a", "bbbbbbbbbb",
				"baaabbaab", "aa" };
		System.out.println(Arrays.toString(numSmallerByFrequency(queries, words)));

	}

}
