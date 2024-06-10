import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    /*
     * review: Smallest Subarray with a given sum
     * Given an array of positive numbers and a positive number ‘S’, find the length
     * of the smallest contiguous subarray whose sum is greater than or equal to
     * ‘S’. Return 0, if no such subarray exists.
     */
    public static int smallestSubWithSum(int[] nums, int K) {
        int windowStart = 0;
        int windowSum = 0;
        int minWindow = nums.length + 1;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            while (windowSum >= K) {
                minWindow = Math.min(minWindow, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minWindow == nums.length + 1 ? 0 : minWindow;
    }

    /*
     * review: Maximum Sum Subarray of Size K
     * Given an array of positive numbers and a positive number ‘k’, find the
     * maximum sum of any contiguous subarray of size ‘k’.
     */
    public static int maxSumSubarray(int[] nums, int K) {
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
     * review: Introduction
     * Given an array, find the average of all contiguous subarrays of size ‘K’ in
     * it.
     */
    public static double[] avgContigArray(int[] nums, int K) {
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
     * review: Longest Substring with K Distinct Characters
     * Given a string, find the length of the longest substring in it with no more
     * than K distinct characters.
     */

    public static int longestSubstringWithDistinctChar(String word, int K) {
        int windowStart = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int longestSubtstring = 0;

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char currentChar = word.charAt(windowEnd);
            frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar, 0) + 1);

            while (frequencyMap.size() > K) {
                char removeChar = word.charAt(windowStart);
                windowStart++;

                frequencyMap.put(removeChar, frequencyMap.get(removeChar) - 1);
                if (frequencyMap.get(removeChar) == 0)
                    frequencyMap.remove(removeChar);
            }

            longestSubtstring = Math.max(longestSubtstring, windowEnd - windowStart + 1);

        }

        return longestSubtstring;
    }

    /*
     * problem: Fruits into Baskets (medium)
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
    public static int fruitBasket(char[] fruits) {
        int windowStart = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int maxFruit = 0;

        for (int windowEnd = windowStart; windowEnd < fruits.length; windowEnd++) {
            char current = fruits[windowEnd];
            frequencyMap.put(current, frequencyMap.getOrDefault(frequencyMap, 0) + 1);

            while (frequencyMap.size() > 2) {
                char remove = fruits[windowStart];
                frequencyMap.put(remove, frequencyMap.get(remove) - 1);
                if (frequencyMap.get(remove) == 0)
                    frequencyMap.remove(remove);

                windowStart--;
            }
            maxFruit = Math.max(maxFruit, windowEnd - windowStart + 1);
        }

        return maxFruit;
    }
}
