package leetcode;

import java.util.Arrays;

public class LC455 {

	public static void main(String[] args) {
		int[] g = { 1, 2 };
		int[] s = { 1, 2, 3 };
		System.out.println(findContentChildren(g, s));
	}

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int gCount = 0, sCount = 0, num = 0;
		while (gCount < g.length && sCount < s.length) {
			if (g[gCount] <= s[sCount]) {
				gCount++;
				num++;
			}
			sCount++;
		}

		return num;
	}
}
