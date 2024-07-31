package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import helper.Interval;

public class MergedIntervals {
    /*
     * review: merge intervals
     * Given a list of intervals, merge all the overlapping intervals to produce a
     * list that has only mutually exclusive intervals.
     */
    public static int[][] mergeIntervals(int[][] nums) {

        // sort the array
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int start = nums[i][0];
        int end = nums[i][1];
        List<List<Integer>> mergedIntervals = new ArrayList<>();

        while (i < nums.length) {
            i++;
            int[] interval = nums[i];
            if (end < interval[0]) {
                mergedIntervals.add(Arrays.asList(start, end));
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }

        mergedIntervals.add(Arrays.asList(start, end));

        int[][] intervals = new int[mergedIntervals.size()][2];
        for (i = 0; i < mergedIntervals.size(); i++) {
            Object[] temp = mergedIntervals.get(i).toArray();
            intervals[i] = Arrays.stream(temp).mapToInt(o -> (int) o).toArray();
        }
        return intervals;
    }

    public static List<Interval> mergeIntervalsList(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new ArrayList<>();
        Iterator<Interval> iterator = intervals.iterator();
        Interval interval = iterator.next();
        int start = interval.start;
        int end = interval.end;

        while (iterator.hasNext()) {
            interval = iterator.next();
            if (end < interval.start) {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            } else {
                end = Math.max(end, interval.end);
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    /*
     * review: Insert Interval
     * Given a list of non-overlapping intervals sorted by their start time, insert
     * a given interval at the correct position and merge all necessary intervals to
     * produce a list that has only mutually exclusive intervals.
     */
    public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 0;

        // add all the intervals before the start new interval
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            mergedIntervals.add(intervals.get(i++));

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        mergedIntervals.add(newInterval);

        while (i < intervals.size())
            mergedIntervals.add(intervals.get(i++));

        return mergedIntervals;
    }

    /*
     * problem: Intervals Intersection
     * Given two lists of intervals, find the intersection of these two lists. Each
     * list consists of disjoint intervals sorted on their start time.
     */
    public static Interval[] intervalsIntersection(Interval[] arr1, Interval[] arr2) {
        int i = 0;
        int j = 0;
        List<Interval> intersection = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            boolean aAfterb = arr1[i].end < arr2[j].start;
            boolean bAftera = arr2[j].end < arr1[i].start;
            if (!aAfterb && !bAftera) {
                int start = Math.max(arr1[i].start, arr2[j].start);
                int end = Math.min(arr1[i].end, arr2[j].end);
                intersection.add(new Interval(start, end));
            }

            if (bAftera)
                j++;
            else
                i++;
        }

        return intersection.toArray(new Interval[intersection.size()]);
    }

    /*
     * problem: Conflicting Appointments
     * Given an array of intervals representing ‘N’ appointments, find out if a
     * person can attend all the appointments.
     */
    public static boolean conflictingAppointment(Interval[] intervals) {
        // sort the start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int i = 1;

        // check if there is an overalp => return false
        while (i < intervals.length) {
            boolean intervalDoesNotOverlap = intervals[i - 1].end < intervals[i].start;
            if (intervalDoesNotOverlap)
                i++;
            else
                return false;
        }

        return true;
    }
}