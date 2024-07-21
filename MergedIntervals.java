import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class MergedIntervals {
    /*
     * review: merge intervals
     * Given a list of intervals, merge all the overlapping intervals to produce a
     * list that has only mutually exclusive intervals.
     */
    public static int[][] mergeIntervals(int[][] nums) {
        // sort the array byt he star ttime
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));

        // Create merged Intervals
        int i = 0;
        int start = nums[i][0];
        int end = nums[i][1];
        List<List<Integer>> mergedIntervals = new ArrayList<>();

        while (i < nums.length) {
            i++;
            if (end < nums[i][0]) {
                mergedIntervals.add(Arrays.asList(start, end));
                start = nums[i][0];
                end = nums[i][1];
            } else
                end = Math.max(end, nums[i][1]);
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

        // Sort the array by the star titme
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new ArrayList<>();
        // start an iterator
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
     * review: Insert Interval
     * Given a list of non-overlapping intervals sorted by their start time, insert
     * a given interval at the correct position and merge all necessary intervals to
     * produce a list that has only mutually exclusive intervals.
     */
    public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            mergedIntervals.add(intervals.get(i++));

        int start = 0;
        int end = 0;
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            start = Math.min(intervals.get(i).start, newInterval.start);
            end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        mergedIntervals.add(new Interval(start, end));

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
        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            boolean aBeforeb = arr1[i].end < arr2[j].start;
            boolean bBeforea = arr2[j].end < arr1[i].start;
            if (!aBeforeb && !bBeforea) {
                int start = Math.max(arr1[i].start, arr2[j].start);
                int end = Math.min(arr1[i].end, arr2[j].end);
                mergedIntervals.add(new Interval(start, end));
            }

            if (arr1[i].end < arr2[j].end)
                i++;
            else
                j++;
        }

        return mergedIntervals.toArray(new Interval[mergedIntervals.size()]);
    }

    /*
     * problem: Conflicting Appointments
     * Given an array of intervals representing ‘N’ appointments, find out if a
     * person can attend all the appointments.
     */
    public static boolean conflictingAppointment(Interval[] intervals) {
        // Sort the array by time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervals.length; i++) {
            boolean aBeforeb = intervals[i - 1].end < intervals[i].start;
            if (!aBeforeb)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6),
        // new Interval(7, 9) };
        // Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7)
        // };
        // Interval[] result = intervalsIntersection(input1, input2);
        // System.out.print("Intervals Intersection: ");
        // for (Interval interval : result)
        // System.out.print("[" + interval.start + "," + interval.end + "] ");
        // System.out.println();

        // input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new
        // Interval(9, 12) };
        // input2 = new Interval[] { new Interval(5, 10) };
        // result = intervalsIntersection(input1, input2);
        // System.out.print("Intervals Intersection: ");
        // for (Interval interval : result)
        // System.out.print("[" + interval.start + "," + interval.end + "] ");
        // System.out.println();

        // Interval[] input = new Interval[] { new Interval(1, 4), new Interval(2, 5),
        // new Interval(7, 9) };
        // Interval[] input1 = new Interval[] { new Interval(6, 7), new Interval(2, 4),
        // new Interval(8, 12) };
        Interval[] input2 = new Interval[] { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };

        System.out.println(conflictingAppointment(input2));
    }

}