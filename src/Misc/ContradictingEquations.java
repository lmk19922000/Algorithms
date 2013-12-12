package Misc;
import java.io.*;
/**
 * 
 * @author Le Minh Khue
 * This class takes in a set of equations and detect whether there is any conflict in that set
 *
 */
public class ContradictingEquations {
	private static String content;
	private static double[][] Matrix = new double[4][4];
	private static String outputFilename = "C:\\Users\\AdminNUS\\Downloads\\test2\\output1.txt";
	private static String inputFilename = "C:\\Users\\AdminNUS\\Downloads\\test2\\input1.txt";
	private static int NUM_OF_ROW;
	private static int NUM_OF_COL = 4;

	public static void main(String[] args) throws IOException {
		initializeMatrix();

		File outputFile = new File(outputFilename);
		boolean isReady = callTextFile(outputFile);

		if (isReady) {
			ContradictingEquations.fillMatrix();

			ContradictingEquations.reduceMatrix();

			boolean isContradict = ContradictingEquations.checkContradict();
			if (isContradict) {
				content = "C";
			} else {
				content = "N";
			}
		} else {
			System.out.println("Failed.");
		}

		writeToFile(outputFile);
	}

	// Initialize matrix with 0s
	private static void initializeMatrix() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < NUM_OF_COL; j++) {
				Matrix[i][j] = 0;
			}
		}
	}

	// Read input file and fill in matrix
	private static void fillMatrix() throws IOException {

		File inputFile = new File(inputFilename);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));

		String numInputString = br.readLine();
		NUM_OF_ROW = Integer.parseInt(numInputString) + 1;

		int i = 0;
		int count = NUM_OF_ROW;

		while (count > 0) {
			String equation = br.readLine();

			// Find the coefficient of variable x
			int indexX = equation.indexOf("x");
			if (indexX != -1 && indexX != 0) {
				String constantX = equation.substring(0, indexX);
				if (constantX.compareTo("-") != 0) {
					Matrix[i][0] = Integer.parseInt(constantX);
				} else {
					Matrix[i][0] = -1;
				}
			} else if (indexX == 0) {
				Matrix[i][0] = 1;
			}

			// Find the coefficient of variable y
			int indexY = equation.indexOf("y");
			if (indexX != -1) {
				if (indexY != -1) {
					String constantY = equation.substring(indexX + 1, indexY);
					if (constantY.compareTo("+") != 0
							&& constantY.compareTo("-") != 0) {
						Matrix[i][1] = Integer.parseInt(constantY);
					} else if (constantY.compareTo("+") == 0) {
						Matrix[i][1] = 1;
					} else {
						Matrix[i][1] = -1;
					}
				} else {
					Matrix[i][1] = 0;
				}
			} else {
				if (indexY != -1 && indexY != 0) {
					String constantY = equation.substring(0, indexY);
					if (constantY.compareTo("-") != 0) {
						Matrix[i][1] = Integer.parseInt(constantY);
					} else {
						Matrix[i][1] = -1;
					}
				} else if (indexY == 0) {
					Matrix[i][1] = 1;
				}
			}

			// Find the coefficient of variable z
			int indexZ = equation.indexOf("z");
			if (indexY != -1 || indexX != -1) {
				if (indexZ != -1) {
					if (indexY != -1) {
						String constantZ = equation.substring(indexY + 1,
								indexZ);
						if (constantZ.compareTo("+") != 0
								&& constantZ.compareTo("-") != 0) {
							Matrix[i][2] = Integer.parseInt(constantZ);
						} else if (constantZ.compareTo("+") == 0) {
							Matrix[i][2] = 1;
						} else {
							Matrix[i][2] = -1;
						}
					} else {
						String constantZ = equation.substring(indexX + 1,
								indexZ);
						if (constantZ.compareTo("+") != 0
								&& constantZ.compareTo("-") != 0) {
							Matrix[i][2] = Integer.parseInt(constantZ);
						} else if (constantZ.compareTo("+") == 0) {
							Matrix[i][2] = 1;
						} else {
							Matrix[i][2] = -1;
						}
					}
				} else {
					Matrix[i][2] = 0;
				}
			} else {
				if (indexZ != -1 && indexZ != 0) {
					String constantZ = equation.substring(0, indexZ);
					if (constantZ.compareTo("-") != 0) {
						Matrix[i][2] = Integer.parseInt(constantZ);
					} else {
						Matrix[i][2] = -1;
					}
				} else if (indexZ == 0) {
					Matrix[i][2] = 1;
				}
			}

			// Find the constant of RHS
			int indexConst = equation.indexOf("=");
			String RHS = equation.substring(indexConst + 1);
			Matrix[i][3] = Integer.parseInt(RHS);

			i++;
			count--;
		}

		br.close();
	}

	// Reduce matrix to unique row echelon form using Gaussian elimination
	// method
	private static void reduceMatrix() {

		for (int i = 0; i < NUM_OF_ROW; i++) {
			// Exchange the rows such that the elements in the main diagonal is
			// not 0
			if (Matrix[i][i] == 0) {
				for (int k = i + 1; k < NUM_OF_ROW; k++) {
					if (Matrix[k][i] != 0) {
						for (int l = 0; l < NUM_OF_COL; l++) {
							double temp = Matrix[i][l];
							Matrix[i][l] = Matrix[k][l];
							Matrix[k][l] = temp;
						}
						break;
					}
				}
			}

			// Ensure that the leading element of each row is 1 according to
			// Gaussian elimination method
			for (int j = 0; j < NUM_OF_ROW; j++) {
				int type = 2;

				// The element is not in the main diagonal and its value is not
				// 0
				if (j != i && Matrix[j][i] != 0) {
					type = 0;
				}
				// The element is in the main diagonal and its value is not 1
				if (j == i && Matrix[j][i] != 1) {
					type = 1;
				}

				double multiplyConst = 0;
				switch (type) {
				// Change the value of this element to 0
				case 0:
					int row = -1;

					for (int k = 0; k < NUM_OF_ROW; k++) {
						if (k != j) {
							int flag = 0;

							for (int l = 0; l < i; l++) {
								if (Matrix[k][l] != 0) {
									flag = 1;
								}
							}
							if ((flag == 0) && (Matrix[k][i] != 0)) {
								row = k;
								multiplyConst = (-1) * Matrix[j][i]
										/ Matrix[row][i];
								break;
							}
						}
					}

					if (multiplyConst != 0) {
						for (int k = 0; k < NUM_OF_COL; k++) {
							Matrix[j][k] = Matrix[j][k] + multiplyConst
									* Matrix[row][k];
						}
					}

					break;

				// Change the value of this element to 1
				case 1:
					int flag = 0;

					for (int l = 0; l < i; l++) {
						if (Matrix[j][l] != 0) {
							flag = 1;
						}
					}

					multiplyConst = Matrix[j][i];
					if (multiplyConst != 0 && flag == 0) {
						for (int l = 0; l < NUM_OF_COL; l++) {
							Matrix[j][l] = Matrix[j][l] / multiplyConst;
						}
					}

					break;
				}
			}
		}
	}

	// Check if the testing equation contradict the existing equations
	private static boolean checkContradict() {
		boolean ans = false;

		// Check if there is any row such that 0x+0y+0z=a and a!=0
		for (int i = 0; i < NUM_OF_ROW; i++) {
			if (Matrix[i][0] == 0 && Matrix[i][1] == 0 && Matrix[i][2] == 0
					&& Matrix[i][3] != 0) {
				ans = true;
				break;
			}
		}
		return ans;
	}

	// If the file is already exists, we open it, if not, we create a new one
	private static boolean callTextFile(File f) throws IOException {
		boolean isReady = false;

		if (!f.exists()) {
			isReady = f.createNewFile();
		} else {
			isReady = true;
		}
		return isReady;
	}

	// Write to output file
	private static void writeToFile(File f) throws IOException {
		BufferedWriter writeBuffer = new BufferedWriter(new FileWriter(f, true));
		writeBuffer.write(content);
		writeBuffer.close();
	}
}
