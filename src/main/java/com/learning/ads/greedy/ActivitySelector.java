package com.learning.ads.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * An introductory problem for greedy approach.
 * 
 * Statement: For a given set of activities (with start time and end time) and share a resource, find the optimal way to
 * scheduling these activities so that maximum number of activities can use resource. In other words find the maximum
 * set of mutually disjoint activities which can share resource.
 * 
 * See CLRS Ed 3, Ch 16 for more details
 * 
 * @author Arun Rahul
 *
 */
public class ActivitySelector {

	public List<Activity> activities;

	public class Activity implements Comparable<Activity> {

		private int startsAt;
		private int endsAt;

		public Activity(int startsAt, int endsAt) {
			this.startsAt = startsAt;
			this.endsAt = endsAt;
		}

		public int getStartsAt() {
			return startsAt;
		}

		public int getEndsAt() {
			return endsAt;
		}

		@Override
		public int compareTo(Activity o) {
			if (o == null)
				return 0;
			return Integer.compare(this.endsAt, o.endsAt);
		}

		public String toString() {
			return this.startsAt + ":" + this.endsAt;
		}

	}

	public ActivitySelector() {
		activities = new ArrayList<>();
	}

	public boolean addActivity(int startsAt, int endsAt) {
		if (startsAt >= endsAt)
			return false;
		return activities.add(new Activity(startsAt, endsAt));
	}

	/**
	 * Complexity: O(nlogn) + O(n) = O(nlogn)
	 * 
	 * O(nlogn) is for sorting
	 * 
	 * @return
	 */
	public int[][] select() {
		activities.sort((a1, a2) -> Integer.compare(a1.endsAt, a2.endsAt));
		return toArray(selectRec(-1));
	}

	/**
	 * 
	 * Complexity: O(n)
	 * 
	 * @param previousEndIndex
	 * @return
	 */
	private List<Activity> selectRec(int previousEndIndex) {
		int m = previousEndIndex + 1;
		while (previousEndIndex >= 0 && m < activities.size()
				&& activities.get(m).startsAt < activities.get(previousEndIndex).endsAt) {
			m++;
		}
		List<Activity> result = new ArrayList<>();
		if (m < activities.size()) {
			result.add(activities.get(m));
			result.addAll(selectRec(m));
			return result;
		}
		return result;

	}

	/**
	 * Complexity: O(nlogn) + O(n) = O(nlogn)
	 * 
	 * O(nlogn) is for sorting
	 * 
	 * @return
	 */
	public int[][] selectIterative() {
		activities.sort((a1, a2) -> Integer.compare(a1.endsAt, a2.endsAt));
		List<Activity> list = new ArrayList<>();
		// always select the first one as it is the one which ends earlier due to the sorting we did above
		list.add(activities.get(0));
		int previousEndIndex = 0;
		for (int i = 1; i < activities.size(); i++) {
			if (activities.get(i).startsAt >= activities.get(previousEndIndex).endsAt) {
				previousEndIndex = i;
				list.add(activities.get(i));
			}
		}
		return toArray(list);
	}

	private int[][] toArray(List<Activity> list) {
		int[][] result = new int[2][list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[0][i] = list.get(i).startsAt;
			result[1][i] = list.get(i).endsAt;
		}
		return result;
	}

}
