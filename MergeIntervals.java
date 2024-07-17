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
}
