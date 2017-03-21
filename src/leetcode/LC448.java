package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC448 {

	public static void main(String[] args) {
		int[] arr = {4,3,2,7,8,2,3,1};
		findDisappearedNumbers(arr);
	}
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i<nums.length; i++){
        	int abs = Math.abs(nums[i]);
        	if(nums[abs-1] > 0){
        		nums[abs - 1] = -nums[abs - 1];
        	}
        }
        
        for(int i = 0; i<nums.length; i++){
        	if(nums[i] > 0){
        		ans.add(i+1);
        	}
        }
        
        return ans;
    }
}
