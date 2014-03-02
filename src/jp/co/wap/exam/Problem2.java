package jp.co.wap.exam;

import java.util.List;
import jp.co.wap.exam.lib.Interval;

public class Problem2 {
	int[] compatibleIntervals;
	int[] maxWorkingTimes;
	Interval[] times; // array of sorted intervals

	/**
	 * 
	 * @author Le Minh Khue
	 * 
	 *         Idea: First sort the intervals based on end time. Then use
	 *         dynamic programming to compute the max working time possible
	 */
	public int getMaxWorkingTime(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0){
			return 0;
		}
		
		int[] countArray = new int[1441]; // There are at most 24*60+1 = 1441
											// different times
		times = new Interval[intervals.size()];

		int timeInMinute;

		// Calculating frequencies
		for (int i = 0; i < intervals.size(); i++) {
			timeInMinute = intervals.get(i).getEndMinuteUnit();
			countArray[timeInMinute]++;
		}

		// Accumulating
		int total = 0;
		for (int i = 0; i < countArray.length; i++) {
			countArray[i] = countArray[i] + total;
			total = countArray[i];
		}

		// Sort intervals based on end time
		for (int i = intervals.size() - 1; i >= 0; i--) {
			timeInMinute = intervals.get(i).getEndMinuteUnit();
			countArray[timeInMinute]--;
			times[countArray[timeInMinute]] = intervals.get(i);
		}

		// Initialization
		compatibleIntervals = new int[intervals.size()];
		for (int i = 0; i < compatibleIntervals.length; i++) {
			compatibleIntervals[i] = -1;
		}

		// For each interval i, find largest interval j that is compatible with
		// i such that j<i
		for (int i = 0; i < times.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (times[j].getEndMinuteUnit() < times[i].getBeginMinuteUnit()) {
					compatibleIntervals[i] = j;
					break;
				}
			}
		}

		maxWorkingTimes = new int[intervals.size()];

		return computeMaxWorkingTime(intervals.size() - 1);
	}

	/**
	 * 
	 * @author Le Minh Khue
	 * 
	 *         Dynamic programming
	 *         maxWorkingTime(i) is the maxWorkingTime
	 *         consisting of intervals from 0 up to and include i
	 * 
	 *         maxWorkingTime(i) = interval (0) if i == 0
	 *         maxWorkingTime(i) = max (maxWorkingTime(i-1), maxWorkingTime(compatibleIntervals[i])+interval(i)) otherwise
	 * 
	 */
	private int computeMaxWorkingTime(int index) {
		if (index < 0) {
			return 0;
		}

		if (maxWorkingTimes[index] != 0) {
			return maxWorkingTimes[index];
		}

		return Math.max(computeMaxWorkingTime(index - 1),
				computeMaxWorkingTime(compatibleIntervals[index])
						+ times[index].getIntervalMinute());
	}
}