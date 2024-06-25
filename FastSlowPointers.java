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
    public static ListNode startOfLL(ListNode head) {
        // find the cycle length
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                cycleLength = calculateLength(slow);
                break;
            }
        }

        return findCycleStartNode(head, cycleLength);
    }

    public static int calculateLength(ListNode head) {
        int len = 1;
        ListNode current = head.next;

        while (current != head) {
            len++;
            current = current.next;
        }
        return len;
    }

    public static ListNode findCycleStartNode(ListNode head, int length) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while (length > 0) {
            pointer2 = pointer2.next;
            length--;
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
        int fast = num;
        int slow = num;

        do {
            fast = findHappyNumber(findHappyNumber(fast));
            slow = findHappyNumber(slow);
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
     */
    public static boolean palindromeLL(ListNode head) {
        boolean isPalindrome = true;
        // get to the middle
        ListNode middle = middleOfLL(head);

        // reverse the middle
        ListNode secondHalf = reverse(middle);
        ListNode copySecondHalf = secondHalf;
        ListNode pointer1 = head;

        // then compare the values
        while (copySecondHalf != null && pointer1 != null) {
            if (pointer1.value != copySecondHalf.value) {
                isPalindrome = false;
                break;
            }
            pointer1 = pointer1.next;
            copySecondHalf = copySecondHalf.next;
        }

        // then reverse the
        reverse(secondHalf);

        // return
        return isPalindrome;
    }

    /*
     * review: Rearrange a LL
     * Given the head of a Singly LinkedList, write a method to modify the
     * LinkedList such that the nodes from the second half of the LinkedList are
     * inserted alternately to the nodes from the first half in reverse order
     */
    public static void rearrangeLL(ListNode head) {
        // find the middle of the list
        ListNode middle = middleOfLL(head);

        // reverse that part
        ListNode secondHalf = reverse(middle.next);
        middle.next = null;

        // then rearrange
        ListNode pointer1 = head;
        while (secondHalf != null) {
            ListNode node = new ListNode(secondHalf.value);
            node.next = pointer1.next;
            pointer1.next = node;

            pointer1 = pointer1.next.next;
            secondHalf = secondHalf.next;
        }
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
