import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TwoPointers {
    /*
     * review: Intro/Pair with Target Sum
     */
    public static int[] pairWithTargetSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target)
                return new int[] { left, right };

            if (sum > target)
                right--;
            else
                left++;
        }

        return new int[] { -1, -1 };
    }

    /*
     * review: Remove Duplicates
     * Given an array of sorted numbers, remove all duplicates from it. You should
     * not use any extra space; after removing the duplicates in-place return the
     * new length of the array.
     */
    public static int removeDuplicates(int[] nums) {
        int nextNonDuplicate = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[nextNonDuplicate - 1] != nums[i]) {
                nums[nextNonDuplicate] = nums[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    public static int removeKey(int[] nums, int key) {
        int nonKey = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != key) {
                nums[nonKey] = nums[i];
                nonKey++;
            }
        }
        return nonKey;
    }

    /*
     * review: Squaring a sorted array
     */
    public static int[] squaringSortedArray(int[] nums) {
        int[] squares = new int[nums.length];
        int index = nums.length - 1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int leftSqr = nums[left] * nums[left];
            int rigthSqr = nums[right] * nums[right];

            if (leftSqr > rigthSqr) {
                squares[index--] = leftSqr;
                left++;
            } else {
                squares[index--] = rigthSqr;
                right--;
            }
        }

        return squares;
    }

    /*
     * review: Triplet Sum to Zero
     */
    public static List<List<Integer>> tripletSumToZero(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];

                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return triplets;
    }

    /*
     * review: Triplet Sum Close to Target
     */
    public static int tripletsSumCloseToTarget(int[] nums, int target) {
        int smallestDiff = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int diff = target - nums[i] - nums[left] - nums[right];

                if (diff == 0)
                    return target;

                if (Math.abs(diff) < Math.abs(smallestDiff))
                    smallestDiff = diff;

                if (diff > 0)
                    left++;
                else
                    right--;
            }
        }

        return target - smallestDiff;
    }

    /*
     * review: Triplets with Smaller Sum
     */
    public static int tripletsWithSmallerSum(int[] nums, int target) {
        int close = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < target) {
                    close += right - left;
                    left++;
                } else
                    right--;
            }
        }

        return close;
    }

    /*
     * review: Dutch National Flag Problem
     * Given an array containing 0s, 1s and 2s, sort the array in-place. You should
     * treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s
     * to recreate the array.
     */
    public static int[] dutchNationalFlagProblem(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;

        while (left <= i && i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 1)
                i++;
            else {
                swap(nums, right, i);
                right--;
            }
        }

        return nums;
    }

    public static void swap(int[] nums, int toSwap, int i) {
        int temp = nums[i];
        nums[i] = nums[toSwap];
        nums[toSwap] = temp;
    }

    /*
     * problem: Comparing Strings containing Backspaces
     * Given two strings containing backspaces (identified by the character ‘#’),
     * check if the two strings are equal.
     */
    public static boolean comparingStringContainingBackspaces(String word1, String word2) {
        Stack<Character> word1Stack = new Stack<>();
        Stack<Character> word2Stack = new Stack<>();

        createWordStack(word1Stack, word1);
        createWordStack(word2Stack, word2);
        if (word1Stack.size() != word2Stack.size())
            return false;

        while (word1Stack.size() > 0 && word2Stack.size() > 0) {
            char char1 = word1Stack.pop();
            char char2 = word2Stack.pop();
            if (char1 != char2)
                return false;
        }

        return true;
    }

    public static void createWordStack(Stack<Character> stack, String word) {
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (current == '#')
                stack.pop();
            else
                stack.push(current);
        }
    }


    

    public static void main(String[] args) {
        String str1 = "xy#z";
        String str2 = "xyz#";
        System.out.println(comparingStringContainingBackspaces(str1, str2));
    }
}
