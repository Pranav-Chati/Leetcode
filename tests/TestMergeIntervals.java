package tests;

import java.util.ArrayList;
import java.util.List;

import helper.Interval;
import leetcode.MergedIntervals;

public class TestMergeIntervals {
    // Merge Intervals
    public static void testMergeIntervalsList() {
        System.out.println("mergeIntervalsList");
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        for (Interval interval : MergedIntervals.mergeIntervalsList(input)) {
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        }
        System.out.println("\t [[1,5], [7,9]]");

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        for (Interval interval : MergedIntervals.mergeIntervalsList(input)) {
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        }
        System.out.println("\t [[2,4], [5,9]]");
    }

    // Insert Interval
    public static void testInsertInterval() {
        System.out.println("insertInterval");
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        for (Interval interval : MergedIntervals.insertInterval(input, new Interval(4, 6))) {
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        }
        System.out.println("\n[[1,3], [4,7], [8,12]]");
    }

    // Intervals Intersection
    public static void testIntervalsIntersection() {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6),
                new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7)
        };
        Interval[] result = MergedIntervals.intervalsIntersection(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println("\t [2, 3], [5, 6], [7, 7]");

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = MergedIntervals.intervalsIntersection(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println("\t [5, 7], [9, 10]");
    }

    // Conflicting Appointments
    public static void testConflictingAppointment(Interval[] input, boolean expected) {
        boolean result = MergedIntervals.conflictingAppointment(input);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("conflictingAppointment: " + answer);
        } else {
            System.out.println("conflictingAppointment");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    public static void main(String[] args) {
        // Merge Intervals
        testMergeIntervalsList();
        System.out.println();

        // Insert Interval
        testInsertInterval();
        System.out.println();

        // Intervals Intersection
        testIntervalsIntersection();
        System.out.println();

        // Conflicting Appointments
        testConflictingAppointment(new Interval[] { new Interval(1, 4), new Interval(2, 5),
                new Interval(7, 9) }, false);
        testConflictingAppointment(new Interval[] { new Interval(6, 7), new Interval(2, 4),
                new Interval(8, 12) }, true);
        testConflictingAppointment(new Interval[] { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) },
                false);
    }
}