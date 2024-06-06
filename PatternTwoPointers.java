import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PatternTwoPointers {

    /*
     * Given an array of sorted numbers and a target sum, find a pair in the array
     * whose sum is equal to the given target.
     */
    public static int[] pairWithTargetSum(int[] arr, int targetSum) {
        int startPointer = 0;
        int endPointer = arr.length - 1;
        int sum = 0;
        int[] result = new int[2];

        while (startPointer != endPointer) {
            sum = arr[startPointer] + arr[endPointer];
            if (sum > targetSum) {
                endPointer--;
            } else if (sum < targetSum) {
                startPointer++;
            } else {
                result[0] = startPointer;
                result[1] = endPointer;
                return result;
            }
        }
        return null;
    }

    /*
     * SOLUTION -> Same result, different style of coding...
     * Given an array of sorted numbers and a target sum, find a pair in the array
     * whose sum is equal to the given target.
     */
    public static int[] solutionPairWithTargetSum(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (targetSum == currentSum)
                return new int[] { left, right };

            if (targetSum > currentSum)
                right++;
            else
                left++;
        }

        return new int[] { -1, -1 };
    }

    /*
     * Alternative Solution using HashMap
     * Given an array of sorted numbers and a target sum, find a pair in the array
     * whose sum is equal to the given target.
     */
    public static int[] alternativePairWithTargetSum(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i])) {
                return new int[] { nums.get(targetSum - arr[i]), i };
            } else {
                nums.put(arr[i], i);
            }
        }
        return new int[] { -1, -1 };
    }

    /*
     * Given an array of sorted numbers, remove all duplicates from it. You should
     * not use any extra space; after removing the duplicates in-place return the
     * new length of the array.
     * 
     * While this gives the right answer, the method is incorrect because you need
     * to move the duplicated values over
     */
    public static int removeDuplicatesBruteForce(int[] sortedArr) {
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < sortedArr.length; i++) {
            if (!numbers.contains(sortedArr[i])) {
                numbers.add(sortedArr[i]);
            }
        }

        return numbers.size() != 0 ? numbers.size() : sortedArr.length;
    }

    /*
     * Solution...
     * Given an array of sorted numbers, remove all duplicates from it. You should
     * not use any extra space; after removing the duplicates in-place return the
     * new length of the array.
     */
    public static int removeDuplicates(int[] arr) {
        int nextNonDuplicatePointer = 1; // index of the next non-duplicate element

        for (int i = 0; i < arr.length; i++) {
            if (arr[nextNonDuplicatePointer - 1] != arr[i]) {
                arr[nextNonDuplicatePointer] = arr[i];
                nextNonDuplicatePointer++;
            }
        }

        return nextNonDuplicatePointer;
    }

    /*
     * Given an unsorted array of numbers and a target ‘key’, remove all instances
     * of ‘key’ in-place and return the new length of the array.
     */
    public static int removeKeyFromArray(int[] arr, int key) {
        int index = 0; // index of the next element which is not a key

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[index] = arr[i];
                index++;
            }
        }

        return index;
    }

    /*
     * Given a sorted array, create a new array containing squares of all the number
     * of the input array in the sorted order.
     * 
     * One way of doing so is, squaring all the numbers in the array and then passing it through a sorted array (for loop)
     */
    
     
    
    public static void main(String[] args) {
        // pairWithTargetSum
        // System.out.println(Arrays.toString(pairWithTargetSum(new int[] { 1, 2, 3, 4,
        // 6 }, 6)));

        // removeDuplicates
        System.out.println(removeDuplicatesBruteForce(new int[] { 1, 2, 2, 2, 2, 3, 4 }));
        System.out.println(removeDuplicates(new int[] { 1, 2, 2, 2, 2, 3, 4 }));

    }

}
