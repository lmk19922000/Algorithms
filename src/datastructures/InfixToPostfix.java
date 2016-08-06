package datastructures;

import java.util.Stack;

/**
 * 
 * @author Le Minh Khue This class takes in an expression in infix form and
 *         converts it to postfix form Eg: a + b * 3 will be converted to a b 3
 *         * +
 * 
 */
public class InfixToPostfix {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<Character>();
		String exp = "b*c +d*e";
		String result = "";

		exp = exp.replaceAll("\\s+", "");
		char[] charArr = exp.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			switch (charArr[i]) {
			case '(':
				stack.push(charArr[i]);
				break;
			case ')':
				while (stack.peek() != '(') {
					result = result + stack.pop() + " ";
				}
				stack.pop();
				break;
			case '+':
			case '-':
				if (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					result = result + stack.pop() + " ";
				}
				stack.push(charArr[i]);
				break;
			case '*':
			case '/':
				stack.push(charArr[i]);
				break;
			default:
				result = result + charArr[i] + " ";
				break;
			}
		}

		while (!stack.isEmpty()) {
			result = result + stack.pop() + " ";
		}
		result = result.trim();
		
		System.out.println(result);
	}

}
