package leetcode;

public class LC136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 6, 5, 4, 1, 2, 3, 6};
		System.out.println(singleNumber(arr));
	}
public static int singleNumber(int[] nums) {
	int ans = 0;
     for(int num: nums){
    	 ans = ans ^ num;
     }
     
     return ans;
    }
}
