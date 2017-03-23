package leetcode;

public class LC283 {

	public static void main(String[] args) {
		int[] nums = {1, 0, 0, 2, 0, 0, 0, 3};
		moveZeroes(nums);
	}

	public static void moveZeroes(int[] nums) {
        int zero = 0, one = 0, temp;
        
        while(true){
        	while(zero < nums.length && nums[zero] != 0){
        		zero++;
        	}
        	while(one < nums.length &&nums[one] == 0){
        		one++;
        	}
        	if(zero < nums.length && one < nums.length && zero < one){
        		temp = nums[zero];
        		nums[zero] = nums[one];
        		nums[one] = temp;
        	} else if(zero < nums.length && one < nums.length){
        		one++;
        	} else{
        		break;
        	}
        }
        
		for(int num: nums){
			System.out.println(num);
		}
    }
}
