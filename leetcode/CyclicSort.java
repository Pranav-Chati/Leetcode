package leetcode;
import java.util.ArrayList;
import java.util.List;

public class CyclicSort {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
     * review: Cyclic Sort
     * We are given an array containing ‘n’ objects. Each object, when created, was
     * assigned a unique number from 1 to ‘n’ based on their creation sequence. This
     * means that the object with sequence number ‘3’ was created just before the
     * object with sequence number ‘4’.
     * 
     * Write a function to sort the objects in-place on their creation sequence
     * number in O(n) and without any extra space. For simplicity, let’s assume we
     * are passed an integer array containing only the sequence numbers, though each
     * number is actually an object.
     */
    public static void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
    }

    /*
     * review: Find the Missing Number
     * We are given an array containing ‘n’ distinct numbers taken from the range 0
     * to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers,
     * find the missing number.
     */
    public static int findTheMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]])
                swap(nums, i, nums[i]);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }

        return nums.length;
    }

    /*
     * review: Find All Missing Numbers
     * We are given an unsorted array containing numbers taken from the range 1 to
     * ‘n’. The array can have duplicates, which means some numbers will be missing.
     * Find all those missing numbers.
     */
    public static List<Integer> findAllMissingNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            if (nums[i] < nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);

        return missingNumbers;
    }

    /*
     * problem: Find the Duplicate Number
     * We are given an unsorted array containing ‘n+1’ numbers taken from the range
     * 1 to ‘n’. The array has only one duplicate but it can be repeated multiple
     * times. Find that duplicate number without using any extra space. You are,
     * however, allowed to modify the input array.
     */
    public static int findTheDuplicateNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return nums[i];
        }

        return -1;
    }

    /*
     * problem: Find all Duplicate Numbers
     * We are given an unsorted array containing ‘n’ numbers taken from the range 1
     * to ‘n’. The array has some duplicates, find all the duplicate numbers without
     * using any extra space.
     */
    public static List<Integer> findAllDuplicateNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> duplicates = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                duplicates.add(i + 1);
        }

        return duplicates;
    }

    /*
     * problem: Find the Corrupt Pair
     * We are given an unsorted array containing ‘n’ numbers taken from the range 1
     * to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due
     * to a data error, one of the numbers got duplicated which also resulted in one
     * number going missing. Find both these numbers.
     */
    public static int[] findCorruptPair(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return new int[] { nums[i], i + 1 };
        }

        return new int[] { -1, -1 };
    }

    /*
     * problem: Find the Smallest Missing Positive Number
     * Given an unsorted array containing numbers, find the smallest missing
     * positive number in it.
     */
    public static int findTheSmallestMissingPositiveNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(findTheSmallestMissingPositiveNumber(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(findTheSmallestMissingPositiveNumber(new int[] { 3, -2, 0, 1, 2 }));
        System.out.println(findTheSmallestMissingPositiveNumber(new int[] { 3, 2, 5, 1 }));
        System.out.println(findTheSmallestMissingPositiveNumber(new int[] { 0, 2, 3, 1 }));
        System.out.println(findTheSmallestMissingPositiveNumber(new int[] { 1, 2, 4, 3 }));
    }
}