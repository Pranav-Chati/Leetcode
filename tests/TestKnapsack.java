package tests;

import leetcode.Knapsack;

public class TestKnapsack {
    // knapsack
    public static void testKnapsack() {
        int[] profits = { 1, 6, 10, 16 };
        int[] weights = { 1, 2, 3, 5 };
        int maxProfit = Knapsack.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = Knapsack.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    // Equal Subset Sum Partition
    public static void testEqualSubsetSumPartition() {
        int[] num = { 1, 2, 3, 4 };
        System.out.println(Knapsack.equalSubsetSumPartition(num)); // true
        num = new int[] { 1, 1, 3, 4, 7 };
        System.out.println(Knapsack.equalSubsetSumPartition(num)); // true
        num = new int[] { 2, 3, 4, 6 };
        System.out.println(Knapsack.equalSubsetSumPartition(num)); // false
    }

    // Subset Sum
    public static void testSubsetSum() {
        System.out.println(Knapsack.subsetSum(new int[] { 1, 2, 3, 7 }, 6));
        System.out.println(Knapsack.subsetSum(new int[] { 1, 2, 7, 1, 5 }, 10));
        System.out.println(Knapsack.subsetSum(new int[] { 1, 3, 4, 8 }, 6));
    }

    public static void main(String[] args) {
        // knapsack
        testKnapsack();

        // Equal Subset Sum Partition
        testEqualSubsetSumPartition();

        // Subset Sum
        testSubsetSum();
    }
}
