import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PatternSlidingWindow {
    /*
     * review: Introduction
     * Given an array, find the average of all contiguous subarrays of size ‘K’ in
     * it.
     */
    public static double[] avgContiSubarrays(int[] nums, int K) {
        double[] averages = new double[] { nums.length - K + 1 };
        int windowStart = 0;
        double windowSum = 0;

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
     * Given an array of positive numbers and a positive number ‘k’, find the
     * maximum sum of any contiguous subarray of size ‘k’.
     */
    public static int maxSumSubarrayOfSizeK(int[] nums, int k) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = 0;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return windowSum;
    }

    /*
     * review: Smallest Subarray with a given sum
     * Given an array of positive numbers and a positive number ‘S’, find the length
     * of the smallest contiguous subarray whose sum is greater than or equal to
     * ‘S’. Return 0, if no such subarray exists.
     */
    public static int smallestSubarrayWithGivenSum(int[] nums, int S) {
        int windowStart = 0;
        int windowSum = 0;
        int minIndex = Integer.MAX_VALUE;
        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            while (windowSum >= S) {
                minIndex = Math.min(minIndex, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minIndex == Integer.MAX_VALUE ? 0 : minIndex;
    }

    /*
     * review: Longest Substring with K Distinct Characters
     * Given a string, find the length of the longest substring in it with no more
     * than K distinct characters.
     */
    public static int longestSubstringWithKDistinctCharacters(String word, int K) {
        int windowStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxLength = 0;

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            freqMap.put(current, freqMap.getOrDefault(freqMap, 0) + 1);

            while (freqMap.size() > K) {
                char remove = word.charAt(windowStart);
                freqMap.put(remove, freqMap.get(remove) - 1);
                if (freqMap.get(remove) == 0)
                    freqMap.remove(remove);

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    /*
     * review: Fruits into Basket
     */
    public static int fruitsIntoBasket(char[] fruits) {
        int windowStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFruits = 0;

        for (int windowEnd = windowStart; windowEnd < fruits.length; windowEnd++) {
            char current = fruits[windowEnd];
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);

            while (freqMap.size() > 2) {
                char remove = fruits[windowStart];
                windowStart++;

                freqMap.put(remove, freqMap.get(remove) - 1);
                if (freqMap.get(remove) == 0)
                    freqMap.remove(remove);
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
        Set<Character> nonDupLetters = new TreeSet<>();
        int longestLength = 0;

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);

            if (nonDupLetters.contains(current)) {
                windowStart = windowEnd;
                nonDupLetters.clear();
            }
            nonDupLetters.add(current);
            longestLength = Math.max(longestLength, windowEnd - windowStart + 1);
        }

        return longestLength;
    }
}
