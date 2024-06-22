import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    /*
     * problem: merge intervals
     * Given a list of intervals, merge all the overlapping intervals to produce a
     * list that has only mutually exclusive intervals.
     */
    // public static int[] mergeIntervals(int[][] intervals) {
    // ArrayList<int[]> mergedIntervals = new ArrayList<>();
    // int index = 1;

    // for (int i = 0; i < intervals.length; i++) {
    // // if mergedIntervals is none then add that first merged value
    // if (mergedIntervals.size() == 0) {
    // mergedIntervals.add(intervals[i]);
    // } else {
    // for (int j = 0; j < mergedIntervals.size(); j++) {
    // int l1 = mergedIntervals[j][0];
    // int r1 = mergedIntervals[j][1];

    // for (int k = i + 1; k < intervals.length; k++) {
    // int l2 = intervals[k][0];
    // int r2 = intervals[k][0];

    // // the is in case does not matter since we aren't changing the merged
    // interval
    // if (l1 <= l2 && r2 <= r1) {
    // continue;
    // }
    // if (l1 > l2 && r2 <= r1) {
    // mergedIntervals[j] = new int[] { l2, r1 };
    // } else if (l1 <= l2 && r2 > r1) {
    // mergedIntervals[j] = new int[] { l1, r2 };
    // } else {
    // mergedIntervals.add(intervals[j]);
    // }
    // }

    // }
    // }
    // // if not, then for every next value we should comapre where the
    // mergedIntervals
    // // can consume any of the next ones
    // }

    // return new int[] {};
    // }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        java.util.Iterator<Interval> intervalItr = intervals.iterator();

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
