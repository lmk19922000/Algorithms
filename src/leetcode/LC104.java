package leetcode;

import dataStructures.TreeNode;

public class LC104 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public int maxDepth(TreeNode root) {
	if(root == null){
        return 0;
    }
        if(root.getLeft() == null && root.getRight() == null){
        	return 1;
        }
        
        if(root.getLeft() != null && root.getRight() == null){
        	return 1+maxDepth(root.getLeft());
        }
        if(root.getLeft() == null && root.getRight() != null){
        	return 1+maxDepth(root.getRight());
        }
        
        return 1+Math.max(maxDepth(root.getRight()), maxDepth(root.getLeft())) ;
    }
}
