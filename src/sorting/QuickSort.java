package sorting;

import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		int[] inputArr = new int[] { 4, 5, 7, 2, 3, 11, 5, 87, 3, 65, 9, 34,
				43, 27, 48, 1 ,22};
		
		for (int i = 0; i < inputArr.length; i++) {
			System.out.print(inputArr[i] + " ");
		}
		System.out.println();
		
		quickSort(inputArr, 0, inputArr.length - 1);

		for (int i = 0; i < inputArr.length; i++) {
			System.out.print(inputArr[i] + " ");
		}
	}

	private static void quickSort(int[] inputArr, int first, int last) {
		if (last <= first) {
			return;
		}
		
		int pivotInitialIndex, pivotCorrectIndex;
		
		Random randomGenerator = new Random();
		pivotInitialIndex = randomGenerator.nextInt(last - first + 1)
				+ first;
		
		pivotCorrectIndex = partition(inputArr, pivotInitialIndex, first, last);
		quickSort(inputArr, first, pivotCorrectIndex - 1);
		quickSort(inputArr, pivotCorrectIndex + 1, last);
	}

	private static int partition(int[] inputArr, int pivotInitialIndex,
			int first, int last) {
		int j, temp, pivot;
		pivot = inputArr[pivotInitialIndex];
		j = last;
		
		for (int k = first; k <=last; k++){
			if (k > j){
				break;
			}			
			
			if (inputArr[k]>pivot){
				while (inputArr[j] > pivot && j>=k){
					j--;
				}
				
				if (j>k){
					temp = inputArr[k];
					inputArr[k] = inputArr[j];
					inputArr[j] = temp;
					j--;
				}
			}
		}
		
		// find the pivot
		for (int k = first;  k <= last; k++){
			if (inputArr[k]==pivot){
				temp = inputArr[k];
				inputArr[k]=inputArr[j];
				inputArr[j]=temp;
				break;
			}
		}
		
		return j;
	}

}
