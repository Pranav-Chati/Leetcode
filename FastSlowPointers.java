public class FastSlowPointers {

    /*
     * review: LinkedList Cycle
     * Detect the cycle
     */
    public static boolean linkedListCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

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
    public static ListNode startOfLL(ListNode head) {
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

        return findCycleStart(cycleLength, head);
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

    public static ListNode findCycleStart(int cycleLen, ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while (cycleLen > 0) {
            cycleLen--;
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
    public static boolean happyNumber(int num) {
        int fast = num;
        int slow = num;

        do {
            fast = findHN(findHN(fast));
            slow = findHN(slow);
        } while (fast != slow);

        return slow == 1;
    }

    public static int findHN(int num) {
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
        // find the middle of the list
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the second half
        ListNode middleReversed = reverse(slow);
        ListNode secondHalf = middleReversed;
        ListNode firstHalf = head;

        // iterate through them to see if they are same or not
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.value != secondHalf.value)
                isPalindrome = false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // reverse it back
        reverse(middleReversed);

        // return
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
     * problem: Rearrange a LL
     * Given the head of a Singly LinkedList, write a method to modify the
     * LinkedList such that the nodes from the second half of the LinkedList are
     * inserted alternately to the nodes from the first half in reverse order. So if
     * the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method
     * should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
     */
    public static ListNode rearrangeALL(ListNode head) {
        // find the middle
        ListNode middle = middleOfLL(head);

        // then reverse the middle.next value
        ListNode secondHalf = reverse(middle.next);
        middle.next = null;

        // then integrate until the reversed set goes to zero
        ListNode pointer1 = head;
        while (secondHalf != null) {
            ListNode node = new ListNode(secondHalf.value);
            node.next = pointer1.next;
            pointer1.next = node;

            secondHalf = secondHalf.next;
            pointer1 = pointer1.next.next;
        }

        return head;
    }

    public static ListNode reverseLL(ListNode head) {
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
