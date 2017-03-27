package leetcode;

public class LC453 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE;
		int move = 0;
		for (int i : nums) {
			if (i < min) {
				min = i;
			}
		}
		for (int i : nums) {
			move = move + i - min;
		}

		return move;
	}
}
