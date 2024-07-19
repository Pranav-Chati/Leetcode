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

    /*
     * problem: Reverse every K-element Sub-list
     * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized
     * sub-list starting from the head.
     * 
     * If, in the end, you are left with a sub-list with less than ‘k’ elements,
     * reverse it too.
     */
    public static ListNode reverseEveryKElementSubList(ListNode head, int k) {
        ListNode beforeSection = null;
        ListNode firstK = head;
        ListNode lastK = findLastK(firstK, k);
        ListNode newSection = null;
        while (lastK.next != null) {
            newSection = reverseSubsection(firstK, lastK);
            if (beforeSection == null) {
                beforeSection = head;
                head = lastK;
            } else {
                beforeSection.next = lastK;
                beforeSection = firstK;
            }
            firstK = newSection;
            lastK = findLastK(firstK, k);
        }

        // it will always return early so we can
        newSection = reverse(firstK);
        beforeSection.next = lastK;

        return head;
    }

    public static ListNode findLastK(ListNode head, int k) {
        while (head.next != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }

    public static ListNode reverseSubsection(ListNode first, ListNode last) {
        ListNode prev = last.next;
        ListNode stop = null;
        if (last.next != null)
            stop = new ListNode(last.next.value);
        while (first.value != stop.value) {
            ListNode next = first.next;
            first.next = prev;
            prev = first;
            first = next;
        }

        return first;
    }

    public static void printLL(ListNode result) {
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println('\n');
    }



    public static void main(String[] args) {
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        // ListNode result = reverseSubList(head, 2, 4);

        // System.out.print("Nodes of the reversed LinkedList are: ");
        // while (result != null) {
        // System.out.print(result.value + " ");
        // result = result.next;
        // }

        // Reverse every Kth element in sublist
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next = new ListNode(6);
        // head.next.next.next.next.next.next = new ListNode(7);
        // // head.next.next.next.next.next.next.next = new ListNode(8);

        // ListNode result = reverseEveryKElementSubList(head, 3);
        // System.out.print("Nodes of the reversed LinkedList are: ");
        // while (result != null) {
        // System.out.print(result.value + " ");
        // result = result.next;
        // }

    }

}