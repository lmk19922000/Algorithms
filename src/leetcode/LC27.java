package leetcode;

public class LC27 {

	public static void main(String[] args) {
		removeElement(new int[]{1}, 1);

	}
    public static int removeElement(int[] nums, int val) {
        int low = 0, high = nums.length-1;
        int length = nums.length;
        while(low <= high){
            while(low <= high && nums[low] != val){
                low++;
            }
            while(low <= high && nums[high] == val){
                high--;
                length--;
            }
            if(low <= high){
                nums[low] = nums[high];
                low++;
                high--;
                length--;
            }
        }
        
        return length;
    }
}
