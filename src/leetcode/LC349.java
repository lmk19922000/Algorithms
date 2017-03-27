package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC349 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {};
		int[] nums2 = { 2, 2 };

		System.out.println(Arrays.toString(intersection(nums1, nums2)));

	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		Set<Integer> ans = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], true);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (map.get(nums2[i]) == Boolean.TRUE) {
				ans.add(nums2[i]);
			}
		}

		int[] a = new int[ans.size()];
		int i = 0;
		for (Integer num : ans) {
			a[i] = num;
			i++;
		}
		return a;
	}
}
