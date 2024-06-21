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
    public static double[] contigSubarrays(int[] nums, int K) {
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
     */
    public static int longestSubstringWithKDistinctCharacters(String word, int K) {
        int windowStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxSubstring = 0;

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

            maxSubstring = Math.max(maxSubstring, windowEnd - windowStart + 1);
        }

        return maxSubstring;
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
     */
    public static int fruitsIntoBaskets(char[] fruits) {
        int windowStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFruit = 0;

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

            maxFruit = Math.max(maxFruit, windowEnd - windowStart + 1);
        }

        return maxFruit;
    }

    /*
     * review: no-repeat substring
     */
    public static int noRepeatSubstring(String word) {
        int windowStart = 0;
        int maxWindow = 0;
        Set<Character> noDups = new TreeSet<>();

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);

            if (noDups.contains(current)) {
                windowStart = windowEnd;
                noDups.clear();
            }

            noDups.add(current);
            maxWindow = Math.max(maxWindow, windowEnd - windowStart + 1);
        }

        return maxWindow;
    }

    /*
     * review: Longest Substring with Same Letters after Replacement
     * Given a string with lowercase letters only, if you are allowed to replace no
     * more than ‘k’ letters with any letter, find the length of the longest
     * substring having the same letters after replacement.
     */
    public static int longestSubstringWithSameLettersAfterReplacement(String word, int K) {
        int windowStart = 0;
        int longestSubtring = 0;
        int maxRepeatLetters = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            maxRepeatLetters = Math.max(maxRepeatLetters, freqMap.get(current));

            while (windowEnd - windowStart + 1 - maxRepeatLetters > K) { // ! understand this to a better degree, why is
                                                                         // it this and why the while?
                char remove = word.charAt(windowStart);
                freqMap.put(remove, freqMap.get(remove) - 1);
                windowStart++;
            }

            longestSubtring = Math.max(longestSubtring, windowEnd - windowStart + 1);
        }

        return longestSubtring;
    }

    /*
     * problem: Longest Subarray with Ones after Replacement
     * Given an array containing 0s and 1s, if you are allowed to replace no more
     * than ‘k’ 0s with 1s, find the length of the longest contiguous subarray
     * having all 1s.
     */
    public static int longestSubarrayWithOnesAfterReplacement(int[] nums, int K) {
        int windowStart = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxOnes = 0;
        int len = 0;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            int current = nums[windowEnd];
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            maxOnes = Math.max(maxOnes, freqMap.get(current));

            while (windowEnd - windowStart + 1 - maxOnes > K) { // ! understand this to a better degree, why is it this
                                                                // and why the while?
                int remove = nums[windowStart];
                freqMap.put(remove, freqMap.get(remove) - 1);
                windowStart++;
            }
            len = Math.max(len, windowEnd - windowStart + 1);
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 };

        System.out.println(longestSubarrayWithOnesAfterReplacement(nums, 2));
    }
}
