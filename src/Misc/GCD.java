package Misc;

public class GCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getGCD(8,16));
	}
	
	public static int getGCD(int p, int q){
		int big, small;
		
		if (p>q){
			big = p;
			small = q;
		} else{
			big = q;
			small = p;
		}
		
		int remainder, quotient;
		
		remainder = big%small;
		if (remainder == 0){
			return small;
		}
		
		quotient = big/small;
		while (remainder != 0){
			big = small;
			small = remainder;
			quotient = big/small;
			remainder = big%small;
		}
		
		return small;
	}
}
