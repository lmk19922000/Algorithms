package leetcode;

public class LC476 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(findComplement(5));
	}
	
	public static int findComplement(int num) {
		int mask = (Integer.highestOneBit(num) << 1) - 1;
		return mask ^ num;
    }
}
