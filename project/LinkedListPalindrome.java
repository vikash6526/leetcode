package leetcode.project;

public class LinkedListPalindrome {

	public class Node {
		public int data;
		public Node next;

	}

	public static Node first;

	public boolean palindrome() {
		if (first == null || first.next == null)
			return true;
		Node p = first;
		int l = linkedListLength(first);
		int i = 1;
		while (i < l / 2 && p != null) {
			p = p.next;
			i++;
		}
		Node q = p.next;
		p.next = null;
		q = reverse(q);
		p = first;
		while (p != null && q != null) {
			if (p.data != q.data)
				return false;
			p = p.next;
			q = q.next;
		}

		return true;
	}

	public int linkedListLength(Node node) {
		Node current = node;
		int l = 0;
		while (current != null) {
			current = current.next;
			l++;
		}
		return l;
	}

	public Node reverse(Node node) {
		if (node == null || node.next == null)
			return node;
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public void insert(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (first == null)
			first = newNode;
		else {
			Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void dispaly() {
		Node current = first;
		System.out.println("First -- > Last");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	public static void main(String[] args) {
		LinkedListPalindrome llp = new LinkedListPalindrome();
		llp.insert(0);
		llp.insert(0);
//		llp.insert(3);
//		llp.insert(5);
//		llp.insert(2);
//		llp.insert(1);

		llp.dispaly();
		System.out.println(llp.palindrome());

	}

}
