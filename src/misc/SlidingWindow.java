package misc;

public class SlidingWindow {

	public static void main(String[] args) {
		int[] list = new int[]{1, 4, 3, 7, 3, 8, 2, 10, 8, 4, 5, 3, 2, 1};
		printMin(list);
	}

	public static void printMin(int[] list){
		int temp;
		for (int i = 0; i<list.length-2; i++){
			if(list[i] <= list[i+1] && list[i]<=list[i+2]){
				temp = list[i];
			} else if(list[i+1] <=list[i] && list[i+1]<list[i+2]){
				temp = list[i+1];
			} else {
				temp = list[i+2];
			}
			System.out.print(temp + " ");
		}
	}
}
