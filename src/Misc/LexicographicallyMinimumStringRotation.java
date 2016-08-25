package Misc;

import java.util.ArrayList;
import java.util.Collections;

public class LexicographicallyMinimumStringRotation {
	public static void main(String[] args) {
		System.out.println(getLexiMinString("GFG"));
		
	}
	
	public static String getLexiMinString(String str){
		StringBuilder doubleStr = new StringBuilder(str + str);
		ArrayList<String> permu = new ArrayList<String>();
		
		for (int i = 0; i<str.length(); i++){
			permu.add(doubleStr.substring(i, i+str.length()));
		}
		
		Collections.sort(permu);
		
		return permu.get(0);
	}
}
