package tests;

import java.util.Arrays;

import leetcode.SlidingWindow;

public class TestSlidingWindow {
    public static void testPairOfContiguousSubarrays() {
        int[] input = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
        int k = 5;

        double[] result = SlidingWindow.pairOfContiguousSubarrays(input, k);
        double[] expected = new double[] { 2.2, 2.8, 2.4, 3.6, 2.8 };
        System.out.println("pairOfContiguousSubarrays");
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("Expected: " + Arrays.toString(expected));
    }

    public static void testMaxSumSubarrayOfSizeK(int[] input, int k, int expected) {
        int result = SlidingWindow.maxSumSubarrayOfSizeK(input, k);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("maxSumSubarrayOfSizeK: " + answer);
        } else {
            System.out.println("maxSumSubarrayOfSizeK");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    public static void testSmallestSubarrayWithGivenSum(int[] input, int S, int expected) {
        int result = SlidingWindow.smallestSubarrayWithGivenSum(input, S);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("smallestSubarrayWithGivenSum: " + answer);
        } else {
            System.out.println("smallestSubarrayWithGivenSum");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // Longest Substring with K Distinct Characters
    public static void testLongestSubstringWithKDistinctCharacters(String word, int K, int expected) {
        int result = SlidingWindow.longestSubstringWithKDistinctCharacters(word, K);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("longestSubstringWithKDistinctCharacters: " + answer);
        } else {
            System.out.println("longestSubstringWithKDistinctCharacters");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // Fruits into Baskets
    public static void testFruitsIntoBaskets(char[] fruit, int expected) {
        int result = SlidingWindow.fruitsIntoBasket(fruit);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("fruitsIntoBasket: " + answer);
        } else {
            System.out.println("fruitsIntoBasket");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // No-repeat Substring
    public static void testNoRepeatSubstring(String word, int expected) {
        int result = SlidingWindow.noRepeatSubstring(word);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("noRepeatSubstring: " + answer);
        } else {
            System.out.println("noRepeatSubstring");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // Longest Substring with Same Letters after Replacement
    public static void testLongestSubstringWithSameLettersAfterReplacement(String word, int K, int expected) {
        int result = SlidingWindow.longestSubstringWithSameLettersAfterReplacement(word, K);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("longestSubstringWithSameLettersAfterReplacement: " + answer);
        } else {
            System.out.println("longestSubstringWithSameLettersAfterReplacement");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // Longest Subarray with Ones after Replacement
    public static void testLongestSubarrayWithOnesAfterReplacement(int[] input, int k, int expected) {
        int result = SlidingWindow.longestSubarrayWithOnesAfterReplacement(input, k);
        boolean answer = result == expected;

        if (answer) {
            System.out.println("longestSubarrayWithOnesAfterReplacement: " + answer);
        } else {
            System.out.println("longestSubarrayWithOnesAfterReplacement");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    public static void main(String[] args) {
        // Introduction
        testPairOfContiguousSubarrays();
        System.out.println();

        // Maximum Sum Subarray of Size K
        testMaxSumSubarrayOfSizeK(new int[] { 2, 1, 5, 1, 3, 2 }, 3, 9);
        testMaxSumSubarrayOfSizeK(new int[] { 2, 3, 4, 1, 5 }, 2, 7);
        System.out.println();

        // Smallest Subarray with a given sum
        testSmallestSubarrayWithGivenSum(new int[] { 2, 1, 5, 2, 3, 2 }, 7, 2);
        testSmallestSubarrayWithGivenSum(new int[] { 2, 1, 5, 2, 8 }, 7, 1);
        testSmallestSubarrayWithGivenSum(new int[] { 3, 4, 1, 1, 6 }, 8, 3);
        System.out.println();

        // Longest Substring with K Distinct Characters
        testLongestSubstringWithKDistinctCharacters("araaci", 2, 4);
        testLongestSubstringWithKDistinctCharacters("araaci", 1, 2);
        testLongestSubstringWithKDistinctCharacters("cbbebi", 3, 5);
        System.out.println();

        // Fruits into Baskets
        testFruitsIntoBaskets(new char[] { 'A', 'B', 'C', 'A', 'C' }, 3);
        testFruitsIntoBaskets(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }, 5);
        System.out.println();

        // No-repeat Substring
        testNoRepeatSubstring("aabccbb", 3);
        testNoRepeatSubstring("abbbb", 2);
        testNoRepeatSubstring("abccde", 3);
        System.out.println();

        // Longest Substring with Same Letters after Replacement
        testLongestSubstringWithSameLettersAfterReplacement("aabccbb", 2, 5);
        testLongestSubstringWithSameLettersAfterReplacement("abbcb", 1, 4);
        testLongestSubstringWithSameLettersAfterReplacement("abccde", 1, 3);
        System.out.println();

        // Longest Subarray with Ones after Replacement
        testLongestSubarrayWithOnesAfterReplacement(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2, 6);
        testLongestSubarrayWithOnesAfterReplacement(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3, 9);
    }
}
