package leetcode.project;

public class CousinsInBinaryTree {
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

	public static TreeNode yParentNode;
	public static TreeNode xParentNode;
	public static int xHeight = 0;
	public static int yHeight = 0;

	public static boolean isCousins(TreeNode root, int x, int y) {
		nextNode(root, null, x, y, 0);

		return xHeight == yHeight && xParentNode != yParentNode;
	}

	private static void nextNode(TreeNode currentNode, TreeNode parentNode, int x, int y, int depth) {
		if (currentNode.val == x) {
			xParentNode = parentNode;
			xHeight = depth;
		} else if (currentNode.val == y) {
			yParentNode = parentNode;
			yHeight = depth;
		} else {
			nextNode(currentNode.left, currentNode, x, y, depth + 1);
			nextNode(currentNode.right, currentNode, x, y, depth + 1);
		}
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		//tree.right.right = new TreeNode(5);

		System.out.println(isCousins(tree, 4, 5));

	}

}
