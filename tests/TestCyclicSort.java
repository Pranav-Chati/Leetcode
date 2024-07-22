package tests;

import java.util.Arrays;

import leetcode.CyclicSort;

public class TestCyclicSort {
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;
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

    public static void main(String[] args) {
        testCyclicSort(new int[] { 3, 1, 5, 4, 2 });
        testCyclicSort(new int[] { 2, 6, 4, 3, 1, 5 });
        System.out.println();
    }
}
