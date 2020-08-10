package leetcode.project;

public class OddEvenLinkedList {
	public static ListNode head;

	public class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int data) {
			this.val = data;
		}

		public ListNode(int data, ListNode node) {
			this.val = data;
			this.next = node;
		}
	}

	public void insert(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null)
			head = newNode;
		else {
			ListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		ListNode current = head;
		ListNode evenHead = null;
		ListNode evenCurrent = null;
		ListNode oddHead = null;
		ListNode oddCurrent = null;
		int i = 1;
		while (current != null) {
			if (i % 2 != 0) {
				if (oddCurrent == null) {
					oddHead = current;
					oddCurrent = current;
				} else {
					oddCurrent.next = current;
					oddCurrent = current;
				}
			} else {
				if (evenCurrent == null) {
					evenHead = current;
					evenCurrent = current;
				} else {
					evenCurrent.next = current;
					evenCurrent = current;
				}
			}
			current = current.next;
			i++;
		}
		evenCurrent.next = null;
		oddCurrent.next = evenHead;
		head = oddHead;
		return head;
	}

	public ListNode oddEvenList1(ListNode head) {
		ListNode current = head;
		ListNode evenPrev = null;
		ListNode evenNode = null;
		ListNode oddPrev = null;
		ListNode oddNode = null;
		int odd = 0;
		int even = 0;
		int currentSize = 0;
		int listSize = 0;
		while (current != null) {
			listSize++;
			current = current.next;
		}
		current = head;
		while (current.next != null) {
			while (current.next != null && current.val % 2 != 0) {
				currentSize++;
				evenPrev = current;
				current = current.next;
			}
			currentSize++;
			evenNode = current;
			even = currentSize;
			if (current.next != null)
				current = current.next;
			while (current.next != null && current.val % 2 == 0) {
				currentSize++;
				oddPrev = current;
				current = current.next;
			}
			currentSize++;
			oddNode = current;
			odd = currentSize;
			current = oddNode;
			currentSize = even - 1;
			if (even < odd) {
				if (oddPrev == null && evenPrev == null) {
					evenNode.next = oddNode.next;
					oddNode.next = evenNode;
				} else if (oddPrev == null) {
					evenNode.next = oddNode.next;
					evenPrev.next = oddNode;
					oddNode.next = evenNode;
				} else {
					oddPrev.next = oddNode.next;
					evenPrev.next = oddNode;
					oddNode.next = evenNode;
				}
			}
			if (evenNode == head)
				head = oddNode;
			if (odd == listSize)
				break;
		}

		return head;
	}

	public void display() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

	public static void main(String[] args) {
		OddEvenLinkedList oel = new OddEvenLinkedList();
		oel.insert(2);
		oel.insert(1);
		oel.insert(3);
		oel.insert(5);
		oel.insert(6);
		oel.insert(4);
		oel.insert(7);

		oel.display();
		oel.oddEvenList(head);
		System.out.println();
		oel.display();

	}

}
