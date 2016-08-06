package sorting;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] inputArr = new int[]{4,5,7,2,3,11,5,87,3,65,9,34,43,27,48,1};
		
		mergeSort(inputArr, 0, inputArr.length-1);
		
		for (int i = 0; i <inputArr.length; i++){
			System.out.print(inputArr[i] + " ");
		}
	}

	private static void mergeSort(int[] inputArr, int index1, int index2) {	
		if (index2-index1 <= 0){
			return;
		}
		
		mergeSort(inputArr, index1, (index2+index1)/2);
		mergeSort(inputArr, (index2+index1)/2+1, index2);
		
		merge(inputArr, index1, (index2+index1)/2, index2);
	}

	private static void merge(int[] inputArr, int index1, int mid, int index2) {		
		int[] tempArr = new int[inputArr.length];
		int i, j, counter;
		
		for (i = 0; i <index1; i++){
			tempArr[i] = inputArr[i];
		}
		for (i = index2+1; i <inputArr.length; i++){
			tempArr[i] = inputArr[i];
		}
		
		i = index1;
		j = mid+1;
		counter = index1;
		while (i<=mid && j<=index2){
			if (inputArr[i] <= inputArr[j]){
				tempArr[counter] = inputArr[i];
				i++;
			} else{
				tempArr[counter] = inputArr[j];
				j++;
			}
			counter++;
		}
		
		while(i<=mid){
			tempArr[counter] = inputArr[i];
			i++;
			counter++;
		}
		
		while (j<=index2){
			tempArr[counter] = inputArr[j];
			j++;
			counter++;
		}
		
		for (i = 0; i<inputArr.length; i++){
			inputArr[i]= tempArr[i];
		}
	}
}
