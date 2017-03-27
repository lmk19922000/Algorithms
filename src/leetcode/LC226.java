package leetcode;

import dataStructures.TreeNode;

public class LC226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TreeNode invertTree(TreeNode root) {
        if(root == null){
        	return null;
        }
        
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        root.setLeft(right);
        root.setRight(left);
        
        invertTree(left);
        invertTree(right);
        
        return root;
    }
}
