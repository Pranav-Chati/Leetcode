public class Test3 {
    /**
     * Given an array of positive numbers and a positive number ‘S’, find the length
     * of the smallest contiguous subarray whose sum is greater than or equal to
     * ‘S’. Return 0, if no such subarray exists.
     * 
     * Input: [2, 1, 5, 2, 3, 2], S=7
     * Output: 2
     * Explanation: The smallest subarray with a sum great than or equal to '7' is
     * [5, 2].
     */

    public static void main(String[] args) {
        int[] array = new int[] { 2, 1, 5, 2, 8 };
        int S = 7;
        System.out.println(returnIndex1(array, 1));
    }

    // [2, 1, 5, 2, 8]

    public static int returnIndex1(int[] nums, int target) {
        int windowStart = 0;
        int windowSum = 0;
        int tempIndex = 0;
        int minIndex = nums.length;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            while (windowSum >= target) {
                tempIndex = windowEnd - windowStart + 1;
                minIndex = Math.min(tempIndex, minIndex);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minIndex == nums.length ? 0 : minIndex;
    }
}
