package Misc;

public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	static int[] arr = new int[]{1,7,6,5,6,8,15,1};
	static int[] memo = new int[arr.length];
	static int[] u = new int[arr.length];
	
	public static void main(String[] args) {
		memo[arr.length-1] = 1;
		
		for (int i = 0; i<u.length; i++){
			u[i] = -1;
		}
		
		System.out.println(getLIS(4));
		
		int curr = 4;
		while (curr!= -1){
			System.out.print(curr + " ");
			curr = u[curr];
		}
	}
	
	public static int getLIS(int i){
		if (i == arr.length-1)
			return 1;
		
		if (memo[i] != 0)
			return memo[i];
		
		int ans = 1, next = -1, prevAns;
		for (int j = i+1; j <arr.length-1; j++){
			if (arr[j] > arr[i]){
				prevAns = ans;
				ans = Math.max(ans, getLIS(j) + 1);
				if (prevAns != ans)
					next = j;
			}
		}
		
		memo[i] = ans;
		u[i] = next;
		
		return memo[i];
	}
}
