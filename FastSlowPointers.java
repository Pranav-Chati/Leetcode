public class FastSlowPointers {

    /*
     * review: LinkedList Cycle
     */
    public static boolean linkedListCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }

        return false;
    }

    /*
     * review: Start of LL Cycle
     */

    public static ListNode startOfLLCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int cycleLength = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }

        // set fast pointer ahead by cycleLength
        fast = head;
        slow = head;
        while (cycleLength > 0) {
            fast = fast.next;
            cycleLength--;
        }

        // find where they meet
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
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

    /*
     * review: Happy Number
     * Any number will be called a happy number if, after repeatedly replacing it
     * with a number equal to the sum of the square of all of its digits, leads us
     * to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead,
     * they will be stuck in a cycle of numbers which does not include ‘1’.
     */

    public static boolean happyNumber(int num) {
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
        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }

    /*
     * problem: Middle of the LinkedList
     * Given the head of a Singly LinkedList, write a method to return the middle
     * node of the LinkedList.
     * 
     * If the total number of nodes in the LinkedList is even, return the second
     * middle node.
     */
    public static ListNode middleOfLL(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
