import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {

    /*
     * review: Pair with Target Sum
     * Given an array of sorted numbers and a target sum, find a pair in the array
     * whose sum is equal to the given target.
     * 
     * Write a function to return the indices of the two numbers (i.e. the pair)
     * such that they add up to the given target.
     */
    public static int[] pairWithTargetSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (target == sum)
                return new int[] { left, right };

            if (sum > target)
                right--;
            else
                left++;
        }

        return new int[] { -1, -1 };
    }

    /*
     * review: Remove Duplicates
     * Given an array of sorted numbers, remove all duplicates from it. You should
     * not use any extra space; after removing the duplicates in-place return the
     * new length of the array.
     */
    public static int removeDuplicates(int[] nums) {
        int nonDuplicates = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[nonDuplicates - 1] != nums[i]) {
                nums[nonDuplicates] = nums[i];
                nonDuplicates++;
            }
        }
        return nonDuplicates;
    }

    /*
     * Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all
     * instances of ‘key’ in-place and return the new length of the array.s
     */
    public static int removeKey(int[] nums) {
        int nonKeyElement = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[nonKeyElement] = nums[i];
            nonKeyElement++;
        }

        return nonKeyElement;
    }

    /*
     * review: Squaring a Sorted Array
     * Given a sorted array, create a new array containing squares of all the number
     * of the input array in the sorted order.
     */
    public static int[] squaringSortedArray(int[] nums) {
        int[] squares = new int[nums.length];
        int index = nums.length - 1;
        int left = 0;
        int right = index;

        while (left <= right) {
            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];

            if (leftSqr >= rightSqr) {
                squares[index--] = leftSqr;
                left++;
            } else {
                squares[index--] = rightSqr;
                right--;
            }
        }

        return squares;
    }

    /*
     * review: Triplet Sum to Zero
     * Given an array of unsorted numbers, find all unique triplets in it that add
     * up to zero.
     */
    public static List<List<Integer>> tripletSumToZero(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            findTriplets(nums, -nums[i], i + 1, triplets);
        }

        return triplets;
    }

    public static void findTriplets(int[] nums, int targetSum, int left, List<List<Integer>> triplets) {

        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, left, right));

                left++;
                right--;
                while (left < right && nums[left] == nums[left + 1])
                    left++;
                while (left < right && nums[right] == nums[right - 1])
                    right--;
            } else if (sum > targetSum)
                right--;
            else
                left++;
        }
    }

    /*
     * Problem: Triplet Sum Close to Target
     * Given an array of unsorted numbers and a target number, find a triplet in the
     * array whose sum is as close to the target number as possible, return the sum
     * of the triplet. If there are more than one such triplet, return the sum of
     * the triplet with the smallest sum.
     */

    public static int tripletSumCloseToTarget(int[] nums, int target) {
        // sort array
        Arrays.sort(nums);

        int closestValue = Integer.MAX_VALUE; // not sure what to put for this
        // i.e. i dont know what the min value could start ou tto be? the target?

        for (int i = 0; i < nums.length - 2; i++) {
            // pass in nums[i], i +1

            closestValue = Math.min(findClosestPair(nums, target - nums[i], i + 1, closestValue), closestValue);

        }

        return target - closestValue;
    }

    public static int findClosestPair(int[] nums, int targetMinusNum, int left, int distance) {
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            // might replace this with a function
            distance = Math.min(distance, Math.abs(targetMinusNum - sum));
            // one worry is if we do abs value, then we get fucked... bc then the sum will
            // be positive even if the sum is actually negative

            if (sum > targetMinusNum)
                right--;
            else
                left++;
        }

        return distance;
    }

    public static int solutionTripletSumCloseToTarget(int[] nums, int target) {
        int smallestDifference = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int diff = target - nums[i] - nums[left] - nums[right];

                // if 0, then we found the value with the sum (basically target)
                if (diff == 0)
                    return target - diff;

                // since we are dealing with the distance and sums, we must keep signs
                if (Math.abs(diff) < Math.abs(smallestDifference))
                    smallestDifference = diff;

                if (diff > 0)
                    left++;
                else
                    right--;

            }
        }

        return smallestDifference;
    }
}
