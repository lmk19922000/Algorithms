package Misc;

public class MultiplyWithoutOperator {
	public static void main(String[] args) {
		int num = 3; // the number we want to multiply with 15
		
		// Convert the number to binary form
		String str = Integer.toBinaryString(num);

		int strLength = str.length();
		int strPaddedLength = 3 + strLength;

		// Array holding the product of each bit with 15
		String[] partialSums = new String[strLength];

		for (int i = 0; i < strLength; i++) {
			if (str.charAt(strLength - i - 1) == '1') {
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
