package misc;

import java.util.ArrayList;
import java.util.List;

public class FindTwoDisctinctElements {

	public static void main(String[] args) {
		findDistinctElements(new int[]{1, 2, 3, 5, 7, 2, 5, 7, 1, 4});
	}

	public static void findDistinctElements(int[] nums){
		int num1=0, num2=0, k;
		int ans = 0, mask = 0;
		
		for(int i = 0; i<nums.length; i++){
			ans = ans ^ nums[i];
		}
		
		for(k = 0; k<32; k++){
			mask = 1 << k;
			if((mask & ans) != 0){
				break;
			}
		}
		
		List<Integer> nums1 = new ArrayList<Integer>();
		List<Integer> nums2 = new ArrayList<Integer>();
		
		for(int i = 0; i<nums.length; i++){
			if((mask &nums[i]) == 0){
				nums1.add(nums[i]);
			} else{
				nums2.add(nums[i]);
			}
		}
		
		for(int i = 0; i<nums1.size(); i++){
			num1 = num1 ^ nums1.get(i);
		}
		
		for(int i = 0; i<nums2.size(); i++){
			num2 = num2 ^ nums2.get(i);
		}
		
		System.out.println(num1 + " " + num2);
	}
}
