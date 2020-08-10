package leetcode.project;

import java.util.Stack;

public class BalancedParentheses {
	
	public static boolean balanced(String s) {
		int length=s.length();
		
		if(length==1)
			return false;
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<length;i++) {
			char c=s.charAt(i);
			if(c=='(' || c=='{' || c=='[') {
				stack.push(c);
			}
			else if(!stack.isEmpty() && c==')' && stack.peek()=='(')
				stack.pop();
			else if(!stack.isEmpty() && c=='}' && stack.peek()=='{')
				stack.pop();
			else if(!stack.isEmpty() && c==']' && stack.peek()=='[')
				stack.pop();
		}
		if(stack.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(balanced("]"));

	}

}
