package leetcode;

import java.util.Arrays;

public class LC506 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5, 4, 3, 2, 1};
		findRelativeRanks(nums);
	}

public static String[] findRelativeRanks(int[] nums) {
		Integer[] index = new Integer[nums.length];
		for(int i = 0; i<index.length; i++){
			index[i] = i;
		}
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        
        String[] result = new String[index.length];
        for(int i = 0; i<index.length; i++){
        	if (i == 0) {
                result[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                result[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            }
            else {
                result[index[i]] = (i + 1) + "";
            }
        }
//        System.out.println(Arrays.toString(result));
        
        return result;
    }
}
