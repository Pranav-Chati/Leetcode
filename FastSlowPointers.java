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
        int cycleLength = 0;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }

        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    public static int calculateCycleLength(ListNode slow) {
        int length = 0;
        ListNode current = slow.next;

        while (current != slow) {
            current = current.next;
            length++;
        }

        return length;
    }

    /*
     * review: Happy Number
     */
    public static boolean happyNumber(int number) {
        int fast = number;
        int slow = number;

        do {
            fast = findHappyNumber(findHappyNumber(fast));
            slow = findHappyNumber(slow);
        } while (fast != slow);

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
     * Given the head of a Singly LinkedList, write a method to check if the
     * LinkedList is a palindrome or not.
     */
    public static boolean palindromeLL(ListNode head) {
        // Find the middle of the linkedlist
        ListNode middle = middleLL(head);

        // reverse the middle
        ListNode secondHalf = reverse(middle);
        ListNode copySecondHalf = secondHalf;

        // then check whether the value is a palindrome or not
        ListNode firstHalf = head;
        boolean isPalindrome = true;

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.value != secondHalf.value)
                isPalindrome = false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        reverse(copySecondHalf);

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

    /*
     * review: Problem Challenge 2 - Rearrange a LL
     * Given the head of a Singly LinkedList, write a method to modify the
     * LinkedList such that the nodes from the second half of the LinkedList are
     * inserted alternately to the nodes from the first half in reverse order. So if
     * the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method
     * should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
     */
    public static ListNode rearrangeLL(ListNode head) {
        // find the middle
        ListNode middle = middleLL(head);

        // reverse it
        ListNode secondHalf = reverse(middle.next);
        middle.next = null;

        // set new
        ListNode firstHalf = head;
        while (firstHalf != null && secondHalf != null) {
            ListNode temp = new ListNode(secondHalf.value);
            temp.next = firstHalf.next;
            firstHalf.next = temp;

            firstHalf = firstHalf.next.next;
            secondHalf = secondHalf.next;
        }

        return head;
    }
}
