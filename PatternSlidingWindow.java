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
    public static double[] averageContiguousSubarrays(int[] nums, int K) {
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

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
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
    public static int smallestSubarrayWithGivenSum(int[] nums, int S) {
        int windowStart = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
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
     * Given a string, find the length of the longest substring in it with no more
     * than K distinct characters.
     */
    public static int longestSubstringWithKDistinctChar(String word, int K) {
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
     */
    public static int fruitsIntoBasket(char[] fruits) {
        int maxFruits = 0;
        int windowStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int windowEnd = windowStart; windowEnd < fruits.length; windowEnd++) {
            char current = fruits[windowEnd];
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);

            while (freqMap.size() > 2) {
                char remove = fruits[windowStart];

                freqMap.remove(remove, freqMap.get(remove) - 1);
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
        Set<Character> noDups = new TreeSet<>();

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);

            if (noDups.contains(current)) {
                windowStart = windowEnd;
                noDups.clear();
            }
            noDups.add(current);
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
    public static int longestSubstringWithSameLettersAfterReplacement(String word, int K) {
        int longestSubtring = 0;
        int windowStart = 0;
        int maxReplacedLetters = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char current = word.charAt(windowEnd);
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            maxReplacedLetters = Math.max(maxReplacedLetters, freqMap.get(current));

            if (windowEnd - windowStart + 1 - maxReplacedLetters > K) { // ! not while, but if
                char remove = word.charAt(windowStart);
                freqMap.put(remove, freqMap.get(remove) - 1);
                windowStart++;
            }

            longestSubtring = Math.max(longestSubtring, windowEnd - windowStart + 1);
        }

        return longestSubtring;
    }

}
