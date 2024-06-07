import java.util.Arrays;

public class TwoPointers {
    public static void main(String[] args) {
        int[] array = new int[] { -2, -1, 0, 2, 3 };
        int[] array1 = new int[] { -2, -1, 0 };
        int[] array2 = new int[] { 0, 1, 2, 3 };

        System.out.println(Arrays.toString(squaringSortedArray(array)));

    }

    /**
     * Given an array of sorted numbers and a target sum, find a pair in the array
     * whose sum is equal to the given target.
     */
    public static int[] pairWithTargetSum(int[] nums, int target) {
        int leftPtr = 0;
        int rightPtr = 0;
        int sum = 0;

        while (rightPtr < leftPtr) {
            sum = nums[leftPtr] + nums[rightPtr];

            if (sum == target)
                return new int[] { leftPtr, rightPtr };

            if (sum > target)
                rightPtr--;
            else
                leftPtr++;
        }

        return new int[] { -1, -1 };
    }

    /**
     * Given an array of sorted numbers, remove all duplicates from it. You should
     * not use any extra space; after removing the duplicates in-place return the
     * new length of the array.
     * 
     */

    public static int removesDuplicate(int[] nums) {
        int nonNextDuplicate = 1;
        for (int i = nonNextDuplicate; i < nums.length; i++) {
            if (nums[nonNextDuplicate - 1] != nums[i]) {
                nums[nonNextDuplicate] = nums[i];
                nonNextDuplicate++;
            }
        }
        return nonNextDuplicate;
    }

    /**
     * Given a sorted array, create a new array containing squares of all the number
     * of the input array in the sorted order.
     * 
     */
    public static int[] squaringSortedArray(int[] nums) {
        int leftPtr = 0;
        int rightPtr = nums.length - 1;
        int[] squares = new int[nums.length];
        int index = nums.length - 1;

        while (leftPtr < rightPtr) {
            int left = nums[leftPtr] * nums[leftPtr];
            int right = nums[rightPtr] * nums[rightPtr];

            if (left > right) {
                // nums[leftPtr] = right;
                // nums[rightPtr] = left;
                squares[index--] = left;

                leftPtr++;
            } else {
                squares[index--] = right;
                // nums[rightPtr] = right;
                rightPtr--;
            }

        }

        return squares;
    }
}
