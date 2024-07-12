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
            int j = nums[i] - 1;
            if (nums[j] != nums[i])
                swap(nums, i, j);
            else
                i++;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
     * review: Find the Missing Number
     * We are given an array containing ‘n’ distinct numbers taken from the range 0
     * to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers,
     * find the missing number.
     */
    public static int findTheMissingNumber(int[] nums) {
        // Part 1 : sort the array (kind of)
        // [8, 3, 5, 2, 4, 6, 0, 1]
        int index = 0;
        while (index < nums.length) {
            // check: the value is not equal to the index (so perform swap)
            if (nums[index] < nums.length && nums[index] != index) {
                swap(nums, nums[index], index);
            } else {
                index++;
            }
        }

        // Part 2 : find the missing number
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }

        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(findTheMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
