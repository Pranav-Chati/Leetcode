import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoPointers {

    /*
     * Review: Pair with Target Sum
     * Given an array of sorted numbers and a target sum, find a pair in the array
     * whose sum is equal to the given target.
     * 
     * Write a function to return the indices of the two numbers (i.e. the pair)
     * such that they add up to the given target.
     */

    public static int[] pairWithTargetSum(int[] num, int target) {
        int leftPtr = 0;
        int rightPtr = num.length - 1;
        int sum = 0;

        while (leftPtr < rightPtr) {
            sum = num[leftPtr] + num[rightPtr];
            if (sum == target)
                return new int[] { leftPtr, rightPtr };

            if (sum > target)
                rightPtr--;
            else
                leftPtr++;
        }

        return new int[] { -1, -1 };
    }

    public static int[] alternativePairWithTargetSum(int[] nums, int target) {
        Map<Integer, Integer> differenceMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (differenceMap.containsKey(nums[i])) {
                return new int[] { differenceMap.get(nums[i]), i };
            } else {
                differenceMap.put(target - nums[i], i);
            }
        }

        return new int[] { -1, -1 };
    }

    /*
     * review: Remove Duplicates
     * Given an array of sorted numbers, remove all duplicates from it. You should
     * not use any extra space; after removing the duplicates in-place return the
     * new length of the array.
     * 
     */

    public static int nonNextDuplicates(int[] nums) {
        int nonNextDuplicate = 1;

        for (int i = nonNextDuplicate; i < nums.length; i++) {
            if (nums[nonNextDuplicate - 1] != nums[i]) {
                nums[nonNextDuplicate] = nums[i];
                nonNextDuplicate++;
            }
        }

        return nonNextDuplicate;
    }

    /*
     * review:
     * Given an unsorted array of numbers and a target ‘key’, remove all
     * instances of ‘key’ in-place and return the new length of the array.
     * 
     */
    public static int nonNextDuplicates1(int[] nums, int key) {
        int nonNextDuplicate = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != key) {
                nums[nonNextDuplicate] = nums[i];
                nonNextDuplicate++;
            }
        }

        return nonNextDuplicate;
    }

    /*
     * review: Squaring a Sorted Array
     * Given a sorted array, create a new array containing squares of all the number
     * of the input array in the sorted order.
     */
    public static int[] squaringSortedArray(int[] nums) {
        int[] squares = new int[nums.length];

        int i = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];

            if (leftSqr < rightSqr) {
                squares[i] = rightSqr;
                right--;
            } else {
                squares[i] = leftSqr;
                left++;
            }
            i--;
        }

        return squares;
    }

    /*
     * Problem: Triplet sum to zero
     * Given an array of unsorted numbers, find all unique triplets in it that add
     * up to zero.
     */
    public static List<List<Integer>> tripletSumToZero(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            searchPair(nums, -nums[i], i + 1, triplets);
        }

        return triplets;
    }

    public static void searchPair(int[] nums, int target, int left, List<List<Integer>> triplets) {
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                triplets.add(Arrays.asList(-target, nums[left], nums[right]));

                // not sure what is happening here
                left++;
                right--;

                while (left < right && nums[left] == nums[left - 1])
                    left++;
                while (left < right && nums[right] == nums[right + 1])
                    right--;

            } else if (sum > target)
                right--;
            else
                left++;
        }

    }
}
