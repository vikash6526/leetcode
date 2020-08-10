package leetcode.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static int[] nextLargerNodes(ListNode head) {
		ListNode current = head;
		int length = 0;
		while (current != null) {
			current = current.next;
			length++;
		}
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		int[] res = new int[length];
		int index = 0;
		int i = 0;
		while (head != null) {
			list.add(head.val);
			while (!stack.isEmpty() && list.get(stack.peek()) < head.val) {
				res[i++] = head.val;
				stack.pop();
			}
			stack.add(index++);
			head = head.next;
		}
		return res;
	}

	public static void main(String[] args) {
		ListNode first = new ListNode(3);
		first.next = new ListNode(7);
		first.next.next = new ListNode(2);
		first.next.next.next = new ListNode(9);

		nextLargerNodes(first);

	}

}
