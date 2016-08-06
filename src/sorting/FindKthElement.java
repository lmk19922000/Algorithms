package sorting;

import java.util.Random;

public class FindKthElement {
	public static void main(String[] args) {
		int[] inputArr = new int[] { 4, 5, 7, 2, 3, 11, 5, 87, 3, 65, 9, 34,
				43, 27, 48, 1 ,22};
		
		for (int i = 0; i < inputArr.length; i++) {
			System.out.print(inputArr[i] + " ");
		}
		System.out.println();
		
		int ans = findKthElement(inputArr, 0, inputArr.length - 1, 8);

		System.out.print(ans);
	}

	private static int findKthElement(int[] inputArr, int first, int last, int k) {
		if (last <= first) {
			return inputArr[first];
		}
		
		int pivotInitialIndex, pivotCorrectIndex;
		
		Random randomGenerator = new Random();
		pivotInitialIndex = randomGenerator.nextInt(last - first + 1)
				+ first;
		
		pivotCorrectIndex = partition(inputArr, pivotInitialIndex, first, last);
		
		if (pivotCorrectIndex == k-1){
			return inputArr[pivotCorrectIndex];
		} else if (pivotCorrectIndex > k-1){
			return findKthElement(inputArr, first, pivotCorrectIndex - 1, k);
		} else {
			return findKthElement(inputArr, pivotCorrectIndex + 1, last, k);
		}
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
