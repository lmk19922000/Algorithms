package jp.co.wap.exam;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import jp.co.wap.exam.lib.Interval;

public class IntervalPartitionning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Interval> list1 = Arrays.asList(new Interval("08:00", "10:00"), new Interval("11:00", "12:00"), new Interval("08:00", "14:00"),
				new Interval("13:00", "14:00"), new Interval("15:00", "16:00"));
		System.out.println(partition(list1));

	}
	
	public static int partition(List<Interval> intervals){
		if (intervals == null || intervals.size() == 0) {
			return 0;
		}

		Interval[] times; // array of sorted intervals

		int[] countArray = new int[1441]; // There are at most 24*60+1 = 1441
											// different times
		times = new Interval[intervals.size()];

		int timeInMinute;

		// Calculating frequencies
		for (int i = 0; i < intervals.size(); i++) {
			timeInMinute = intervals.get(i).getBeginMinuteUnit();
			countArray[timeInMinute]++;
		}

		// Accumulating
		int total = 0;
		for (int i = 0; i < countArray.length; i++) {
			countArray[i] = countArray[i] + total;
			total = countArray[i];
		}

		// Sort intervals based on begin time
		for (int i = intervals.size() - 1; i >= 0; i--) {
			timeInMinute = intervals.get(i).getBeginMinuteUnit();
			countArray[timeInMinute]--;
			times[countArray[timeInMinute]] = intervals.get(i);
		}
		
		Vector<Integer> lastBusyTimes = new Vector<Integer>();
		boolean canReuseLabel;
		
		for (int i = 0; i<times.length; i++){
			canReuseLabel = false;
			for (int j = 0; j<lastBusyTimes.size(); j++){
				if (times[i].getBeginMinuteUnit() > lastBusyTimes.get(j)){
					lastBusyTimes.set(j, times[i].getEndMinuteUnit());
					canReuseLabel = true;
					break;
				}
			}
			
			if (!canReuseLabel){
				lastBusyTimes.add(times[i].getEndMinuteUnit());
			}
		}
		
		return lastBusyTimes.size();
	}
}
