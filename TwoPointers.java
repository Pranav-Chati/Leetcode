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
        int nonRemoveDuplicates = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[nonRemoveDuplicates - 1] != nums[i]) {
                nums[nonRemoveDuplicates] = nums[i];
                nonRemoveDuplicates++;
            }
        }
        return nonRemoveDuplicates;
    }

    /*
     * review: Squaring a sorted array
     * Given an array of sorted numbers and a target sum, find a pair in the array
     * whose sum is equal to the given target.
     * 
     * Write a function to return the indices of the two numbers (i.e. the pair)
     * such that they add up to the given target.
     */
    public static int[] squaringASortedArray(int[] nums) {
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
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;
            int targetSum = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == targetSum) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1])
                        left++;

                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum > targetSum) {
                    right--;
                } else
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
        Arrays.sort(nums);

        int smallestDiff = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int diff = target - nums[i] - nums[left] - nums[right];
                if (diff == 0)
                    return target;

                if (Math.abs(diff) < Math.abs(smallestDiff))
                    smallestDiff = diff;

                if (diff > 0)
                    left++;
                else
                    right--;

            }
        }

        return target - smallestDiff;
    }

    /*
     * review: Triplets with Smaller Sum
     * Given an array arr of unsorted numbers and a target sum, count all triplets
     * in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three
     * different indices. Write a function to return the count of such triplets.
     */
    public static int tripletsWithSmallerSum(int[] nums, int target) {
        Arrays.sort(nums);
        int tripsWithSmallerSum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < target) {
                    tripsWithSmallerSum += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return tripsWithSmallerSum;
    }

    /*
     * review: Dutch National Flag Problem
     * Given an array containing 0s, 1s and 2s, sort the array in-place. You should
     * treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s
     * to recreate the array.
     */
    public static int[] dutchNationalFlag(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (left <= i && i <= right) {
            if (nums[left] == 0) {
                swap(nums, left, i);
                i++;
                left++;
            } else if (nums[left] == 2) {
                swap(nums, right, i);
                right--;
            } else {
                i++;
            }
        }

        return nums;
    }

    public static void swap(int[] nums, int toSwap, int i) {
        int temp = nums[i];
        nums[i] = nums[toSwap];
        nums[toSwap] = temp;
    }

}
