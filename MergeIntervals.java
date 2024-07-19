import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class MergeIntervals {
    /*
     * review: merge intervals
     * Given a list of intervals, merge all the overlapping intervals to produce a
     * list that has only mutually exclusive intervals.
     */
    public static int[][] mergeIntervals(int[][] nums) {
        // sort it however
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> mergedIntervals = new ArrayList<>();

        int i = 0;
        int start = nums[0][0];
        int end = nums[0][1];
        while (i < nums.length) {
            i++;
            int[] current = nums[i];
            if (end < current[0]) {
                mergedIntervals.add(Arrays.asList(start, end));
                start = current[0];
                end = current[1];
            } else {
                end = Math.max(end, current[1]);
            }
        }

        int[][] merged = new int[mergedIntervals.size()][2];
        for (i = 0; i < mergedIntervals.size(); i++) {
            Object[] temp = mergedIntervals.get(i).toArray();
            merged[i] = Arrays.stream(temp).mapToInt(o -> (int) o).toArray();
        }
        return merged;

    }

    public static List<Interval> mergeIntervalsList(List<Interval> intervals) {
        // this verison is weird deals with iterators and everything
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // Assuming array has been sorted by list times
        List<Interval> mergedIntervals = new LinkedList<Interval>();
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
            } else
                end = Math.max(end, interval.end);
        }

        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }

    /*
     * problem: Insert Interval
     * Given a list of non-overlapping intervals sorted by their start time, insert
     * a given interval at the correct position and merge all necessary intervals to
     * produce a list that has only mutually exclusive intervals.
     */
    public static List<Interval> insertInteral(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            mergedIntervals.add(intervals.get(i++));

        int start = intervals.get(i).start;
        int end = intervals.get(i).end;
        while (i < intervals.size() && start < newInterval.end) {
            start = Math.min(intervals.get(i).start, newInterval.start);
            end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        mergedIntervals.add(new Interval(start, end));

        while (i < intervals.size()) {
            mergedIntervals.add(intervals.get(i++));
        }

        return mergedIntervals;
    }

    /*
     * Intervals Intersection
     */
    public static Interval[] intervalsIntersection(Interval[] arr1, Interval[] arr2) {
        if (arr1.length < arr2.length)
            return intervalsIntersection(arr2, arr1);
        List<Interval> intersectionIntervals = new ArrayList<>();

        for (int j = 0; j < arr2.length; j++) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i].end < arr2[j].start || arr2[j].end < arr1[i].start)
                    continue;
                int start = Math.max(arr1[i].start, arr2[j].start);
                int end = Math.min(arr1[i].end, arr2[j].end);
                intersectionIntervals.add(new Interval(start, end));
            }
        }
        Interval[] intervalArray = new Interval[intersectionIntervals.size()];
        intervalArray = intersectionIntervals.toArray(intervalArray);
        return intervalArray;
    }

    public static void main(String[] args) {
        // Intervals intersection
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = intervalsIntersection(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = intervalsIntersection(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
    }
}
