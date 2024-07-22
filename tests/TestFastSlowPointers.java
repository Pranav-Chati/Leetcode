package tests;

import helper.ListNode;
import leetcode.FastSlowPointers;

public class TestFastSlowPointers {
    // LinkedList Cycle
    public static void testllCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + FastSlowPointers.llCycle(head) + "\tfalse");

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + FastSlowPointers.llCycle(head) + "\ttrue");

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + FastSlowPointers.llCycle(head) + "\ttrue");
    }

    // Start of LinkedList Cycle
    public static void testStartOfLLCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + FastSlowPointers.startOfLLCycle(head).value + "\t 3");

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + FastSlowPointers.startOfLLCycle(head).value + "\t 4");

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + FastSlowPointers.startOfLLCycle(head).value + "\t 1");

    }

    // Happy Number
    public static void testHappyNumber(int input, boolean expected) {
        boolean result = FastSlowPointers.happyNumber(input);
        boolean answer = result == expected;
        if (answer) {
            System.out.println("happyNumber: " + answer);
        } else {
            System.out.println("happyNumber");
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
        }
    }

    // Problem Challenge 1 - Palindrome LinkedList
    public static void testPalindromeLL() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + FastSlowPointers.palindromeLL(head) + "\t true");

        // .next is missing from the below statement
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + FastSlowPointers.palindromeLL(head) + "\t false");
    }

    // Problem Challenge 2 - Rearrange a LinkedList
    public static void testRearrangeLL() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);

        ListNode result = FastSlowPointers.rearrangeLL(head);
        System.out.print("rearrangeLL: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    public static void main(String[] args) {
        // LinkedList Cycle
        testllCycle();
        System.out.println();

        // Start of LinkedList Cycle
        testStartOfLLCycle();
        System.out.println();

        // Happy Number
        testHappyNumber(23, true);
        testHappyNumber(12, false);
        System.out.println();

        // Not Testing - Middle of the LinkedList

        // Problem Challenge 1 - Palindrome LinkedList
        testPalindromeLL();
        System.out.println();

        // Problem Challenge 2 - Rearrange a LinkedList
        testRearrangeLL();
        System.out.println();
    }
}
