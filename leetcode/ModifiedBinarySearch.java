package leetcode;

public class ModifiedBinarySearch {
    /*
     * problem: Order-agnostic Binary Search
     * Given a sorted array of numbers, find if a given number ‘key’ is present in
     * the array. Though we know that the array is sorted, we don’t know if it’s
     * sorted in ascending or descending order. You should assume that the array can
     * have duplicates.
     * 
     * Write a function to return the index of the ‘key’ if it is present in the
     * array, otherwise return -1.
     */
    public static int search(int[] nums, int key) {
        int start = 0;
        int end = nums.length - 1;
        boolean orderIsAcending = nums[start] < nums[end];

        while (start <= end) {
            int size = end - start + 1;
            int middle = start + size / 2;

            if (nums[middle] == key)
                return middle;

            if (orderIsAcending) {
                if (nums[middle] < key)
                    start = middle + 1;
                else
                    end = middle - 1;
            } else {
                if (nums[middle] < key)
                    end = middle - 1;
                else
                    start = middle + 1;
            }
        }

        return -1;
    }
}
