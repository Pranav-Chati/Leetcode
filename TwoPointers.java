import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoPointers {

    /*
     * review: Pair with Target Sum (easy)
     * Given an array of sorted numbers and a target sum, find a pair in the array
     * whose sum is equal to the given target.
     */

    public static int[] pairWithTargetSum(int[] nums, int target) {
        int leftPtr = 0;
        int rightPtr = nums.length - 1;
        int ptrSum = 0;

        while (leftPtr < rightPtr) {
            ptrSum = nums[leftPtr] + nums[rightPtr];

            if (ptrSum == target)
                return new int[] { leftPtr, rightPtr };

            if (ptrSum > target)
                rightPtr--;
            else
                leftPtr++;
        }

        return new int[] { -1, -1 };
    }

    /*
     * review: Remove Duplicates (easy)
     * Given an array of sorted numbers, remove all duplicates from it. You should
     * not use any extra space; after removing the duplicates in-place return the
     * new length of the array.
     */
    public static int removeDuplicates(int[] nums) {

        int nonNextDuplicate = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[nonNextDuplicate - 1] != nums[i]) {
                nonNextDuplicate++;
            }
        }

        return nonNextDuplicate;
    }

    /*
     * review: Squaring a Sorted Array (easy)
     * Given a sorted array, create a new array containing squares of all the number
     * of the input array in the sorted order.
     */

    public static int[] squaringSortedArray(int[] nums) {
        int[] squares = new int[nums.length];
        int index = nums.length - 1;
        int leftPtr = 0;
        int rightPtr = nums.length - 1;

        // ? Why is it equals?
        // Equals because at the very end, both pointers hover over the last element,
        // which is the "smallest" square now
        while (leftPtr <= rightPtr) {
            int leftSquare = nums[leftPtr] * nums[leftPtr];
            int rightSquare = nums[rightPtr] * nums[rightPtr];

            if (leftSquare >= rightSquare) {
                squares[index] = leftSquare;
                leftPtr++;
            } else {
                squares[index] = rightSquare;
                rightPtr--;
            }
            index--;
        }

        return squares;
    }

    /*
     * Problem: Triplet Sum to Zero (medium)
     * Given an array of unsorted numbers, find all unique triplets in it that add
     * up to zero.
     */
    public static int tripletSumToZero(int[] nums) {
        //
        Arrays.sort(nums);

        Map<Integer, Integer> frequencies = new HashMap<>();

        // transform to non duplicates
        int nonNextDuplicate = 1;
        for (int i = 1; i < nums.length; i++) {
            frequencies.put(-nums[i], nums[i]);
            // store numbers here
            if (nums[nonNextDuplicate - 1] != nums[i]) {
                nums[nonNextDuplicate] = nums[i];
                nonNextDuplicate++;
            }
        }

        // two pair
        int left = 0;
        int right = nonNextDuplicate - 1;
        while (left < right) {

        }

        return 0;
    }

}
