package leetcode.project;

import java.util.Stack;

public class ValidParenthesisString {

	public static boolean checkValidString(String s) {
		int length = s.length();
		Stack<Character> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		Stack<Integer> astri = new Stack<>();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
				index.push(i);
			} else if (c == '*')
				astri.push(i);
			else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
				stack.pop();
				index.pop();
			} else if (!astri.isEmpty() && c == ')')
				astri.pop();
			else {
				stack.push(c);
				index.push(i);
			}
		}
		while (!stack.isEmpty() && !astri.isEmpty()) {
			if (stack.peek() == '(' && astri.peek() > index.peek()) {
				stack.pop();
				astri.pop();
				index.pop();
			} else if (stack.peek() == ')' && astri.peek() < index.peek()) {
				stack.pop();
				astri.pop();
				index.pop();
			} else
				return false;
		}

		if (stack.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
		System.out.println(checkValidString(
				"()()((*()()(*()((())()))))(()())))(((()*())))))(())()))((*(())))))()))))())*(())()(()(*))*(*"));
	}

}
