import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class MergeIntervals {
    /*
     * review: merge intervals
     * Given a list of intervals, merge all the overlapping intervals to produce a
     * list that has only mutually exclusive intervals.
     */
    public static int[][] mergeIntervals(int[][] nums) {
        // sort by start values
        Arrays.sort(nums, (a, b) -> Double.compare(a[0], b[0]));

        int i = 0;
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        int start = nums[i][0];
        int end = nums[i][1];

        while (i < nums.length) {
            i++; // increment the i
            if (end < nums[i][0]) {
                mergedIntervals.add(Arrays.asList(start, end));
                start = nums[i][0];
                end = nums[i][1];
            } else {
                end = Math.max(end, nums[i][1]);
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
        // sort the intervals by start
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator(); // what does this do??
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;

    }
}
