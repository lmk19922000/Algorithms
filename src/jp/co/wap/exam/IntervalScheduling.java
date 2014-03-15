package jp.co.wap.exam;

import java.util.Arrays;
import java.util.List;

import jp.co.wap.exam.lib.Interval;

public class IntervalScheduling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Interval> list1 = Arrays.asList(new Interval("08:00", "10:00"),
				new Interval("08:00", "11:00"), new Interval("11:00", "12:00"),
				new Interval("08:00", "14:00"), new Interval("12:00", "15:00"),
				new Interval("13:00", "15:00"));
		System.out.println(schedule(list1));

	}

	public static int schedule(List<Interval> list) {
		if (list == null || list.size() == 0) {
			return 0;
		}

		Interval[] times; // array of sorted intervals

		int[] countArray = new int[1441]; // There are at most 24*60+1 = 1441
											// different times
		times = new Interval[list.size()];

		int timeInMinute;

		// Calculating frequencies
		for (int i = 0; i < list.size(); i++) {
			timeInMinute = list.get(i).getEndMinuteUnit();
			countArray[timeInMinute]++;
		}

		// Accumulating
		int total = 0;
		for (int i = 0; i < countArray.length; i++) {
			countArray[i] = countArray[i] + total;
			total = countArray[i];
		}

		// Sort intervals based on end time
		for (int i = list.size() - 1; i >= 0; i--) {
			timeInMinute = list.get(i).getEndMinuteUnit();
			countArray[timeInMinute]--;
			times[countArray[timeInMinute]] = list.get(i);
		}

		int ans = 0;
		int conflictTime = -1;
		for (int i = 0; i < times.length; i++) {
			if (times[i].getBeginMinuteUnit() > conflictTime) {
				ans++;
				conflictTime = times[i].getEndMinuteUnit();
			}
		}

		return ans;
	}
}
