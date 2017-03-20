package leetcode;

public class LC461 {
	public static void main(String[] args){
		System.out.println(calculateHammingDistance(1, 4));
	}
	
	public static int calculateHammingDistance(int x, int y){
		int ans = x ^ y;
		return Integer.bitCount(ans);
	}
}
