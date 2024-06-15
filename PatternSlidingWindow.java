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
    public static double[] contiguousSubarrays(int[] nums, int K) {
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
     * Given an array of positive numbers and a positive number ‘k’, find the
     * maximum sum of any contiguous subarray of size ‘k’.
     */
    public static int maxSumSubarraySizeK(int[] nums, int k) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = 0;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
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
    public static int smallestSubarrayWithSum(int[] nums, int target) {
        int windowStart = 0;
        int windowSum = 0;
        int minWindow = Integer.MAX_VALUE;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];
            while (windowSum >= target) {
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
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxLength = 0;

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            while (freqMap.size() > K) {
                char remove = word.charAt(windowStart);
                freqMap.put(remove, freqMap.get(remove) - 1);
                if (freqMap.get(remove) == 0)
                    freqMap.get(remove);

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
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
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFruits = 0;

        for (int windowEnd = windowStart; windowEnd < fruits.length; windowEnd++) {
            char current = fruits[windowEnd];

            freqMap.put(current, freqMap.getOrDefault(freqMap, 0) + 1);

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
        Set<Character> letters = new TreeSet<>();
        int maxLength = 0;

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);

            if (letters.contains(current)) {
                windowStart = windowEnd;
                letters.clear();
            }

            letters.add(current);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    /*
     * Problem: Longest Substring with Same Letters after Replacement
     * Given a string with lowercase letters only, if you are allowed to replace no
     * more than ‘k’ letters with any letter, find the length of the longest
     * substring having the same letters after replacement.
     */
    public static int longestSubstringwSameLetters(String word, int K) {
        int windowStart = 0;
        int maxRepeatLetter = 0;
        int maxLength = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            maxRepeatLetter = Math.max(maxRepeatLetter, freqMap.get(current));

            if (windowEnd - windowStart + 1 - maxRepeatLetter > K) {
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

    public static void main(String[] args) {
        String str = "abbcb";
        int k = 1;
        System.out.println(longestSubstringwSameLetters(str, k));
        System.out.println(longestSubstringwSameLetters("aabccbb", 2));

    }
}
