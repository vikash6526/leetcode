package leetcode.project;

import java.util.Stack;

public class RemoveKDigits {
	public static String removeKdigits1(String num, int k) {
		int len = num.length();
		if (k == 0)
			return num;
		if (k == len)
			return "0";

		Stack<Character> stack = new Stack<>();
		int index = 0;

		while (index < len) {
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(index++));
		}
		while (k-- > 0)
			stack.pop();

		String smallest = "";
		while (!stack.isEmpty())
			smallest = stack.pop() + smallest;

		// delete leading zeros
		while (smallest.length() > 1 && smallest.charAt(0) == '0')
			smallest = smallest.substring(1);

		return smallest;
	}

	public static String removeKdigits(String num, int k) {
		if (num.length() == k)
			return "0";
		Stack<Integer> stack = new Stack<>();
		int newStrLength = num.length() - k;
		for (int i = 0; i < num.length(); i++) {
			while (!stack.isEmpty() && k > 0 && stack.peek() > Integer.parseInt(String.valueOf(num.charAt(i)))) {
				stack.pop();
				k--;
			}
			stack.push(Integer.parseInt(String.valueOf(num.charAt(i))));
		}
		String str = "";
		while (!stack.isEmpty()) {
			str = String.valueOf(stack.pop()) + str;
		}
		str = str.substring(0, newStrLength);
		while(str.charAt(0) == '0' && str.length() != 1)
			str = str.substring(1, str.length());

		return str;
	}

	public static void main(String[] args) {
		System.out.println(removeKdigits("5337", 2));
	}

}
