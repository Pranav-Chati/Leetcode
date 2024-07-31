package leetcode;

import helper.ListNode;

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
        while (number > 0) {
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
        // find the middle
        ListNode middle = middleLL(head);

        // reverse after the middle
        ListNode secondHalf = reverse(middle.next);
        ListNode copySecondHalf = secondHalf;

        // compare
        ListNode firstHalf = head;
        boolean isPalindrome = true;

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.value != secondHalf.value)
                isPalindrome = false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        // reverse after middle again
        reverse(copySecondHalf);

        // return
        return isPalindrome;
    }

    public static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        return previous;
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

        // combine
        ListNode firstHalf = head;
        while (firstHalf != null && secondHalf != null) {
            ListNode node = new ListNode(secondHalf.value);
            node.next = firstHalf.next;
            firstHalf.next = node;

            // move pointers
            firstHalf = firstHalf.next.next;
            secondHalf = secondHalf.next;
        }

        return head;
    }
}
