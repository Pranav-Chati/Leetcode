import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {
    /*
     * review: Intro/Pair with Target Sum
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
            if (sum == target)
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
        for (int i = 1; i < nums.length; i++) {
            if (nums[nonDuplicates - 1] != nums[i]) {
                nums[nonDuplicates] = nums[i];
                nonDuplicates++;
            }
        }

        return nonDuplicates;
    }

    /*
     * review: Squaring a sorted array
     * Given a sorted array, create a new array containing squares of all the number
     * of the input array in the sorted order.
     */
    public static int[] squaringSortedArray(int[] nums) {
        int[] squares = new int[nums.length];
        int index = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];

            if (leftSqr > rightSqr) {
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

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] != nums[left - 1])
                        left++;

                    while (left < right && nums[right] != nums[right + 1])
                        right--;
                } else if (sum > 0)
                    right--;
                else
                    left++;
            }
        }

        return triplets;
    }

    /*
     * review: Triplet Sum Close to Target
     * Given an array of unsorted numbers and a target number, find a triplet in the
     * array whose sum is as close to the target number as possible, return the sum
     * of the triplet. If there are more than one such triplet, return the sum of
     * the triplet with the smallest sum.
     */
    public static int tripletSumCloseToTarget(int[] nums, int target) {
        int closestDiff = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int diff = target - nums[i] + nums[left] + nums[right];

                if (diff == 0)
                    return target;

                if (Math.abs(diff) < Math.abs(closestDiff))
                    closestDiff = diff;

                if (diff > 0)
                    left++;
                else
                    right--;
            }
        }

        return target - closestDiff;
    }

    /*
     * review: Triplets with Smaller Sum
     * Given an array arr of unsorted numbers and a target sum, count all triplets
     * in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three
     * different indices. Write a function to return the count of such triplets.
     */
    public static int tripletsWithSmallerSum(int[] nums, int target) {
        int numberOfSmallerSums = 0;
        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    numberOfSmallerSums += right - left;
                    left++;
                } else
                    right--;
            }
        }

        return numberOfSmallerSums;
    }

    /*
     * review: Dutch National Flag Problem
     * Given an array containing 0s, 1s and 2s, sort the array in-place. You should
     * treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s
     * to recreate the array.
     */
    public static void dutchNationalProblem(int[] nums) {
        int index = 0;
        int zeroPtr = 0;
        int twoPtr = nums.length - 1;

        while (zeroPtr <= index && index <= twoPtr) {
            if (nums[index] == 0) {// Need to test out the ++ feature
                swap(nums, index++, zeroPtr++);
            } else if (nums[index] == 1)
                index++;
            else {
                swap(nums, index, twoPtr);
                twoPtr--;
            }

        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
