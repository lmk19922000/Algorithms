package Misc;

import java.util.Stack;

public class CheckParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		System.out.println(checkParenthesis("{}{}{{}}{{{}}}{{}"));
	}

	public static boolean checkParenthesis(String str){
		Stack<Character> myStack = new Stack<Character>();
		
		for (int i = 0; i <str.length(); i++){
			if (str.charAt(i) == '{'){
				myStack.push('{');
			} else if (str.charAt(i) == '}'){
				if (myStack.isEmpty()){
					return false;
				}
				myStack.pop();
			} else{
				return false;
			}
		}
		
		if (!myStack.isEmpty()){
			return false;
		}
		
		return true;
	}
}
