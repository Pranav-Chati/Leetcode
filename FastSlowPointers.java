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

            if (slow == head)
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
        // three steps
        // 1. find cycle length
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                len = calculateLength(slow);
                break;
            }
        }

        // 2. place fast pointer ahead by that length
        slow = head;
        fast = head;
        while (len > 0) {
            fast = fast.next;
            len--;
        }

        // 3. find where they meet
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static int calculateLength(ListNode slow) {

        int length = 1;
        ListNode current = slow;
        while (current != slow) {
            current = current.next;
            length++;
        }

        return length;
    }

    /*
     * review: Happy Number
     */
    public static boolean happyNumber(int num) {

        int fast = num;
        int slow = num;
        do {
            fast = findSumOfDigits(findSumOfDigits(fast));
            slow = findSumOfDigits(slow);

        } while (fast != slow);
        return slow == 1;
    }

    public static int findSumOfDigits(int num) {
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
     * LinkedList is a palindrome or not
     */
    public static boolean palindromeLL(ListNode head) {
        boolean isPalindrome = true;
        // First find the middle of the linkedList
        ListNode middle = middleOfLL(head);

        // then reverse the linkedList
        ListNode headOfReversedList = reverse(middle);
        ListNode copySecondHalfHead = headOfReversedList;

        // check whether it is a yes
        while (head != null && copySecondHalfHead != null) {
            if (head.value != copySecondHalfHead.value) {
                isPalindrome = false;
            }
            head = head.next;
            copySecondHalfHead = copySecondHalfHead.next;
        }

        // revert back
        reverse(headOfReversedList);

        return isPalindrome;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            prev = head;
            head = next;
        }

        return prev;
    }
}
