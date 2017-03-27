package leetcode;

import dataStructures.TreeNode;

public class LC530 {
	int min = Integer.MAX_VALUE;
	int prev = -1;
	
	public int getMinimumDifference(TreeNode root) {
        if(root == null){
        	return min;
        }
        
        getMinimumDifference(root.getLeft());
        
        if(prev > -1){
        	min = Math.min(min, Math.abs(prev - root.getVal()));	
        }
        
        prev = root.getVal();
        getMinimumDifference(root.getRight());
        
        return min;
    }
}

