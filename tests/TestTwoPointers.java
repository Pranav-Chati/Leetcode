package tests;

import java.util.Arrays;
import java.util.List;

import leetcode.TwoPointers;

public class TestTwoPointers {
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }

    public static boolean compare2DArrays(List<List<Integer>> arr1, List<List<Integer>> arr2) {
        if (arr1.size() != arr2.size())
            return false;
        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr2.get(i).size(); j++) {
                if (arr1.get(i).get(j) != arr2.get(i).get(j))
                    return false;
            }
        }

        return true;
    }

    // Pair with Target Sum
    public static void testPairWithTargetSum(int[] input, int target, int[] expected) {
        int[] result = TwoPointers.pairWithTargetSum(input, target);
        boolean answer = compareArrays(result, expected);

        if (answer) {
            System.out.println("pairWithTargetSum: " + answer);
        } else {
            System.out.println("pairWithTargetSum");
            System.out.println("Result: " + Arrays.toString(result));
            System.out.println("Expected: " + Arrays.toString(expected));
        }
    }

    // Remove Duplicates
    public static void testRemoveDuplicates(int[] input, int expected) {
        int result = TwoPointers.removeDuplicates(input);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("removeDuplicates: " + answer);
        } else {
            System.out.println("removeDuplicates");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // Squaring a Sorted Array
    public static void testSquaringSortedArray(int[] input, int[] expected) {
        int[] result = TwoPointers.squaringSortedArray(input);
        boolean answer = compareArrays(result, expected);

        if (answer) {
            System.out.println("squaringSortedArray: " + answer);
        } else {
            System.out.println("squaringSortedArray");
            System.out.println("Result: " + Arrays.toString(result));
            System.out.println("Expected: " + Arrays.toString(expected));
        }
    }

    // Triplet Sum to Zero
    public static void testTripletSumToZero(int[] input, int[][] expected) {
        List<List<Integer>> result = TwoPointers.tripletSumToZero(input);

        System.out.println("squaringSortedArray");
        System.out.println("Result: " + result.toString());
        System.out.print("Expected: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(Arrays.toString(expected[i]));
        }
        System.out.println();
    }

    // Triplet Sum Close to Target
    public static void testTripletSumCloseToTarget(int[] input, int target, int expected) {
        int result = TwoPointers.tripletSumCloseToTarget(input, target);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("tripletSumCloseToTarget: " + answer);
        } else {
            System.out.println("tripletSumCloseToTarget");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // Triplets with Smaller Sum
    public static void testTripletsWithSmallerSum(int[] input, int target, int expected) {
        int result = TwoPointers.tripletsWithSmallerSum(input, target);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("tripletsWithSmallerSum: " + answer);
        } else {
            System.out.println("tripletsWithSmallerSum");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // Dutch National Flag Problem
    public static void testDutchNationalProblem(int[] input, int[] expected) {
        TwoPointers.dutchNationalProblem(input);
        boolean answer = compareArrays(input, expected);

        if (answer) {
            System.out.println("dutchNationalProblem: " + answer);
        } else {
            System.out.println("dutchNationalProblem");
            System.out.println("Result: " + Arrays.toString(input));
            System.out.println("Expected: " + Arrays.toString(expected));
        }
    }

    public static void main(String[] args) {
        // Pair with Target Sum
        testPairWithTargetSum(new int[] { 1, 2, 3, 4, 6 }, 6, new int[] { 1, 3 });
        testPairWithTargetSum(new int[] { 2, 5, 9, 11 }, 11, new int[] { 0, 2 });
        System.out.println();

        // Remove Duplicates
        testRemoveDuplicates(new int[] { 2, 3, 3, 3, 6, 9, 9 }, 4);
        testRemoveDuplicates(new int[] { 2, 2, 2, 11 }, 2);
        System.out.println();

        // Squaring a Sorted Array
        testSquaringSortedArray(new int[] { -2, -1, 0, 2, 3 }, new int[] { 0, 1, 4, 4, 9 });
        testSquaringSortedArray(new int[] { -3, -1, 0, 1, 2 }, new int[] { 0, 1, 1, 4, 9 });
        System.out.println();

        // Triplet Sum to Zero
        testTripletSumToZero(new int[] { -5, 2, -1, -2, 3 },
                new int[][] { new int[] { -5, 2, 3 }, new int[] { -2, -1, 3 } });
        System.out.println();

        // Triplet Sum Close to Target
        testTripletSumCloseToTarget(new int[] { -2, 0, 1, 2 }, 2, 1);
        testTripletSumCloseToTarget(new int[] { -3, -1, 1, 2 }, 1, 0);
        testTripletSumCloseToTarget(new int[] { 1, 0, 1, 1 }, 100, 3);
        System.out.println();

        // Triplets with Smaller Sum
        testTripletsWithSmallerSum(new int[] { -1, 0, 2, 3 }, 3, 2);
        testTripletsWithSmallerSum(new int[] { -1, 4, 2, 1, 3 }, 5, 4);
        System.out.println();

        // Dutch National Flag Problem
        testDutchNationalProblem(new int[] { 1, 0, 2, 1, 0 }, new int[] { 0, 0, 1, 1, 2 });
        testDutchNationalProblem(new int[] { 2, 2, 0, 1, 2, 0 }, new int[] { 0, 0, 1, 2, 2, 2 });
        System.out.println();
    }
}
