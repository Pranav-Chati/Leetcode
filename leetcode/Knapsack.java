package leetcode;

public class Knapsack {

    /*
     * problem: 0/1 Knapsack
     * Given the weights and profits of ‘N’ items, we are asked to put these items
     * in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit
     * out of the items in the knapsack. Each item can only be selected once, as we
     * don’t have multiple quantities of any item.
     */
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // return solveKnapsackRecursive(profits, weights, capacity, 0);

        // Integer[][] memo = new Integer[profits.length][capacity + 1];
        // return solveKnapsackMemoization(profits, weights, capacity, 0, memo);

        return solveKnapsackDP(profits, weights, capacity);
    }

    public static int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int index) {
        if (index >= profits.length || capacity <= 0)
            return 0;

        int profit1 = 0;
        while (weights[index] <= capacity)
            profit1 = profits[index] + solveKnapsackRecursive(profits, weights, capacity - weights[index], index + 1);

        int profit2 = solveKnapsackRecursive(profits, weights, capacity, index + 1);

        return Math.max(profit1, profit2);
    }

    // Top Down approach
    public static int solveKnapsackMemoization(int[] profits, int[] weights, int capacity, int index,
            Integer[][] dp) {
        if (index >= profits.length || capacity <= 0)
            return 0;

        if (dp[index][capacity] != null) {
            return dp[index][capacity];
        }

        int profit1 = 0;
        while (weights[index] <= capacity)
            profit1 = profits[index] + solveKnapsackRecursive(profits, weights, capacity - weights[index], index + 1);

        int profit2 = solveKnapsackRecursive(profits, weights, capacity, index + 1);

        dp[index][capacity] = Math.max(profit1, profit2);
        return dp[index][capacity];
    }

    // Bottom Up Approach
    public static int solveKnapsackDP(int[] profits, int[] weights, int capacity) {

        int[][] dp = new int[profits.length][capacity + 1];

        // intilize first column
        for (int i = 0; i < profits.length; i++)
            dp[i][0] = 0;

        // initialize first row
        for (int c = 0; c <= capacity; c++) {
            dp[0][c] = 0;
            if (weights[0] <= c)
                dp[0][c] = profits[0];
        }

        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                int profit2 = 0;
                if (weights[i] <= c)
                    profit1 = Math.max(dp[i - 1][c], profits[i] + dp[i - 1][c - weights[i]]);
                profit2 = dp[i - 1][c];

                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[profits.length - 1][capacity];
    }

    /*
     * problem: Equal Subset Sum Partition
     * Given a set of positive numbers, find if we can partition it into two subsets
     * such that the sum of elements in both subsets is equal.
     */
    public static boolean equalSubsetSumPartition(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;

        if (sum % 2 != 0)
            return false;

        sum /= 2;

        Boolean[][] memo = new Boolean[nums.length][sum + 1];
        // return equalSubsetSumPartitionRecursive(nums, sum, 0);
        return equalSubsetSumPartitionMemoization(nums, sum, 0, memo);

    }

    public static boolean equalSubsetSumPartitionRecursive(int[] nums, int sum, int index) {
        if (sum == 0)
            return true;

        if (index >= nums.length)
            return false;

        while (nums[index] < sum)
            if (equalSubsetSumPartitionRecursive(nums, sum - nums[index], index + 1))
                return true;

        return equalSubsetSumPartitionRecursive(nums, sum, index + 1);
    }

    public static boolean equalSubsetSumPartitionMemoization(int[] nums, int sum, int index, Boolean[][] memo) {
        if (sum == 0)
            return true;

        if (index >= nums.length)
            return false;

        if (memo[index][sum] == null) {
            while (nums[index] < sum) {
                if (equalSubsetSumPartitionMemoization(nums, sum - nums[index], index + 1, memo)) {
                    memo[index][sum] = true;
                    return true;
                }
            }
        }

        memo[index][sum] = equalSubsetSumPartitionMemoization(nums, sum, index + 1, memo);

        return memo[index][sum];
    }

    // need to take some time to understand this
    public static boolean equalSubsetSumPartitionDP(int[] nums, int sum) {
        Boolean[][] dp = new Boolean[nums.length][sum + 1];

        // initialize first column
        for (int i = 0; i < nums.length; i++)
            dp[i][0] = true;

        // initialize first row
        for (int s = 0; s <= sum; s++)
            dp[0][s] = (nums[0] == s ? true : false);

        for (int i = 1; i < nums.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][sum]) {
                    dp[i][sum] = dp[i - 1][sum];
                } else if (s >= nums[i]) {
                    dp[i][sum] = dp[i - 1][sum - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][sum];
    }
}
