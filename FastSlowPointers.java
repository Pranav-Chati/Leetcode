public class FastSlowPointers {
    /*
     * review: LinkedList Cycle
     */
    public static boolean llCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    /*
     * review: Start of LL Cycle
     */
    public static ListNode startOfLLCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }

        return findStart(cycleLength, head);
    }

    public static int calculateCycleLength(ListNode slow) {
        int length = 1;
        ListNode current = slow.next;
        while (current != slow) {
            length++;
            current = current.next;
        }

        return length;
    }

    public static ListNode findStart(int cycleLength, ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while (cycleLength > 0) {
            cycleLength--;
            pointer1 = pointer1.next;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    /*
     * review: Happy Number
     */
    public static boolean isHappyNumber(int num) {
        int slow = num;
        int fast = num;

        do {
            slow = findHappyNumber(slow);
            fast = findHappyNumber(findHappyNumber(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static int findHappyNumber(int num) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    /*
     * review: Middle of the Linked List
     */
    public static ListNode middleLL(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /*
     * review: Palindrome LinkedList
     */
    public static boolean palindromeLL(ListNode head) {
        boolean isPalindrome = true;
        // find the middle
        ListNode middle = middleLL(head);

        // reverse
        ListNode secondHalf = reverse(middle);
        ListNode copy = secondHalf;

        // check
        while (copy != null && head != null) {
            if (copy.value != head.value) {
                isPalindrome = false;
                break;
            }
            head = head.next;
            copy = copy.next;
        }

        // reverse
        reverse(secondHalf);

        return isPalindrome;
    }

    /*
     * review: Rearrange a LL
     * Given the head of a Singly LinkedList, write a method to modify the
     * LinkedList such that the nodes from the second half of the LinkedList are
     * inserted alternately to the nodes from the first half in reverse order.
     */
    public static ListNode rearrangeLL(ListNode head) {

        // find the middle
        ListNode middle = middleLL(head);

        // reverse the middle
        ListNode secondHalf = reverse(middle);
        middle.next = null;

        // combine
        ListNode pointer1 = head;
        while (secondHalf != null) {
            ListNode node = new ListNode(secondHalf.value);
            node.next = pointer1.next;
            pointer1.next = node;

            pointer1 = pointer1.next.next;
            secondHalf = secondHalf.next;
        }

        return head;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    /*
     * problem: Cycle in a Circular Array
     * We are given an array containing positive and negative numbers. Suppose the
     * array contains a number ‘M’ at a particular index. Now, if ‘M’ is positive we
     * will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’
     * indices. You should assume that the array is circular which means two things:
     * 
     * If, while moving forward, we reach the end of the array, we will jump to the
     * first element to continue the movement.
     * If, while moving backward, we reach the beginning of the array, we will jump
     * to the last element to continue the movement.
     * Write a method to determine if the array has a cycle. The cycle should have
     * more than one element and should follow one direction which means the cycle
     * should not contain both forward and backward movements.
     */
    public static boolean cycleInACircularArray(int[] nums) {
        int fast = 0;
        int slow = 0;

        do {
            fast = findNextValue(nums, findNextValue(nums, fast));
            slow = findNextValue(nums, slow);
        } while (fast != slow); // cycle has been found

        int pointer1 = fast;
        int pointer2 = findNextValue(nums, pointer1);

        do {
            if (Math.signum(nums[pointer1]) != Math.signum(nums[pointer2])) {
                return false;
            }

            pointer1 = findNextValue(nums, pointer1);
            pointer2 = findNextValue(nums, pointer2);
        } while (pointer1 == fast);

        return true;
    }

    public static int findNextValue(int[] nums, int index) {
        index += nums[index];

        if (index >= nums.length) {
            index -= nums.length;
        } else {
            index += nums.length;
        }

        return index;
    }
}
