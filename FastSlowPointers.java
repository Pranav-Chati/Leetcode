public class FastSlowPointers {

    /*
     * review: LinkedList Cycle
     * Given the head of a Singly LinkedList, write a function to determine if the
     * LinkedList has a cycle in it or not.
     */
    public static boolean linkedlistCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

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
     * Given the head of a Singly LinkedList that contains a cycle, write a function
     * to find the starting node of the cycle.
     */
    public static ListNode startOfLLCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                cycleLength = calculateLength(slow);
                break;
            }
        }

        slow = head;
        fast = head;

        // move the fast pointer ahead by cycleLength
        while (cycleLength > 0) {
            fast = fast.next;
            cycleLength--;
        }

        // move each node until they are equal

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static int calculateLength(ListNode slow) {
        int length = 1;
        ListNode current = slow.next;

        while (current != slow) {
            current = current.next;
            length++;
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
        int fast = num;
        int slow = num;

        do {
            slow = findHN(slow);
            fast = findHN(findHN(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static int findHN(int num) {
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

    /*
     * problem: Palindrome LinkedList
     * Given the head of a Singly LinkedList, write a method to check if the
     * LinkedList is a palindrome or not.
     * 
     * Your algorithm should use constant space and the input LinkedList should be
     * in the original form once the algorithm is finished. The algorithm should
     * have O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
     */
    public static boolean palindromeLL(ListNode head) {
        boolean isPalindrome = true;
        // find middle
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse middle
        ListNode headOfReverseList = reverse(slow);
        ListNode secondHalfOfList = headOfReverseList;

        slow = head;

        // compare
        while (slow != null && secondHalfOfList != null) {
            if (slow != secondHalfOfList) {
                isPalindrome = false;
                break;
            }

            slow = slow.next;
            secondHalfOfList = secondHalfOfList.next;
        }

        // reverse back
        reverse(headOfReverseList);

        // final checks and retunrn
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

        return prev;
    }
}
