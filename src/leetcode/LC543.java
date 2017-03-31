package leetcode;

import dataStructures.TreeNode;

public class LC543 {
    public int diameterOfBinaryTree(TreeNode root) {
    	return rec(root);
    }

	private int rec(TreeNode root) {
		if(root == null){
			return 0;
		}
		
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        
        return Math.max(Math.max(leftDepth + rightDepth, rec(root.left)), rec(root.right));
	}

	private int getDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		return Math.max(getDepth(root.left) + 1, getDepth(root.right) + 1);
	}

}
