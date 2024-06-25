import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SlidingWindow {
    /*
     * review: Introduction
     * Given an array, find the average of all contiguous subarrays of size ‘K’ in
     * it.
     */
    public static double[] contiguousAverage(int[] nums, int K) {
        int windowStart = 0;
        double windowSum = 0;
        double[] averages = new double[nums.length - K + 1];

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            if (windowEnd >= K - 1) {
                averages[windowStart] = windowSum / K;
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return averages;
    }

    /*
     * review: Maximum Sum Subarray of Size K
     */
    public static int maxSumSubarrayOfSizeK(int[] nums, int k) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];
            if (windowEnd >= k - 1) {
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
    public static int smallestSubarrayWithAGivenSum(int[] nums, int S) {
        int windowStart = 0;
        int windowSum = 0;

        int minWindow = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            while (windowSum >= S) {
                minWindow = Math.min(minWindow, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
    }

    /*
     * review: Longest Substring with K Distinct Characters
     * Given a string, find the length of the longest substring in it with no more
     * than K distinct characters.
     */
    public static int longestSubstringWithKDistinctCharacters(String word, int K) {
        int windowStart = 0;
        int longestSubstring = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);

            while (freqMap.size() > K) {
                char remove = word.charAt(windowStart);
                freqMap.put(remove, freqMap.get(remove) - 1);

                if (freqMap.get(remove) == 0)
                    freqMap.remove(remove);

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
        int windowStart = 0;
        int maxFruits = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            char current = fruits[windowEnd];
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);

            while (freqMap.size() > 2) {
                char remove = fruits[windowStart];
                freqMap.put(remove, freqMap.get(remove) - 1);

                if (freqMap.get(remove) == 0)
                    freqMap.remove(remove);

                windowStart++;
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
        int windowStart = 0;
        int longestSubstring = 0;
        Set<Character> noDuplicates = new TreeSet<>();

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            if (noDuplicates.contains(current)) {
                windowStart = windowEnd;
                noDuplicates.clear();
            }
            noDuplicates.add(current);
            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1);
        }

        return longestSubstring;
    }

    /*
     * review: Longest Substring with Same Letters after Replacement
     * Given a string with lowercase letters only, if you are allowed to replace no
     * more than ‘k’ letters with any letter, find the length of the longest
     * substring having the same letters after replacement.
     */
    public static int longestSubstringWithSameLettersAfterReplacement(String word, int k) {
        int windowStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxRepeated = 0;
        int longestSubstring = 0;

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            maxRepeated = Math.max(maxRepeated, freqMap.get(current));
            if (windowEnd - windowStart + 1 - maxRepeated > k) {
                char remove = word.charAt(windowStart);
                freqMap.put(remove, freqMap.get(remove) - 1);
                windowStart++;
            }

            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1);
        }

        return longestSubstring;
    }

    /*
     * problem: Longest Subarray with Ones after Replacement
     * Given an array containing 0s and 1s, if you are allowed to replace no more
     * than ‘k’ 0s with 1s, find the length of the longest contiguous subarray
     * having all 1s.
     */
    public static int longestSubarrayWithOnesAfterReplacement(int[] nums, int k) {
        int windowStart = 0;
        int maxOnes = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            int current = nums[windowEnd];
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);

            while (freqMap.get(0) > k) {
                int remove = nums[windowStart];
                freqMap.put(remove, freqMap.get(remove) - 1);
                windowStart++;
            }
            maxOnes = Math.max(maxOnes, windowEnd - windowStart + 1);
        }

        return maxOnes;
    }

    public static int alternativeApproach(int[] nums, int k) {
        int maxOnes = 0;
        int maxLength = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 1)
                maxOnes++;

            while (windowEnd - windowStart + 1 - maxOnes > k) {
                if (nums[windowStart] == 1)
                    maxOnes--;

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 };
        int[] array1 = new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 };

        System.out.println(longestSubarrayWithOnesAfterReplacement(array1, 3));
    }
}
