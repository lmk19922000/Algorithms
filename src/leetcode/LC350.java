package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC350 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		List<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i<nums1.length; i++){
			if(map.containsKey(nums1[i])){
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else{
				map.put(nums1[i], 1);
			}
		}
        
		for(int i = 0; i<nums2.length; i++){
			if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
				ans.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		
		int[] arr = new int[ans.size()];
		for(int i = 0; i < ans.size(); i++){
			arr[i] = ans.get(i);
		}
		
		return arr;
    }
}
