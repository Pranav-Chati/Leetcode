import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {
    /*
     * review: Introduction
     * Given an array, find the average of all contiguous subarrays of size ‘K’ in
     * it.
     */
    public static double[] pairOfContiguousSubarrays(int[] nums, int K) {
        int windowStart = 0;
        double windowSum = 0;
        double[] average = new double[nums.length - K + 1];

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
     * review: Maximum Sum Subarray of Size K
     * Given an array of positive numbers and a positive number ‘k’, find the
     * maximum sum of any contiguous subarray of size ‘k’.
     */
    public static int maxSumSubarrayOfSizeK(int[] nums, int K) {
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;

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
     * review: Smallest Subarray with a given sum
     * Given an array of positive numbers and a positive number ‘S’, find the length
     * of the smallest contiguous subarray whose sum is greater than or equal to
     * ‘S’. Return 0, if no such subarray exists.
     */
    public static int smallestSubarrayWithGivenSum(int[] nums, int target) {
        int windowStart = 0;
        int windowSum = 0;
        int smallestSum = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            while (windowSum >= target) {
                smallestSum = Math.min(smallestSum, windowSum);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return smallestSum == Integer.MAX_VALUE ? 0 : smallestSum;
    }

    /*
     * review: Longest Substring with K Distinct Characters
     * Given a string, find the length of the longest substring in it with no more
     * than K distinct characters.
     */
    public static int longestSubstringWithKDistinctCharacters(String word, int K) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int longestSubstring = 0;
        int windowStart = 0;

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
     * review: Fruits into Basket
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
                windowStart++;

                freqMap.put(removeFruit, freqMap.get(removeFruit) - 1);
                if (freqMap.get(removeFruit) == 0)
                    freqMap.remove(removeFruit);
            }

            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
        }

        return maxFruits;
    }

    /*
     * review: no-repeat substring
     * Given a string, find the length of the longest substring which has no
     * repeating characters.
     */
    public static int noRepeatSubstring(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;
        int maxSubstring = 0;

        for (int windowEnd = 0; windowEnd < 0; windowEnd++) {
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
     * review: Longest Substring with Same Letters after Replacement
     * Given a string with lowercase letters only, if you are allowed to replace no
     * more than ‘k’ letters with any letter, find the length of the longest
     * substring having the same letters after replacement.
     */
    public static int longestSubstringWithSameLettersAfterReplacement(String word, int K) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxSubstring = 0;
        int windowStart = 0;
        int maxRepeatLeters = 0;

        for (int windowEnd = 0; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            maxRepeatLeters = Math.max(maxRepeatLeters, freqMap.get(current));

            if (windowEnd - windowStart + 1 - maxRepeatLeters > K) { // need to reason why while or if
                char charToRemove = word.charAt(windowStart);
                freqMap.put(charToRemove, freqMap.get(charToRemove) - 1);
                windowStart++;
            }

            maxSubstring = Math.max(maxSubstring, windowEnd - windowStart + 1);
        }

        return maxSubstring;
    }

    /*
     * review: Longest Subarray with Ones after Replacement
     * Given an array containing 0s and 1s, if you are allowed to replace no more
     * than ‘k’ 0s with 1s, find the length of the longest contiguous subarray
     * having all 1s.
     */
    public static int longestSubarrayWithOnesAfterReplacement(int[] nums, int K) {
        int onesCount = 0;
        int windowStart = 0;
        int longestSubarray = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 1)
                onesCount++;

            while (windowEnd - windowStart + 1 - onesCount > K) {
                if (nums[windowStart] == 1)
                    onesCount--;
                windowStart++;
            }

            longestSubarray = Math.max(longestSubarray, windowEnd - windowStart + 1);
        }

        return longestSubarray;
    }
}
