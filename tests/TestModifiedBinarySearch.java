package tests;

import leetcode.ModifiedBinarySearch;

public class TestModifiedBinarySearch {
    // Order-agnostic Binary Search
    public static void testSearch() {
        int[] nums = new int[] { 1, 2, 3, 4, 6, 6, 7 };
        int[] nums2 = new int[] { 10, 6, 4 };
        System.out.println(ModifiedBinarySearch.search(nums, 5));
        System.out.println(ModifiedBinarySearch.search(nums2, 5));
        System.out.println(ModifiedBinarySearch.search(nums2, 10));
    }

    public static void main(String[] args) {
        // Order-agnostic Binary Search
        System.out.println("Order-agnostic Binary Search");
        testSearch();
        System.out.println();
    }
}
