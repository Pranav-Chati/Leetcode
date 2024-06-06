import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2, 10 };
        int k = 5;

        // array = new int[] { 3, 6, 8, 10, -1 };
        // k = 2;

        // double[] array2 = windowAvgSubarray(array, k);
        // System.out.println(Arrays.toString(array2));

        // array = new int[] { 2, 1, 5, 1, 3, 2 };
        // System.out.println(maxSum(array, 3));

        array = new int[] { 1, 2, 3, 4, 6 };
        System.out.println(Arrays.toString(twoPointers(array, 6)));
    }

    public static double[] windowAvgSubarray(int[] array, int K) {
        int windowStart = 0;

        int windowSum = 0;
        double[] windowAvg = new double[array.length - K + 1];

        // ? does the condition make sense or should it be -1 of the length
        for (int windowEnd = windowStart; windowEnd < array.length; windowEnd++) {
            windowSum += array[windowEnd];

            // ? what if we did K - 1 instead of >=
            // ! previously we did >= K
            if (windowEnd >= K - 1) {
                windowAvg[windowStart] = (double) windowSum / K;
                windowSum -= array[windowStart];
                windowStart++;
            }
        }

        return windowAvg;
    }

    public static int maxSum(int[] nums, int K) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = 0;

        for (int windowEnd = windowStart; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            if (windowEnd >= K - 1) {
                if (windowSum > maxSum)
                    maxSum = windowSum;
                windowSum -= nums[windowStart];

                windowStart++;
            }
        }

        return maxSum;
    }

    /*
     * Given an array of sorted numbers and a target sum, find a pair in the array
     * whose sum is equal to the given target.
     * Given, sorted Array and given target
     */

    public static int[] twoPointers(int[] nums, int target) {
        int startPtr = 0;
        int endPtr = nums.length - 1;
        int sum = 0;

        while (startPtr < endPtr) {
            sum = nums[startPtr] + nums[endPtr];

            if (sum > target)
                endPtr--;
            else if (sum < target)
                startPtr++;
            else
                return new int[] { startPtr, endPtr };
        }

        return null;
    }
}
