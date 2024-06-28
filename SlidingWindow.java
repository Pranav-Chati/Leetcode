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
    public static double[] avgContigSubarrays(int[] nums, int K) {
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
     */
    public static int maxSumSubarrayOfSizeK(int[] nums, int K) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            if (windowEnd >= K - 1) {
                maxSum = Math.max(windowSum, maxSum);
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
        int minLength = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /*
     * review: Longest Substring with K Distinct Characters
     */
    public static int longestSubstringWithKDistinctCharacters(String word, int K) {
        int windowStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxLength = 0;

        for (int windowEnd = 0; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);

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
        int maxFruits = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
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
     */
    public static int noRepeatSubstring(String word) {
        Set<Character> freqMap = new TreeSet<>();
        int longestSubtring = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);

            if (freqMap.contains(current)) {
                windowStart = windowEnd;
                freqMap.clear();
            }
            freqMap.add(current);
            longestSubtring = Math.max(longestSubtring, windowEnd - windowStart + 1);
        }

        return longestSubtring;
    }

    /*
     * review: Longest Substring with Same Letters after Replacement
     * Given a string with lowercase letters only, if you are allowed to replace no
     * more than ‘k’ letters with any letter, find the length of the longest
     * substring having the same letters after replacement.
     */
    public static int longestSubstringWithSameLettersAfterReplacement(String word, int K) {
        int maxRepeatLetters = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;
        int longestSubstring = 0;

        for (int windowEnd = 0; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            maxRepeatLetters = Math.max(maxRepeatLetters, freqMap.get(current));

            if (windowEnd - windowStart + 1 - maxRepeatLetters > K) {
                char remove = word.charAt(windowStart);
                freqMap.put(remove, freqMap.get(remove) - 1);
                windowStart++;
            }

            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1);
        }

        return longestSubstring;
    }

    /*
     * review: Longest Subarray with Ones after Replacement
     * Given an array containing 0s and 1s, if you are allowed to replace no more
     * than ‘k’ 0s with 1s, find the length of the longest contiguous subarray
     * having all 1s.
     */
    public static int longestSubarrayWithOnesAfterReplacement(int[] nums, int k) {
        int maxOnes = 0;
        int longestSubarray = 0;

        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 1)
                maxOnes++;

            while (windowEnd - windowStart + 1 - maxOnes > k) {
                if (nums[windowStart] == 1) {
                    maxOnes--;
                }
                windowStart++;
            }

            longestSubarray = Math.max(longestSubarray, windowEnd - windowStart + 1);
        }

        return longestSubarray;
    }

}
