package leetcode.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KthSmallestElementInBST {

	public static TreeNode root;

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void insert(int data) {
		TreeNode newNode = new TreeNode(data);
		if (root == null)
			root = newNode;
		else {
			TreeNode current = root;
			while (true) {
				if (data < current.val) {
					if (current.left == null) {
						current.left = newNode;
						break;
					} else
						current = current.left;
				} else if (data > current.val) {
					if (current.right == null) {
						current.right = newNode;
						break;
					} else
						current = current.right;
				}
			}
		}
	}

	static List<Integer> list = new ArrayList<>();

	// recursion
	public static int kthSmallest(TreeNode root, int k) {
		getBSTElements(root);
		Collections.sort(list);
		return list.get(k - 1);
	}

	public static void getBSTElements(TreeNode head) {
		if (head != null) {
			list.add(head.val);
			getBSTElements(head.left);
			getBSTElements(head.right);
		}
	}

	public static int kthSmallest1(TreeNode root, int k) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

		while (true) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			root = stack.removeLast();
			if (--k == 0)
				return root.val;
			root = root.right;
		}
	}

	public static void main(String[] args) {

		insert(10);
		insert(5);
		insert(15);
		insert(3);
		insert(7);
		insert(12);
		insert(18);
		insert(6);

		System.out.println(kthSmallest1(root, 3));
		LinkedList<Integer> stack = new LinkedList<>();
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);

		//System.out.println(stack.removeLast());

	}

}
