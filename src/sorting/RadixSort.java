package sorting;

import java.util.PriorityQueue;
import java.util.Queue;

public class RadixSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Assume numbers have at most 5 digits
		int[] inputArr = new int[] { 453, 223, 71124, 22246, 33112, 11124,
				51234, 87223, 31245, 22, 61245, 223, 34112, 4388, 277, 4854, 1,
				22 };

		radixSort(inputArr);

		for (int i = 0; i < inputArr.length; i++) {
			System.out.print(inputArr[i] + " ");
		}
	}

	private static void radixSort(int[] inputArr) {
		Queue<Integer> queue0 = new PriorityQueue<Integer>();
		Queue<Integer> queue1 = new PriorityQueue<Integer>();
		Queue<Integer> queue2 = new PriorityQueue<Integer>();
		Queue<Integer> queue3 = new PriorityQueue<Integer>();
		Queue<Integer> queue4 = new PriorityQueue<Integer>();
		Queue<Integer> queue5 = new PriorityQueue<Integer>();
		Queue<Integer> queue6 = new PriorityQueue<Integer>();
		Queue<Integer> queue7 = new PriorityQueue<Integer>();
		Queue<Integer> queue8 = new PriorityQueue<Integer>();
		Queue<Integer> queue9 = new PriorityQueue<Integer>();

		int d = 5, temp, digit, counter;

		for (int i = 1; i <= d; i++) {
			for (int j = 0; j < inputArr.length; j++) {
				// Find the digit at this position
				temp = inputArr[j] % (int) Math.pow(10, i);
				digit = temp / (int) Math.pow(10, i-1);
				switch (digit) {
				case 0:
					queue0.add(inputArr[j]);
					break;
				case 1:
					queue1.add(inputArr[j]);
					break;
				case 2:
					queue2.add(inputArr[j]);
					break;
				case 3:
					queue3.add(inputArr[j]);
					break;
				case 4:
					queue4.add(inputArr[j]);
					break;
				case 5:
					queue5.add(inputArr[j]);
					break;
				case 6:
					queue6.add(inputArr[j]);
					break;
				case 7:
					queue7.add(inputArr[j]);
					break;
				case 8:
					queue8.add(inputArr[j]);
					break;
				case 9:
					queue9.add(inputArr[j]);
					break;
				}
			}
			
			counter = 0;
			while (!queue0.isEmpty()){
				inputArr[counter] = queue0.poll();
				counter++;
			}
			while (!queue1.isEmpty()){
				inputArr[counter] = queue1.poll();
				counter++;
			}
			while (!queue2.isEmpty()){
				inputArr[counter] = queue2.poll();
				counter++;
			}
			while (!queue3.isEmpty()){
				inputArr[counter] = queue3.poll();
				counter++;
			}
			while (!queue4.isEmpty()){
				inputArr[counter] = queue4.poll();
				counter++;
			}
			while (!queue5.isEmpty()){
				inputArr[counter] = queue5.poll();
				counter++;
			}
			while (!queue6.isEmpty()){
				inputArr[counter] = queue6.poll();
				counter++;
			}
			while (!queue7.isEmpty()){
				inputArr[counter] = queue7.poll();
				counter++;
			}
			while (!queue8.isEmpty()){
				inputArr[counter] = queue8.poll();
				counter++;
			}
			while (!queue9.isEmpty()){
				inputArr[counter] = queue9.poll();
				counter++;
			}
		}
	}

}
