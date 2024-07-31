package leetcode;

import helper.ListNode;

public class InPlaceReversalLinkedList {
    /*
     * problem: Reverse a LinkedList
     * Given the head of a Singly LinkedList, reverse the LinkedList. Write a
     * function to return the new head of the reversed LinkedList.
     */
    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    /*
     * problem: Reverse a Sub-list
     * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the
     * LinkedList from position ‘p’ to ‘q’.
     */
    public static ListNode reverseSubList(ListNode head, int p, int q) {
        ListNode beforeSection = head;
        ListNode pNode = head;
        ListNode qNode = head;

        for (int i = 1; i < q; i++) {
            if (i < p - 1)
                beforeSection = beforeSection.next;
            qNode = qNode.next;
        }
        pNode = beforeSection.next;

        // need to reverse now!
        ListNode previous = qNode.next;
        ListNode current = pNode;
        ListNode next = null;
        for (int i = 1; i < q - p; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        beforeSection.next = previous;

        return head;
    }

    /*
     * problem: Reverse every K-element Sub-list
     * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized
     * sub-list starting from the head.
     * 
     * If, in the end, you are left with a sub-list with less than ‘k’ elements,
     * reverse it too.
     */
    public static ListNode reverseEveryKthElementSubList(ListNode head, int k) {
    }

    /*
     * problem: Reverse alternating K-element Sub-list
     * Given the head of a LinkedList and a number ‘k’, reverse every alternating
     * ‘k’ sized sub-list starting from the head.
     * 
     * If, in the end, you are left with a sub-list with less than ‘k’ elements,
     * reverse it too.
     */
    public static ListNode reverseAlternatingKElemethSubList(ListNode head, int k) {
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = reverseSubList(head, 2, 4);

        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }

    }
}