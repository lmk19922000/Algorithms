package BreakRC4;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Vector;

public class Break3 {
	private static Vector<Integer> tuples = new Vector<Integer>();
	private static int N = 128;
	private static int L = 16;
	private static int numTuples;
	private static int[] S = new int[N];
	private static int[] key = new int[L];
	private static Vector<Integer> possibleKeys = new Vector<Integer>();

	public static void main(String[] args) {
		readData();

		initializeKey();

		boolean flag = false;
		
		key[3] = findKey(3, 1);
		key[4] = findKey(4, 1);
		key[5] = findKey(5, 1);
		key[6] = findKey(6, 1);
		key[7] = findKey(7, 1);
		key[8] = findKey(8, 1);
		key[9] = findKey(9, 1);
		key[10] = findKey(10, 1);
		key[11] = findKey(11, 1);
		key[12] = findKey(12, 1);
		key[13] = findKey(13, 1);
		key[14] = findKey(14, 1);
		key[15] = findKey(15, 1);
		
		flag = generateTestData();
		if (flag) {
			System.out.println("Final key:");
			for (int i = 0; i < L-3; i++) {
				System.out.print(key[i + 3] + " ");
			}
		}
		System.out.println();
		System.out.println("Attack finished.");
	}

	private static boolean generateTestData() {
		boolean ans = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				key[j] = tuples.get(i * 4 + j);
			}
			int j, k;

			setupArrayS();

			j = 0;

			for (k = 0; k < N; k++) {
				j = suffleArrayS(k, j, key[k % L]);
			}
			int out = S[(S[1] + S[S[1]]) % N];
			if (out != tuples.get(i * 4 + 3)) {
				System.out.println();
				System.out.println("Test failed at i = " + i);
				System.out.println("Expected: " + tuples.get(i * 4 + 3));
				System.out.println("Output: " + out);
				ans = false;
				break;
			}
		}

		return ans;
	}

	private static void initializeKey() {
		for (int i = 0; i < L; i++) {
			key[i] = -1;
		}

	}

	private static int findKey(int knownBytes, int numTry) {
		possibleKeys.clear();

		for (int i = 0; i < numTuples; i++) {
			setupArrayS();
			int j = 0;
			for (int k = 0; k < knownBytes; k++) {
				int keyByte;
				if (k < 3) {
					keyByte = (int) tuples.get(i * 4 + k);
				} else {
					keyByte = key[k];
				}
				j = suffleArrayS(k, j, keyByte);
			}

			if ((S[1] + S[S[1]]) % N == knownBytes) {
				for (int k = 0; k < N; k++) {
					if ((int) tuples.get(i * 4 + 3) == S[k]) {
						int temp = k - j - S[(S[1] + S[S[1]]) % N];
						while (temp < 0) {
							temp = temp + N;
						}
						possibleKeys.add(new Integer(temp));
						break;
					}
				}
			}
		}
		return findByte(numTry);
	}

	private static int findByte(int numTry) {
		int max = (int) possibleKeys.get(0), min = (int) possibleKeys.get(0), index = 0;

		for (int i = 0; i < possibleKeys.size(); i++) {
			if ((int) possibleKeys.get(i) > max) {
				max = (int) possibleKeys.get(i);
			}
			if ((int) possibleKeys.get(i) < min) {
				min = (int) possibleKeys.get(i);
			}
		}
		int[] countArray = new int[max - min + 1];
		for (int i = 0; i < countArray.length; i++) {
			countArray[i] = 0;
		}
		for (int i = 0; i < possibleKeys.size(); i++) {
			countArray[(int) possibleKeys.get(i) - min]++;
		}

		while (numTry > 0) {
			max = countArray[0];
			for (int i = 0; i < countArray.length; i++) {
				if (countArray[i] > max) {
					max = countArray[i];
					index = i;
				}
			}
			countArray[index] = 0;
			numTry--;
		}

		return index + min;
	}

	private static int suffleArrayS(int currentIter, int j, int key) {
		j = (j + S[currentIter] + key) % N;
		int temp = S[currentIter];
		S[currentIter] = S[j];
		S[j] = temp;
		return j;
	}

	private static void readData() {
		String inputFilename = System.getProperty("user.dir")+"\\src\\BreakRC4\\A01.data";
		
		try {
			FileInputStream fin = new FileInputStream(inputFilename);
			DataInputStream dis = new DataInputStream(fin);

			byte[] byteArray = new byte[4];
			for (int i = 3; i >= 0; i--) {
				Integer integer = new Integer(dis.readUnsignedByte());
				byteArray[i] = integer.byteValue();
			}
			L = new BigInteger(byteArray).intValue();
			System.out.println("L = " + L);

			for (int i = 3; i >= 0; i--) {
				Integer integer = new Integer(dis.readUnsignedByte());
				byteArray[i] = integer.byteValue();
			}
			numTuples = new BigInteger(byteArray).intValue();
			System.out.println("Number of tuples = " + numTuples);

			// Now read the tuples.
			for (int i = 0; i < numTuples * 4; i++) {
				tuples.add(new Integer(dis.readUnsignedByte()));
			}
			dis.close();
		} catch (FileNotFoundException fe) {
			System.out.println("FileNotFoundException : " + fe);
		} catch (IOException ioe) {
			System.out.println("IOException : " + ioe);
		}
	}

	private static void setupArrayS() {
		for (int i = 0; i < N; i++) {
			S[i] = i;
		}
	}

}
