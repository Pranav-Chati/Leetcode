import java.util.Arrays;

public class CyclicSort {
    /*
     * review: Cyclic Sort
     * We are given an array containing ‘n’ objects. Each object, when created, was
     * assigned a unique number from 1 to ‘n’ based on their creation sequence. This
     * means that the object with sequence number ‘3’ was created just before the
     * object with sequence number ‘4’.
     */
    public static void cyclicSort(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] - 1 != i) {
                swap(nums, nums[i] - 1, i);
            } else
                i++;
        }
    }

    public static void swap(int[] nums, int toSwap, int i) {
        int temp = nums[i];
        nums[i] = nums[toSwap];
        nums[toSwap] = temp;
    }

    /*
     * problem: Find the Missing Number
     * We are given an array containing ‘n’ distinct numbers taken from the range 0
     * to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers,
     * find the missing number.
     */
    public static int findTheMissingNumber(int[] nums) {
        // first sort the array
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));

        for (i = 1; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 3, 0 };
        // int[] arr1 = new int[] { 8, 3, 5, 2, 4, 6, 0, 1 };
        System.out.println(findTheMissingNumber(arr));
    }
}
