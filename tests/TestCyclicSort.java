package tests;

import java.util.Arrays;
import java.util.List;

import leetcode.CyclicSort;

public class TestCyclicSort {
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }

    // Cyclic Sort
    public static void testCyclicSort(int[] input) {
        CyclicSort.cyclicSort(input);
        System.out.println("Result: " + Arrays.toString(input));
    }

    // Find the Missing Number
    public static void testFindTheMissingNumber(int[] input, int expected) {
        int result = CyclicSort.findTheMissingNumber(input);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("findTheMissingNumber: " + answer);
        } else {
            System.out.println("findTheMissingNumber");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // Find all Missing Numbers
    public static void testFindAllMissingNumbers(int[] input, int[] expected) {
        List<Integer> result = CyclicSort.findAllMissingNumbers(input);
        System.out.println("Result: " + result.toString());
        System.out.println("Expected: " + Arrays.toString(expected));
    }

    // Find the Duplicate Number
    public static void testFindTheDuplicateNumber(int[] input, int expected) {
        int result = CyclicSort.findTheDuplicateNumber(input);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("findTheDuplicateNumber: " + answer);
        } else {
            System.out.println("findTheDuplicateNumber");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // Find all Duplicate Numbers
    public static void testFindAllDuplicateNumbers(int[] input, int[] expected) {
        List<Integer> result = CyclicSort.findAllDuplicateNumbers(input);
        System.out.println("Result: " + result.toString());
        System.out.println("Expected: " + Arrays.toString(expected));
    }

    // Problem Challenge 1 - Find the Corrupt Pair
    public static void testFindCorruptPair(int[] input, int[] expected) {
        int[] result = CyclicSort.findCorruptPair(input);
        boolean answer = compareArrays(expected, result);
        if (answer) {
            System.out.println("findCorruptPair: " + answer);
        } else {
            System.out.println("findCorruptPair");
            System.out.println("Result: " + Arrays.toString(result));
            System.out.println("Expected: " + Arrays.toString(expected));
        }
    }

    // Problem Challenge 2 - Find the Smallest Missing Positive Number
    public static void testFindTheSmallestMissingPositiveNumber(int[] input, int expected) {
        int result = CyclicSort.findTheSmallestMissingPositiveNumber(input);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("findTheDuplicateNumber: " + answer);
        } else {
            System.out.println("findTheDuplicateNumber");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    public static void main(String[] args) {
        // Cyclic Sort
        testCyclicSort(new int[] { 3, 1, 5, 4, 2 });
        testCyclicSort(new int[] { 2, 6, 4, 3, 1, 5 });
        System.out.println();

        // Find the Missing Number
        testFindTheMissingNumber(new int[] { 4, 0, 3, 1 }, 2);
        testFindTheMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }, 7);
        System.out.println();

        // Find all Missing Numbers
        System.out.println("findAllMissingNumbers");
        testFindAllMissingNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 }, new int[] { 4, 6, 7 });
        testFindAllMissingNumbers(new int[] { 2, 4, 1, 2 }, new int[] { 3 });
        testFindAllMissingNumbers(new int[] { 2, 3, 2, 1 }, new int[] { 4 });
        System.out.println();

        // Find the Duplicate Number
        testFindTheDuplicateNumber(new int[] { 1, 4, 4, 3, 2 }, 4);
        testFindTheDuplicateNumber(new int[] { 2, 1, 3, 3, 5, 4 }, 3);
        testFindTheDuplicateNumber(new int[] { 2, 4, 1, 4, 4 }, 4);
        System.out.println();

        // Find all Duplicate Numbers
        testFindAllDuplicateNumbers(new int[] { 3, 4, 4, 5, 5 }, new int[] { 4, 5 });
        testFindAllDuplicateNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 }, new int[] { 3, 5 });
        System.out.println();

        // Problem Challenge 1 - Find the Corrupt Pair
        testFindCorruptPair(new int[] { 3, 1, 2, 5, 2 }, new int[] { 2, 4 });
        testFindCorruptPair(new int[] { 3, 1, 2, 3, 6, 4 }, new int[] { 3, 5 });
        System.out.println();

        // Problem Challenge 2 - Find the Smallest Missing Positive Number
        testFindTheSmallestMissingPositiveNumber(new int[] { -3, 1, 5, 4, 2 }, 3);
        testFindTheSmallestMissingPositiveNumber(new int[] { 3, -2, 0, 1, 2 }, 4);
        testFindTheSmallestMissingPositiveNumber(new int[] { 3, 2, 5, 1 }, 4);
        System.out.println();
    }
}
