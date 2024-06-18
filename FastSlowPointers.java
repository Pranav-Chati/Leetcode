public class FastSlowPointers {
    /*
     * review: LinkedList Cycle
     * Given the head of a Singly LinkedList, write a function to determine if the
     * LinkedList has a cycle in it or not.
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
     * Given the head of a Singly LinkedList that contains a cycle, write a function
     * to find the starting node of the cycle.
     */
    public static ListNode startOfLLCycle(ListNode head) {
        // find the ll cycle & cycle Length
        int cycleLength = 0;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }

        // reduce cycle length
        fast = head;
        slow = head;
        while (cycleLength > 0) {
            fast = fast.next;
            cycleLength--;
        }

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
     * they will be stuck in a cycle of numbers which does not include ‘1’
     */
    public static boolean happyNumber(int num) {
        int fast = num;
        int slow = num;

        do {
            slow = calculateHN(slow);
            fast = calculateHN(calculateHN(fast));

        } while (slow != fast);

        return slow == 1;
    }

    public static int calculateHN(int num) {
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    /*
     * review: Middle of the Linked List
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

    /*
     * review: Palindrome LinkedList
     * Given the head of a Singly LinkedList, write a method to check if the
     * LinkedList is a palindrome or not.
     * 
     * Your algorithm should use constant space and the input LinkedList should be
     * in the original form once the algorithm is finished. The algorithm should
     * have O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
     */

    public static boolean palindromeLL(ListNode head) {
        // find the middle of the cycle
        ListNode middleOfLL = middleOfLL(head);

        // reverse second half
        ListNode headOfSecondHalf = reverse(middleOfLL);
        // ! do we need a copy of this value??

        ListNode pointer1 = head;
        ListNode pointer2 = headOfSecondHalf;
        boolean isPalindrome = true;

        // compare reversed with initial values
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.value != pointer2.value) {
                isPalindrome = false;
                break;
            }
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        reverse(headOfSecondHalf);

        return isPalindrome;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return head;
    }

    public static void main(String[] args) {
        // 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
        // 2 -> 4 -> 6 -> 4 -> 2 -> null

        // TODO: Test above function
    }

}
