import java.util.ArrayList;
import java.util.List;

public class CyclicSort {
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
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        // after sorting
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
            }
        }

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

    public static int findTheDuplicateNumber1(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else
                    return nums[i];
            } else
                i++;
        }

        return -1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
     * problem: Find all Duplicate Numbers
     * We are given an unsorted array containing ‘n’ numbers taken from the range 1
     * to ‘n’. The array has some duplicates, find all the duplicate numbers without
     * using any extra space.
     */
    public static List<Integer> findAllDuplicateNumbers(int[] nums) {
        int i = 0;
        List<Integer> duplicates = new ArrayList<>();
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicates.add(nums[i]);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        System.out.println(findTheDuplicateNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(findTheDuplicateNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(findTheDuplicateNumber(new int[] { 2, 4, 1, 4, 4 }));

        System.out.println(findAllDuplicateNumbers(new int[] { 3, 4, 4, 5, 5 }));
    }

}