package misc;

import java.util.Random;

public class ShuffleButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] song = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		printSequence(song, 10);
	}
	
	public static void printSequence(int[] song, int n){
		int k = n;
		Random rand = new Random();
		while(k>0){
			int i = rand.nextInt(k);
			System.out.print(song[i] + " ");
			int temp = song[i];
			song[i] = song[k-1];
			song[k-1] = temp;
			k--;
		}
	}
}
