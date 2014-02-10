package Misc;

public class ArrayAndString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(compress("abcdjjj"));

	}
	
	public static String compress(String str){
		int count = 1;
		int i;
		
		StringBuffer myStr = new StringBuffer();
		for (i = 0; i < str.length()-1; i++){
			if (str.charAt(i)==str.charAt(i+1)){
				count++;
			} else {
				myStr.append(str.charAt(i));
				myStr.append(String.valueOf(count));
				count = 1;
			}
		}
		
		i--;
		if (str.charAt(i)==str.charAt(i+1)){
			myStr.append(str.charAt(i));
			myStr.append(String.valueOf(count));
		} else{
			count = 1;
			myStr.append(str.charAt(i+1));
			myStr.append(String.valueOf(count));
		}
		
		if (str.length() <= myStr.length()){
			return str;
		} else{
			return myStr.toString();
		}
	}
}
