package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class LC496 {
	public static void main(String[] args) {
		int[] arr1 = { 2, 4 };
		int[] arr2 = { 1, 2, 3, 4 };
		int[] arr = nextGreaterElement(arr1, arr2);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[i] > stack.peek()) {
				map.put(stack.pop(), nums[i]);
			}
			stack.push(nums[i]);
		}

		for (int i = 0; i < findNums.length; i++) {
			if (map.get(findNums[i]) == null) {
				findNums[i] = -1;
			} else {
				findNums[i] = map.get(findNums[i]);
			}
		}

		return findNums;
	}
}
