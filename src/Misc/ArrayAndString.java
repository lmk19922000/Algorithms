package Misc;

import java.util.Vector;

public class ArrayAndString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(compress("abcdjjj"));
		
		int[][] matrix = new int[][]{{1,3,5,8,3,9}, {12,9,3,0,3,32}, {1,0,2,32,4,4}, {5,0,9,2,2,5}, {5,6,9,8,3,21}};
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				if (matrix[i][j]<10){
					System.out.print(matrix[i][j] + "  ");
				} else{
					System.out.print(matrix[i][j] + " ");
				}
				
			}
			System.out.println();
		}
		setZero(matrix);
		
		System.out.println();
		
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				if (matrix[i][j]<10){
					System.out.print(matrix[i][j] + "  ");
				} else{
					System.out.print(matrix[i][j] + " ");
				}
				
			}
			System.out.println();
		}
	}
	
	public static void setZero(int[][] matrix){
		Vector<Integer> rows = new Vector<Integer>();
		Vector<Integer> cols = new Vector<Integer>();
		
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				if (matrix[i][j] == 0){
					if (!rows.contains(i)){
						rows.add(i);
					}
					if (!cols.contains(j)){
						cols.add(j);
					}
				}
			}
		}
		
		for (int i = 0; i<matrix.length; i++){
			for (int j = 0; j <matrix[i].length; j++){
				if (rows.contains(i) || cols.contains(j)){
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static String compress(String str){
		int count = 1;
		int i;
		
		StringBuffer myStr = new StringBuffer();
		for (i = 0; i < str.length()-1; i++){
			if (str.charAt(i)==str.charAt(i+1)){
				count++;
			} else {
				myStr.append(str.charAt(i));
				myStr.append(String.valueOf(count));
				count = 1;
			}
		}
		
		i--;
		if (str.charAt(i)==str.charAt(i+1)){
			myStr.append(str.charAt(i));
			myStr.append(String.valueOf(count));
		} else{
			count = 1;
			myStr.append(str.charAt(i+1));
			myStr.append(String.valueOf(count));
		}
		
		if (str.length() <= myStr.length()){
			return str;
		} else{
			return myStr.toString();
		}
	}
}
