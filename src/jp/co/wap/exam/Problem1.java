package jp.co.wap.exam;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

import jp.co.wap.exam.lib.Interval;
import jp.co.wap.exam.lib.TimeInteger;

public class Problem1 {
	/**
	 * @author Le Minh Khue
	 * 
	 *         Idea: We get all start and end time of all intervals and sort
	 *         them. If start and end times are equal, start time is considered
	 *         "smaller". Then we iterate through the sorted times, if we
	 *         encounter a start time, we increase the counter by 1, otherwise, we
	 *         decrease the counter by 1. The maximum of the counter at all time
	 *         will be returned as the answer.
	 * 
	 *         There are two implementations of this method. One uses Java
	 *         Collections sort method (implement merge sort algorithm) and one
	 *         uses counting sort algorithm. The performance of counting sort is
	 *         better in this case
	 */
	public int getMaxIntervalOverlapCount(List<Interval> intervals) {
		//return getMaxIntervalOverlapCountUsingMergeSort(intervals);

		return getMaxIntervalOverlapCountUsingCountingSort(intervals);
	}

	/**
	 * @author Le Minh Khue
	 * 
	 *         Make use of counting sort
	 */
	private int getMaxIntervalOverlapCountUsingCountingSort(
			List<Interval> intervals) {
		int[] countArray = new int[1441]; // There are at most 24*60+1 = 1440
											// different times
		TimeInteger[] times = new TimeInteger[2 * intervals.size()]; // array of
																		// sorted
																		// times
		int timeInMinute;

		// Calculating frequencies
		for (int i = 0; i < intervals.size(); i++) {
			timeInMinute = intervals.get(i).getBeginMinuteUnit();
			countArray[timeInMinute]++;
			timeInMinute = intervals.get(i).getEndMinuteUnit();
			countArray[timeInMinute]++;
		}

		// Accumulating
		int total = 0;
		for (int i = 0; i < countArray.length; i++) {
			countArray[i] = countArray[i] + total;
			total = countArray[i];
		}

		// Sort, we insert end time to the sorted array first
		// because we want start time is "smaller" than end time if they have
		// the same integer representation
		for (int i = intervals.size() - 1; i >= 0; i--) {
			timeInMinute = intervals.get(i).getEndMinuteUnit();
			countArray[timeInMinute]--;
			times[countArray[timeInMinute]] = new TimeInteger(timeInMinute,
					false);
		}

		for (int i = intervals.size() - 1; i >= 0; i--) {
			timeInMinute = intervals.get(i).getBeginMinuteUnit();
			countArray[timeInMinute]--;
			times[countArray[timeInMinute]] = new TimeInteger(timeInMinute,
					true);
		}

		int count = 0;
		int maxOverlap = 0;

		for (int i = 0; i < times.length; i++) {
			if (times[i].isStartingTime()) {
				count++;
			} else {
				count--;
			}

			if (count > maxOverlap) {
				maxOverlap = count;
			}
		}

		return maxOverlap;
	}

	/**
	 * @author Le Minh Khue
	 * 
	 *         Make use of merge sort
	 */
	private int getMaxIntervalOverlapCountUsingMergeSort(
			List<Interval> intervals) {
		List<TimeInteger> times = new Vector<TimeInteger>();

		Interval currentInterval;
		for (int i = 0; i < intervals.size(); i++) {
			currentInterval = intervals.get(i);
			times.add(new TimeInteger(currentInterval.getBeginMinuteUnit(),
					true));
			times.add(new TimeInteger(currentInterval.getEndMinuteUnit(), false));
		}

		Collections.sort(times);

		int count = 0;
		int maxOverlap = 0;

		for (int i = 0; i < times.size(); i++) {
			if (times.get(i).isStartingTime()) {
				count++;
			} else {
				count--;
			}

			if (count > maxOverlap) {
				maxOverlap = count;
			}
		}

		return maxOverlap;
	}

}
