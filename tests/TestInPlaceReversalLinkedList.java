package tests;

import helper.ListNode;
import leetcode.InPlaceReversalLinkedList;

public class TestInPlaceReversalLinkedList {
    public static void testReverseAlternatingKElemethSubList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(9);

        ListNode result = InPlaceReversalLinkedList.reverseAlternatingKElemethSubList(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();
    }

}
