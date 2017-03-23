package leetcode;

public class LC389 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd";
		String t = "abcrd";
		System.out.println(findTheDifference(s, t));
	}

public static char findTheDifference(String s, String t) {
        char c = 0;
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        for(char i: arrS){
        	c = (char)(c ^ i);
        }
        for(char i: arrT){
        	c = (char)(c ^ i);
        }
        return c;
    }
}
