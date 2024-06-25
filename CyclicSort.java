import java.util.Arrays;

public class CyclicSort {
    /*
     * problem: Cyclic Sort
     * We are given an array containing ‘n’ objects. Each object, when created, was
     * assigned a unique number from 1 to ‘n’ based on their creation sequence. This
     * means that the object with sequence number ‘3’ was created just before the
     * object with sequence number ‘4’.
     */
    public static int[] cyclicSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            swap(nums, nums[i] - 1, i);
        }

        return nums;
    }

    public static int[] alternative(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] - 1 != i) {
                swap(nums, nums[i] - 1, i);
            } else
                i++;
        }
        return nums;
    }

    public static void swap(int[] nums, int toSwap, int i) {
        int temp = nums[i];
        nums[i] = nums[toSwap];
        nums[toSwap] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 3, 1, 5, 4, 2 };
        int[] array1 = new int[] { 2, 6, 4, 3, 1, 5 };
        int[] array2 = new int[] { 1, 5, 6, 4, 3, 2 };

        System.out.println(Arrays.toString(cyclicSort(array)));
        System.out.println(Arrays.toString(alternative(array1)));
        System.out.println(Arrays.toString(alternative(array2)));

    }

}
