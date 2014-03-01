package jp.co.wap.exam;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import jp.co.wap.exam.lib.Interval;

public class TestProblem {
	@Test
	public void testProblem1Usage() {
		Problem1 p = new Problem1();
		
		List<Interval> figure0 = Arrays.asList(new Interval("08:00", "10:00"), new Interval("09:00", "11:00"), new Interval("10:00", "12:00"),
												new Interval("10:00", "24:00"), new Interval("00:00", "08:00"), new Interval("11:00", "12:00"),
												new Interval("17:00", "18:00"), new Interval("17:00", "19:00"), new Interval("17:30", "19:00"),
												new Interval("16:00", "20:00"), new Interval("09:00", "13:00"), new Interval("09:00", "11:00"),
												new Interval("09:00", "24:00"), new Interval("16:00", "17:30"), new Interval("13:00", "18:00"));
		long startTime = System.nanoTime();
		//System.out.println(p.getMaxIntervalOverlapCount(figure0));
		p.getMaxIntervalOverlapCount(figure0);
		long endTime = System.nanoTime();

		System.out.println(endTime - startTime);
		
		// example: Figure 1
		Interval interval1 = new Interval("08:00", "12:00");
		Interval interval2 = new Interval("06:00", "09:00");
		Interval interval3 = new Interval("11:00", "13:30");
		List<Interval> figure1 = Arrays.asList(interval1, interval2, interval3);
		assertEquals(p.getMaxIntervalOverlapCount(figure1), 2);
		
		// example: Figure 2
		List<Interval> figure2 = Arrays.asList(new Interval("09:00", "12:30"),
				new Interval("06:00", "09:30"), new Interval("12:00", "14:30"),
				new Interval("10:00", "10:30"), new Interval("11:00", "13:30"));
		assertEquals(p.getMaxIntervalOverlapCount(figure2), 3);
	}
}
