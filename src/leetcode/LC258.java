package leetcode;

public class LC258 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(76));
	}
	public static int addDigits(int num) {
		int ans = 0;
		do{
			while(num != 0){
				ans = ans + num%10;
				num = num/10;
			}
			if(ans > 9){
				num = ans;
				ans = 0;
			}
		} while(num > 9);
		
		return ans;
    }
}
