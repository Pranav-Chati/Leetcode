import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

public class PatternSlidingWindow {
    /*
     * Review: Introduction
     * Given an array, find the average of all contiguous subarrays of size ‘K’ in
     * it.
     * 
     */

    public static double[] averageOfContiguousSubarrays(int[] nums, int K) {
        int windowStart = 0;
        double windowSum = 0;
        double[] average = new double[nums.length - K + 1];

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
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
    public static int maxSumSubarraySizeK(int[] nums, int K) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = 0;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
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
     * Review: Smallest Subarray with a given sum
     * Given an array of positive numbers and a positive number ‘S’, find the length
     * of the smallest contiguous subarray whose sum is greater than or equal to
     * ‘S’. Return 0, if no such subarray exists.
     * 
     */

    public static int smallestSubarrayWithSum(int[] nums, int S) {
        int windowStart = 0;
        int windowSum = 0;
        int minWindow = nums.length + 1;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            while (windowSum >= S) {
                minWindow = Math.min(minWindow, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minWindow == (nums.length + 1) ? 0 : minWindow;
    }

    /*
     * review: Longest Substring with K Distinct Characters
     * Given a string, find the length of the longest substring in it with no more
     * than K distinct characters.
     * 
     */

    public static int longestedSubstring(String word, int K) {
        int windowStart = 0;
        int longestedSubstring = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

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

            longestedSubstring = Math.max(longestedSubstring, windowEnd - windowStart + 1);
        }

        return longestedSubstring;
    }

    /*
     * review: fruits into baskets
     * Given an array of characters where each character represents a fruit tree,
     * you are given two baskets and your goal is to put maximum number of fruits in
     * each basket. The only restriction is that each basket can have only one type
     * of fruit.
     * 
     */
    public static int fruitsIntoBasket(char[] nums) {
        Map<Character, Integer> freqmap = new HashMap<>();

        int maxFruits = 0;
        int windowStart = 0;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            char current = nums[windowEnd];
            freqmap.put(current, freqmap.getOrDefault(current, 0) + 1);

            while (freqmap.size() > 2) {
                char remove = nums[windowStart];
                windowStart++;

                freqmap.put(remove, freqmap.get(remove) - 1);
                if (freqmap.get(remove) == 0)
                    freqmap.remove(remove);
            }

            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
        }

        return maxFruits;
    }

    /*
     * Problem: no-repeat substring
     * Given a string, find the length of the longest substring which has no
     * repeating characters.
     * 
     */
    public static int noRepeatSubstring(String word) {
        int windowStart = 0;
        int maxLength = 0;
        Set<Character> freqMap = new TreeSet<>();

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);

            if (freqMap.contains(current)) {
                windowStart = windowEnd;
                freqMap = new TreeSet<>();
            }
            freqMap.add(current);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "aabcbb";
        System.out.println(noRepeatSubstring(str));
        System.out.println(noRepeatSubstring("abbbb"));
        System.out.println(noRepeatSubstring("abccde"));
    }
}
