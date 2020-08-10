package leetcode.project;

public class BinarySearchTreeFromPreorder {
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

	public static TreeNode bstFromPreorder(int[] preorder) {
		TreeNode head = new TreeNode(preorder[0]);

		for (int i = 1; i < preorder.length; i++) {
			TreeNode newNode = new TreeNode(preorder[i]);
			TreeNode current = head;
			while (true) {
				if (newNode.val < current.val) {
					if (current.left == null) {
						current.left = newNode;
						break;
					}
					current = current.left;

				} else {
					if (current.right == null) {
						current.right = newNode;
						break;
					}
					current = current.right;

				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });

	}

}
