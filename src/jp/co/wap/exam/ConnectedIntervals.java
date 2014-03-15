package jp.co.wap.exam;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import jp.co.wap.exam.lib.Interval;

public class ConnectedIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interval i1 = new Interval("08:00", "10:00");
		Interval i2 = new Interval("13:00", "14:00");
		
		List<Interval> list1 = Arrays.asList(i1, i2, new Interval("10:00",
				"13:00"));
		
		//List<Interval> list1 = Arrays.asList(i1, i2);
		
		System.out.println(isConnected(list1, i1, i2));

	}

	public static boolean isConnected(List<Interval> list, Interval i1,
			Interval i2) {
		Vector<Vector<Integer>> adjList = new Vector<Vector<Integer>>();
		Interval interval1, interval2;
		Vector<Integer> tempList;

		// Build adjacency list
		for (int i = 0; i < list.size(); i++) {
			interval1 = list.get(i);
			tempList = new Vector<Integer>();
			for (int j = 0; j < list.size(); j++) {
				if (i == j) {
					continue;
				}

				interval2 = list.get(j);

				if (interval1.getBeginMinuteUnit() <= interval2
						.getEndMinuteUnit()
						&& interval1.getEndMinuteUnit() >= interval2
								.getBeginMinuteUnit()) {
					tempList.add(j);
				}
			}
			adjList.add(tempList);
		}

		// Breadth First Search
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[list.size()];

		int index1, index2;
		index1 = list.indexOf(i1);
		index2 = list.indexOf(i2);

		queue.offer(index1);

		int currIndex;
		while (!queue.isEmpty()) {
			currIndex = queue.poll();
			if (visited[currIndex] != 1) {
				for (int i = 0; i < adjList.get(currIndex).size(); i++) {
					queue.offer(adjList.get(currIndex).get(i));
				}

				visited[currIndex] = 1;
			}
		}

		if (visited[index2] == 1) {
			return true;
		}

		return false;
	}
}
