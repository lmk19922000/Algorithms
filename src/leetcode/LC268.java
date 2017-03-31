package leetcode;

public class LC268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		missingNumber(new int[]{1, 0});

	}
	 public static int missingNumber(int[] nums) {
		 int temp1, temp2, count = 0;
		 
		 while(count<nums.length){
			 while(nums[count] != count){
				 if(nums[count] != nums.length){
					 temp1 = nums[count];
					 temp2 = nums[nums[count]];
					 nums[count] = temp2;
					 nums[temp1] = temp1;
				 } else{
					 break;
				 }
			 }
			 count++;
		 }
			
		 for(int i = 0; i<nums.length; i++){
			 if(nums[i] == nums.length){
				 return i;
			 }
		 }
		 
		 return nums.length;
	    }
}
