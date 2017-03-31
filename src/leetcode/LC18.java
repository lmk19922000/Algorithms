package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 0, -1, 0, -2, 2};
		fourSum(nums, 0);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for(int i = 0; i<nums.length;i++){
        	for (int j = i+1; j<nums.length; j++){
        		int low = j+1, high = nums.length-1;
        		while(low<high){
        			int val = target-nums[i]-nums[j];
        			if(val<nums[low]+nums[high]){
        				high--;
        			} else if(val>nums[low]+nums[high]){
        				low++;
        			} else{
        				List<Integer> list = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
        				if(!ans.contains(list)){
        					ans.add(list);
        				}
        				high--;
        				low++;
        			}
        		}
        	}
        }
        
        return ans;
    }
}
