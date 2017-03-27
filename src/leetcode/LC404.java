package leetcode;

import dataStructures.TreeNode;

public class LC404 {
	int sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumOfLeftLeaves(TreeNode root) {
		return sum(root, false);
	}

	public int sum(TreeNode node, boolean isLeft) {
		if (node == null) {
			return 0;
		}

		if (isLeft) {
			return sum + node.val + sum(node.left, true) + sum(node.right, false);
		} else {
			return sum + sum(node.left, true) + sum(node.right, false);
		}
	}
}
