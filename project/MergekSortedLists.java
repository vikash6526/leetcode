package leetcode.project;

import java.util.PriorityQueue;

public class MergekSortedLists {
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

	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (ListNode ln : lists) {
			if (ln != null)
				pq.offer(ln);
		}
		ListNode prev = new ListNode(Integer.MIN_VALUE);
		ListNode result = prev;
		while (!pq.isEmpty()) {
			ListNode m = pq.poll();
			if (m.next != null) {
				pq.offer(m.next);
			}
			prev.next = m;
			prev = prev.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
