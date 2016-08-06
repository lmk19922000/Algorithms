package misc;

import java.util.Arrays;

public class ReverseSentence {

	public static void main(String[] args) {
		System.out.println(reverseSentence("My name is Khue Fun"));
	}

	public static String reverseSentence(String str){
		String[] strArr = str.split(" ");
		String temp;
		
		for (int i = 0; i<strArr.length/2; i++){
			temp = strArr[i];
			strArr[i] = strArr[strArr.length-1-i];
			strArr[strArr.length-1-i] = temp;
		}
		
		StringBuilder newStr = new StringBuilder();
		for (String word: strArr){
			newStr.append(word + " ");
		}
		
		return newStr.toString().trim();
	}
}
