package misc;

import java.util.Stack;

public class CheckParenthesis2 {

	public static void main(String[] args) {
		System.out.println(checkParenthesisMatch("()()()((("));
	}

	/**
	 * Return -1 if the parenthesis match
	 * Otherwise, return index of the incorrect parenthesis
	 * @param exp
	 * @return
	 */
	public static int checkParenthesisMatch(String exp){
		Stack<Pair> stack = new Stack<Pair>();
		
		char[] arr = exp.toCharArray();
		for(int i = 0; i< arr.length; i++){
			char c = arr[i];
			
			if(c=='('){
				stack.push(new Pair(c, i));
			} else if (c==')'){
				if(!stack.empty()){
					stack.pop();
				} else{
					return i;
				}
			} else {
				return i;
			}
		}
		
		if(stack.empty()){
			return -1;
		} else {
			Pair p = stack.pop();
			while(!stack.empty()){
				p =stack.pop();
			}
			
			return p.second;
		}
	}
}
