package Misc;

/**
 * 
 * @author Le Minh Khue
 * The algorithm perform the traditional multiplication of 2 integers in binary form
 * (take each digit of the second number and multiply it with the first number, then we add up the results together)
 *  
 * The algorithm first convert the integer into binary string representing it
 * Then for each digit in the binary representation, it is multiplied with 1111 (binary representation of 15)
 * (The multiplication does not require * or + operators because we can only have 2 results: 1111 or 0000
 * Then we perform the addition of the results to get the final answer (in binary form)
 * Finally, we convert the binary form to integer.
 *
 */
public class MultiplyWithoutOperator {
	public static void main(String[] args) {
		int num = 4; // the number we want to multiply with 15
		
		// Convert the number to binary form
		String binaryRepresentation = Integer.toBinaryString(num);

		int strLength = binaryRepresentation.length();
		int strPaddedLength = 3 + strLength;

		// Array holding the product of each bit with 1111
		String[] partialSums = new String[strLength];
		
		// Pad the binary string in order for them to perform addition
		for (int i = 0; i < strLength; i++) {
			if (binaryRepresentation.charAt(strLength - i - 1) == '1') {
				partialSums[i] = pad("1111", i, strLength - 1);
			} else {
				partialSums[i] = pad("0000", i, strLength - 1);
			}
		}

		String result = new String(partialSums[0]);
		StringBuilder temp = new StringBuilder();
		boolean carry = false;
		
		// Add all the products together
		for (int i = 1; i < strLength; i++) {
			carry = false;
			for (int j = 0; j < strPaddedLength; j++) {
				if (result.charAt(strPaddedLength - 1 - j) == '1'
						&& partialSums[i].charAt(strPaddedLength - 1 - j) == '1'
						&& carry) {
					temp.append('1');
					carry = true;
				} else if ((result.charAt(strPaddedLength - 1 - j) == '0'
						&& partialSums[i].charAt(strPaddedLength - 1 - j) == '1' && carry)
						|| (result.charAt(strPaddedLength - 1 - j) == '1'
								&& partialSums[i].charAt(strPaddedLength - 1
										- j) == '0' && carry)
						|| (result.charAt(strPaddedLength - 1 - j) == '1'
								&& partialSums[i].charAt(strPaddedLength - 1
										- j) == '1' && !carry)) {
					temp.append('0');
					carry = true;
				} else if ((result.charAt(strPaddedLength - 1 - j) == '0'
						&& partialSums[i].charAt(strPaddedLength - 1 - j) == '0' && carry)
						|| (result.charAt(strPaddedLength - 1 - j) == '1'
								&& partialSums[i].charAt(strPaddedLength - 1
										- j) == '0' && !carry)
						|| (result.charAt(strPaddedLength - 1 - j) == '0'
								&& partialSums[i].charAt(strPaddedLength - 1
										- j) == '1' && !carry)) {
					temp.append('1');
					carry = false;
				} else {
					temp.append('0');
					carry = false;
				}
			}

			result = temp.reverse().toString();
			temp.delete(0, temp.length());
		}

		if (carry) {
			result = "1" + result;
		}
		
		// Convert the binary back to integer
		System.out.println(Integer.parseInt(result, 2));
	}

	// Pad '0' to left and right of the binary string
	private static String pad(String str, int i, int total) {
		StringBuilder ans = new StringBuilder();
		for (int j = 0; j < total - i; j++) {
			ans.append('0');
		}
		ans.append(str);
		for (int j = 0; j < i; j++) {
			ans.append('0');
		}

		return ans.toString();
	}
}
