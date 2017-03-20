package leetcode;

public class LC344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("hello1"));
	}
public static String reverseString(String s) {
        char[] arr = s.toCharArray();
        char c;
        for (int i = 0; i<arr.length/2; i++){
        	c = arr[i];
        	arr[i] = arr[arr.length-1-i];
        	arr[arr.length-1-i] = c;
        }
        return String.valueOf(arr);
    }
}
