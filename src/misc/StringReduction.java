package misc;

import java.util.Stack;

public class StringReduction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "aaaabbbca";
		System.out.print(reduction(str));

	}
	
	public static String reduction (String str){
		StringBuilder ans = new StringBuilder("");
		char curr, temp;
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i<str.length(); i++){
			curr = str.charAt(i);
			while (!stack.isEmpty()){
				if (stack.peek() != curr){
					temp = stack.pop();
					curr = reduct(temp, curr);
				} else{
					break;
				}
			}
			
			stack.push(curr);
		}
		
		while (!stack.isEmpty()){
			ans.insert(0, stack.pop());
		}
		
		return ans.toString();
	}

	private static char reduct(char temp, char curr) {
		if ((temp == 'a' && curr == 'b') || (temp == 'b' && curr == 'a'))
			return 'c';
		
		if ((temp == 'a' && curr == 'c') || (temp == 'c' && curr == 'a'))
			return 'b';
		
		if ((temp == 'c' && curr == 'b') || (temp == 'b' && curr == 'c'))
			return 'a';
		
		return 'd';
	}
}
