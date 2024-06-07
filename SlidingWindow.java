import java.util.HashMap;

public class SlidingWindow {
    public static void main(String[] args) {

    }

    /*
     * Given an array, find the average of all contiguous subarrays of size ‘K’ in
     * it.
     */
    public static double[] avgSubarrays(int[] nums, int K) {
        int windowStart = 0;
        int windowSum = 0;
        double[] averages = new double[nums.length - K + 1];

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            if (windowEnd >= K - 1) {
                averages[windowStart] = windowSum / (double) K;
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return averages;
    }

    /*
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
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }

    /*
     * Given an array of positive numbers and a positive number ‘S’, find the length
     * of the smallest contiguous subarray whose sum is greater than or equal to
     * ‘S’. Return 0, if no such subarray exists.
     */
    public static int smallestSubarrayWithSum(int[] nums, int S) {
        int windowStart = 0;
        int windowSum = 0;
        int minIndex = nums.length;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            // condition here that says when the sum is too much, we need to reduece and
            // check the size
            while (windowSum >= S) {
                minIndex = Math.min(windowEnd - windowStart + 1, minIndex);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        // !
        return minIndex == nums.length ? 0 : minIndex;
    }

    /*
     * Given a string, find the length of the longest substring in it with no more
     * than K distinct characters.
     */

    public static int longestSubstringWithKDistinct(String word, int K) {
        int windowStart = 0;
        HashMap<Character, Integer> characters = new HashMap<>();
        int maxSize = 0;

        for (int windowEnd = windowStart; windowEnd < word.length(); windowEnd++) {
            char currentChar = word.charAt(windowEnd);

            characters.put(currentChar, characters.getOrDefault(characters, 0) + 1);

            while (characters.size() > K) {
                char removeChar = word.charAt(windowStart);

                characters.put(removeChar, characters.get(removeChar) - 1);
                if (characters.get(removeChar) == 0) {
                    characters.remove(removeChar);
                }
                windowStart++;
            }

            maxSize = Math.max(maxSize, windowEnd - windowStart + 1);

        }

        return maxSize;
    }
}