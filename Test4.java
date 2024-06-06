import java.util.Set;
import java.util.TreeSet;

public class Test4 {
    public static void main(String[] args) {
        int[] array = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(testFunc1(array));
        System.out.println(testFunc3(array));
    }

    public static int testFunc1(int[] nums) {
        Set<Integer> nonDuplicates = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!nonDuplicates.contains(nums[i])) {
                nonDuplicates.add(nums[i]);
            }
        }

        return nonDuplicates.size();
    }

    // [ 2, 2, 2]
    public static int testFunc2(int[] nums) {
        int rightPtr = 0;
        int leftPtr = 1;
        int size = 1;

        while (leftPtr < nums.length) {
            if (nums[rightPtr] == nums[leftPtr])
                leftPtr++;
            else {
                rightPtr = leftPtr;
                leftPtr++;
                size++;
            }
        }
        return size;
    }

    // [2, 3, 3, 3, 6, 9, 9]
    public static int testFunc3(int[] nums) {
        int nonNextDuplicate = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[nonNextDuplicate - 1] != nums[i]) {
                nums[nonNextDuplicate] = nums[i];
                nonNextDuplicate++;
            }
        }

        return nonNextDuplicate;
    }

    public static int[] twoPointers(int[] nums, int K) {

        int rightPtr = 0;
        int leftPtr = nums.length - 1;
        int ptrSum = 0;

        while (rightPtr < leftPtr) {
            ptrSum = nums[rightPtr] + nums[leftPtr];
            if (ptrSum == K)
                return new int[] { rightPtr, leftPtr };
            else if (ptrSum > K)
                leftPtr--;
            else
                rightPtr++;

        }
        return new int[] { -1, -1 };
    }

}
