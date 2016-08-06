package misc;

public class PartitionArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = new int[]{0,1,1,0,0,1,1,0,1,1,0,1};
		partition2Elements(arr1);
		
		for (int i = 0; i<arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		
		int[] arr2 = new int[]{0,1,2,1,2,0,0,1,1,0,1,1,0,1,2,0,2,1,2,2,1,0};
		partition3Elements(arr2);
		
		for (int i = 0; i<arr2.length; i++){
			System.out.print(arr2[i] + " ");
		}
	}
	
	// Partition array consisting of 0 and 1
	public static void partition2Elements(int[] arr){
		int i, j, temp;
		i = 0;
		j = arr.length-1;
		
		while (i < j){
			while (arr[i] == 0){
				i++;
			}
			while (arr[j] == 1){
				j--;
			}
			
			if (i < j){
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
	}
	
	// Partition array consisting of 0, 1 and 2
	public static void partition3Elements(int[] arr){
		int i, j, temp;
		
		i = 0;
		j = arr.length-1;
		
		for (int k = 0; k<=j;){
			if (arr[k] == 0){
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				k++;
				i++;
			} else if(arr[k] == 2){
				temp = arr[k];
				arr[k] = arr[j];
				arr[j] = temp;
				j--;
			} else{
				k++;
			}
		}
	}
}
