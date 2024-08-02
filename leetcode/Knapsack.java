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

        // Integer[][] dp = new Integer[profits.length][capacity + 1];
        // return solveKnapsackMemoization(profits, weights, capacity, 0, dp);

        return solveKnapsackDP(profits, weights, capacity);
    }

    public static int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int index) {
        if (index >= profits.length || weights[index] > capacity)
            return 0;

        int profit1 = 0;
        if (weights[index] <= capacity)
            profit1 = profits[index] + solveKnapsackRecursive(profits, weights, capacity - weights[index], index + 1);

        int profit2 = solveKnapsackRecursive(profits, weights, capacity, index + 1);

        return Math.max(profit1, profit2);
    }

    // Top Down approach
    public static int solveKnapsackMemoization(int[] profits, int[] weights, int capacity, int index,
            Integer[][] dp) {

        if (index >= profits.length || weights[index] > capacity)
            return 0;

        if (dp[index][capacity] != null)
            return dp[index][capacity];

        int profit1 = 0;
        if (weights[index] <= capacity)
            profit1 = profits[index]
                    + solveKnapsackMemoization(profits, weights, capacity - weights[index], index + 1, dp);

        int profit2 = solveKnapsackMemoization(profits, weights, capacity, index + 1, dp);

        dp[index][capacity] = Math.max(profit1, profit2);
        return dp[index][capacity];
    }

    // Bottom Up Approach
    public static int solveKnapsackDP(int[] profits, int[] weights, int capacity) {
        int len = profits.length;
        Integer[][] dp = new Integer[len][capacity + 1];

        // need to make first COLUMN all 0s
        for (int i = 0; i < len; i++)
            dp[i][0] = 0;

        for (int c = 0; c <= capacity; c++)
            if (weights[0] <= c)
                dp[0][c] = profits[0];

        for (int i = 1; i < len; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                int profit2 = 0;

                if (weights[i] <= c)
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                profit2 = dp[i - 1][c];

                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[len - 1][capacity];
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

        // return equalSubsetSumPartitionRecursive(nums, sum / 2, 0);
        // Boolean
        // Boolean[][] memo = new Boolean[nums.length][su / 2 + 1];
        // return equalSubsetSumPartitionMemoization(nums, sum / 2, 0, memo);

        return equalSubsetSumPartitionDP(nums, sum);
    }

    public static boolean equalSubsetSumPartitionRecursive(int[] nums, int sum, int index) {
        if (sum == 0)
            return true;

        if (index >= nums.length || nums[index] > sum)
            return false;

        return equalSubsetSumPartitionRecursive(nums, sum - nums[index], index + 1)
                || equalSubsetSumPartitionRecursive(nums, sum, index + 1);
    }

    public static boolean equalSubsetSumPartitionMemoization(int[] nums, int sum, int index, Boolean[][] memo) {
        if (sum == 0)
            return true;

        if (index >= nums.length || nums[index] > sum)
            return false;

        if (memo[index][sum] != null)
            return memo[index][sum];

        memo[index][sum] = equalSubsetSumPartitionRecursive(nums, sum - nums[index], index + 1)
                || equalSubsetSumPartitionRecursive(nums, sum, index + 1);
        return memo[index][sum];
    }

    // need to take some time to understand this
    public static boolean equalSubsetSumPartitionDP(int[] nums, int sum) {
        Boolean[][] dp = new Boolean[nums.length][sum + 1];

        // initialize first column as all true
        for (int i = 0; i < nums.length; i++)
            dp[i][0] = true;

        for (int s = 1; s <= sum; s++) // why is this 1?
            dp[0][s] = (nums[0] == s ? true : false); // why do we do equals here??

        for (int i = 1; i < nums.length; i++)
            for (int s = 1; s <= sum; s++) { // understand this a bit better
                if (dp[i - 1][s])
                    dp[i][s] = dp[i - 1][s];
                else if (nums[i] <= s)
                    dp[i][s] = dp[i - 1][s - nums[i]];
            }

        return dp[nums.length - 1][sum];
    }

    /*
     * problem: Subset Sum
     * Given a set of positive numbers, determine if a subset exists whose sum is
     * equal to a given number ‘S’.
     */
    public static boolean subsetSum(int[] nums, int sum) {
        // return subsetSumRecursive(nums, sum, 0);

        // Boolean[][] memo = new Boolean[nums.length][sum + 1];
        // return subsetSumMemo(nums, sum, 0, memo);

        return subsetSumDP(nums, sum);
    }

    public static boolean subsetSumRecursive(int[] nums, int sum, int index) {
        if (sum == 0)
            return true;
        if (index >= nums.length || nums[index] > sum)
            return false;

        return subsetSumRecursive(nums, sum - nums[index], index + 1) || subsetSumRecursive(nums, sum, index + 1);
    }

    public static boolean subsetSumMemo(int[] nums, int sum, int index, Boolean[][] memo) {
        if (sum == 0)
            return true;
        if (index >= nums.length || nums[index] > sum)
            return false;

        if (memo[index][sum] != null)
            return memo[index][sum];

        memo[index][sum] = subsetSumRecursive(nums, sum - nums[index], index + 1)
                || subsetSumRecursive(nums, sum, index + 1);

        return memo[index][sum];
    }

    public static boolean subsetSumDP(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length][sum + 1]; // Boolean vs boolean makes it work

        // initialize first column
        for (int i = 0; i < nums.length; i++)
            dp[i][0] = true;

        // intiailize first row
        for (int s = 1; s <= sum; s++)
            dp[0][s] = (nums[0] == s ? true : false);

        // parsed
        for (int i = 1; i < nums.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s])
                    dp[i][s] = dp[i - 1][s];
                else if (nums[i] <= s) {
                    dp[i][s] = dp[i - 1][s - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][sum];
    }
}
