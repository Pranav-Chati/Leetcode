package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {
    /*
     * problem: Introduction
     * Given an array, find the average of all contiguous subarrays of size ‘K’ in
     * it.
     */
    public static double[] pairOfContiguousSubarrays(int[] nums, int K) {
        double[] average = new double[nums.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];
            if (windowEnd >= K - 1) {
                average[windowStart] = windowSum / K;
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return average;
    }

    /*
     * problem: Maximum Sum Subarray of Size K
     * Given an array of positive numbers and a positive number ‘k’, find the
     * maximum sum of any contiguous subarray of size ‘k’.
     */
    public static int maxSumSubarrayOfSizeK(int[] nums, int K) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            if (windowEnd >= K - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }

    /*
     * problem: Smallest Subarray with a given sum
     * Given an array of positive numbers and a positive number ‘S’, find the length
     * of the smallest contiguous subarray whose sum is greater than or equal to
     * ‘S’. Return 0, if no such subarray exists.
     */
    public static int smallestSubarrayWithGivenSum(int[] nums, int target) {

        int smallestSubarray = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            while (windowSum >= target) {
                smallestSubarray = Math.min(smallestSubarray, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return smallestSubarray == Integer.MAX_VALUE ? 0 : smallestSubarray;
    }

    /*
     * problem: Longest Substring with K Distinct Characters
     * Given a string, find the length of the longest substring in it with no more
     * than K distinct characters.
     */
    public static int longestSubstringWithKDistinctCharacters(String word, int K) {
        int windowStart = 0;
        int longestSubstring = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < word.length(); windowEnd++) {
            char currentChar = word.charAt(windowEnd);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);

            while (freqMap.size() > K) {
                char charToRemove = word.charAt(windowStart);
                freqMap.put(charToRemove, freqMap.get(charToRemove) - 1);
                if (freqMap.get(charToRemove) == 0)
                    freqMap.remove(charToRemove);

                windowStart++;
            }

            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1);
        }

        return longestSubstring;
    }

    /*
     * problem: Fruits into Basket
     * Given an array of characters where each character represents a fruit tree,
     * you are given two baskets and your goal is to put maximum number of fruits in
     * each basket. The only restriction is that each basket can have only one type
     * of fruit.
     * 
     * You can start with any tree, but once you have started you can’t skip a tree.
     * You will pick one fruit from each tree until you cannot, i.e., you will stop
     * when you have to pick from a third fruit type.
     * 
     * Write a function to return the maximum number of fruits in both the baskets.
     */
    public static int fruitsIntoBasket(char[] fruits) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;
        int maxFruits = 0;

        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            char currentFruit = fruits[windowEnd];
            freqMap.put(currentFruit, freqMap.getOrDefault(currentFruit, 0) + 1);

            while (freqMap.size() > 2) {
                char removeFruit = fruits[windowStart];
                freqMap.put(removeFruit, freqMap.get(removeFruit) - 1);
                if (freqMap.get(removeFruit) == 0)
                    freqMap.remove(removeFruit);
                windowStart++;
            }

            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
        }

        return maxFruits;
    }

    /*
     * problem: no-repeat substring
     * Given a string, find the length of the longest substring which has no
     * repeating characters.
     */
    public static int noRepeatSubstring(String word) {
        int windowStart = 0;
        int maxSubstring = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < word.length(); windowEnd++) {
            char currentChar = word.charAt(windowEnd);

            if (freqMap.containsKey(currentChar)) {
                windowStart = Math.max(windowStart, freqMap.get(currentChar) + 1);
            }
            freqMap.put(currentChar, windowEnd);
            maxSubstring = Math.max(maxSubstring, windowEnd - windowStart + 1);
        }

        return maxSubstring;
    }

    /*
     * problem: Longest Substring with Same Letters after Replacement
     * Given a string with lowercase letters only, if you are allowed to replace no
     * more than ‘k’ letters with any letter, find the length of the longest
     * substring having the same letters after replacement.
     */
    public static int longestSubstringWithSameLettersAfterReplacement(String word, int K) {
        int windowStart = 0;
        int maxRepeatLetters = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxSubstring = 0;

        for (int windowEnd = 0; windowEnd < word.length(); windowEnd++) {
            char currentChar = word.charAt(windowEnd);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
            maxRepeatLetters = Math.max(maxRepeatLetters, freqMap.get(currentChar));

            if (windowEnd - windowStart + 1 - maxRepeatLetters > K) {
                char charToRemove = word.charAt(windowStart);
                freqMap.put(charToRemove, freqMap.get(charToRemove) - 1);
                if (freqMap.get(charToRemove) == 0)
                    freqMap.remove(charToRemove);
                windowStart++;
            }

            maxSubstring = Math.max(maxSubstring, windowEnd - windowStart + 1);
        }

        return maxSubstring;
    }

    /*
     * problem: Longest Subarray with Ones after Replacement
     * Given an array containing 0s and 1s, if you are allowed to replace no more
     * than ‘k’ 0s with 1s, find the length of the longest contiguous subarray
     * having all 1s.
     */
    public static int longestSubarrayWithOnesAfterReplacement(int[] nums, int K) {
        int onesCount = 0;
        int longestSubstring = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 1)
                onesCount++;

            while (windowEnd - windowStart + 1 - onesCount > K) {
                if (nums[windowStart] == 1)
                    onesCount--;
                windowStart++;
            }

            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1);
        }

        return longestSubstring;
    }
}
