package misc;
import java.io.*;
import java.util.Vector;
/**
 * 
 * @author Le Minh Khue
 * This class takes in a fraction number and determine whether its decimal representation is infinite (eg: 1/3) or not (eg: 1/10)  
 *
 */
public class TerminatingDecimal {
	private static Vector<String> content = new Vector<String>();

	public static void main(String[] args) throws IOException {
		String outputFilename = "C:\\Users\\AdminNUS\\Downloads\\test1\\output.txt";
		String inputFilename = "C:\\Users\\AdminNUS\\Downloads\\test1\\input.txt";
		int gcd;

		File outputFile = new File(outputFilename);
		boolean isReady = callTextFile(outputFile);

		File inputFile = new File(inputFilename);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));

		if (isReady) {
			String numInputString = br.readLine();
			int numInput = Integer.parseInt(numInputString);

			while (numInput > 0) {
				String fraction = br.readLine();
				String integers[] = fraction.split("/");
				int numerator, denominator;
				numerator = Integer.parseInt(integers[0]);
				denominator = Integer.parseInt(integers[1]);
				
				gcd = GCD(numerator, denominator);
				int testNum = denominator / gcd;
				
				// Test prime factors
				while (testNum % 2 == 0) {
					testNum = testNum / 2;
				}
				while (testNum % 5 == 0) {
					testNum = testNum / 5;
				}
				if (testNum == 1) {
					content.add("T");
				} else {
					content.add("N");
				}
				
				numInput--;
			}

			writeToFile(outputFile);
		} else {
			System.out.println("Failed.");
		}
		br.close();
	}

	// Find the Greatest Common Divisor of two numbers
	private static int GCD(int num1, int num2) {
		int a, b, r;
		if (num1 < num2) {
			a = num2;
			b = num1;
		} else {
			a = num1;
			b = num2;
		}

		if (b == 0) {
			return a;
		}

		r = a % b;

		while (r != 0) {
			a = b;
			b = r;
			r = a % b;
		}

		return b;
	}

	// If the file is already exists, we open it, if not, we create a new one
	public static boolean callTextFile(File f) throws IOException {
		boolean isReady = false;

		if (!f.exists()) {
			isReady = f.createNewFile();
		} else {
			isReady = true;
		}
		return isReady;
	}

	// Write to output file
	public static void writeToFile(File f) throws IOException {
		BufferedWriter writeBuffer = new BufferedWriter(new FileWriter(f, true));
		for (int i = 0; i < content.size(); i++) {
			writeBuffer.write(content.get(i));
			writeBuffer.newLine();
		}
		writeBuffer.close();
	}
}
