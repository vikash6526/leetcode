package leetcode.project;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinaryToIntegerLinkedList {
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

	public static int getDecimalValue(ListNode head) {
		if (head.next == null)
			return head.val;
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		double sum = 0;
		int size = list.size() - 1;
		for (Integer data : list) {
			sum = sum + data * Math.pow(2, size);
			size--;
		}
		return (int) sum;
	}

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("101", 2));

	}

}
