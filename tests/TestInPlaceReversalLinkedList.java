package tests;

import helper.ListNode;
import leetcode.InPlaceReversalLinkedList;

public class TestInPlaceReversalLinkedList {
    public static void printLL(ListNode head) {
        ListNode pointer = head;
        while (pointer != null) {
            System.out.print(pointer.value + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    // Reverse a LinkedList
    public static void testReverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println("reverse");
        System.out.print("Initial: ");
        printLL(head);
        ListNode result = InPlaceReversalLinkedList.reverse(head);
        System.out.print("After: ");
        printLL(result);
    }

    // Reverse a sub-list
    public static void testReverseSublist() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("reverseSubList");
        System.out.print("Initial: ");
        printLL(head);
        ListNode result = InPlaceReversalLinkedList.reverseSubList(head, 2, 4);
        System.out.print("After: ");
        printLL(result);
    }

    // Reverse every K-element Sub-list
    public static void reverseEveryKthElementSubList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("reverseEveryKthElementSubList");
        System.out.print("Initial: ");
        printLL(head);
        ListNode result = InPlaceReversalLinkedList.reverseEveryKthElementSubList(head, 3);
        System.out.print("After: ");
        printLL(result);
    }

    // Reverse alternating K-element Sub-list
    public static void testReverseAlternatingKElemethSubList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println("reverseAlternatingKElemethSubList");
        System.out.print("Initial: ");
        printLL(head);
        ListNode result = InPlaceReversalLinkedList.reverseAlternatingKElemethSubList(head, 2);
        System.out.print("After: ");
        printLL(result);
    }

    public static void main(String[] args) {
        // Reverse a LinkedList
        testReverse();
        System.out.println();

        // Reverse a sub-list
        testReverseSublist();
        System.out.println();

        // Reverse every K-element Sub-list
        reverseEveryKthElementSubList();
        System.out.println();

        // Reverse alternating K-element Sub-list
        testReverseAlternatingKElemethSubList();
        System.out.println();
    }
}
