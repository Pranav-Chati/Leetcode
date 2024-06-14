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
        int nonNextDuplicate = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[nonNextDuplicate - 1] != nums[i]) {
                nums[nonNextDuplicate] = nums[i];
                nonNextDuplicate++;
            }
        }

        return nonNextDuplicate;
    }

    /*
     * review: Squaring a sorted array
     * Given a sorted array, create a new array containing squares of all the number
     * of the input array in the sorted order.
     */
    public static int[] squaringSortedArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] squares = new int[nums.length];
        int index = right;

        while (left <= right) {
            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];

            if (leftSqr < rightSqr) {
                squares[index--] = rightSqr;
                right--;
            } else {
                squares[index--] = leftSqr;
                left++;
            }
        }

        return squares;
    }

    /*
     * review: Triplet Sum to Zero
     * Given an array of unsorted numbers, find all unique triplets in it that add
     * up to zero
     */
    public static List<List<Integer>> tripletSumToZero(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1])
                continue;

            findPairs(nums, -nums[i], i + 1, triplets);
        }

        return triplets;
    }

    public static void findPairs(int[] nums, int target, int left, List<List<Integer>> triplets) {
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                triplets.add(Arrays.asList(-target, nums[left], nums[right]));

                left++;
                right--;

                // ! understand the - and + here
                while (left < right && nums[left] == nums[left - 1])
                    left++;

                while (left < right && nums[right] == nums[right + 1])
                    right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    /*
     * review: Triplet Sum Close to Target
     * Given an array of unsorted numbers and a target number, find a triplet in the
     * array whose sum is as close to the target number as possible, return the sum
     * of the triplet. If there are more than one such triplet, return the sum of
     * the triplet with the smallest sum.
     */
    public static int tripletCloseToTarget(int[] nums, int target) {
        int smallestDiff = Integer.MAX_VALUE;
        int diff = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                diff = target - nums[i] - nums[left] - nums[right];

                if (diff == 0) {
                    return target;
                }

                if (Math.abs(diff) < Math.abs(smallestDiff)) {
                    smallestDiff = diff;
                }

                if (diff > 0)
                    left++;
                else
                    right--;
            }
        }

        // ! the smallestDiff is just the difference, we need to return the actual sum
        return target - smallestDiff;
    }
}
