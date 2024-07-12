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
        // get into cycle and find the length
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cycleLength = calculateCycleLength(slow);
            }
        }

        return findStartOfLL(head, cycleLength);
        // then push that pointer and itereate through
    }

    public static int calculateCycleLength(ListNode slow) {
        ListNode current = slow.next;
        int length = 1;
        while (current != slow) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static ListNode findStartOfLL(ListNode head, int cycleLength) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;

        while (cycleLength > 0) {
            ptr2 = ptr2.next;
            cycleLength--;
        }

        while (ptr1 != null && ptr2 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr2;
    }

    /*
     * review: Happy Number
     */
    public static boolean happyNumber(int number) {
        int fast = number;
        int slow = number;

        do {
            fast = calculateHappyNumber(calculateHappyNumber(fast));
            slow = calculateHappyNumber(slow);
        } while (fast != slow);

        return slow == 1;
    }

    public static int calculateHappyNumber(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
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
        boolean isPalindrome = true;
        // find the middle
        ListNode middle = middleLL(head);

        // reverse the middle
        ListNode secondHalf = reverse(middle.next);
        ListNode copySecondHalf = secondHalf;

        // determine if palindrome or not
        ListNode firstHalf = head;
        while (copySecondHalf != null && firstHalf != null) {
            if (copySecondHalf.value != firstHalf.value) {
                isPalindrome = false;
                break;
            }
            copySecondHalf = copySecondHalf.next;
            firstHalf = firstHalf.next;
        }

        // reverse the middle again
        reverse(secondHalf);

        // return answer
        return isPalindrome;
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
        // find the middle of the LL
        ListNode middle = middleLL(head);

        // Reverse after the middle
        ListNode secondHalf = reverse(middle.next);
        middle.next = null;

        ListNode firstHalf = head;
        // Rearrange after it
        while (secondHalf != null && firstHalf != null) {
            ListNode temp = new ListNode(secondHalf.value);
            temp.next = firstHalf.next;
            firstHalf.next = temp;

            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next.next;
        }

        // return the head
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

    public static void main(String[] args) {
        // testing for rearrange LL
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        rearrangeLL(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
