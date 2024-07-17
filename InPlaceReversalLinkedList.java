public class InPlaceReversalLinkedList {
    /*
     * problem: Reverse a LinkedList
     * Given the head of a Singly LinkedList, reverse the LinkedList. Write a
     * function to return the new head of the reversed LinkedList.
     */
    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next;
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
        ListNode pPtr = head;
        ListNode qPtr = head;
        ListNode afterSection = null;

        while (q > 1) {
            if (p > 2)
                beforeSection = beforeSection.next;
            if (p > 1)
                pPtr = pPtr.next;
            qPtr = qPtr.next;
            p--;
            q--;
        }
        afterSection = qPtr.next;
        qPtr.next = null;

        // reversed
        ListNode nextSubSection = reverse(pPtr);

        // Add subsection to main
        beforeSection.next = nextSubSection;
        while (nextSubSection.next != null)
            nextSubSection = nextSubSection.next;

        nextSubSection.next = afterSection;

        return head;
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