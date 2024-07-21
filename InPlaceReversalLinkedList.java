public class InPlaceReversalLinkedList {
    /*
     * problem: Reverse a LinkedList
     * Given the head of a Singly LinkedList, reverse the LinkedList. Write a
     * function to return the new head of the reversed LinkedList.
     */
    public static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
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
        ListNode pNode = null;
        ListNode qNode = null;

        // Find the nodes set above
        int i = 1;
        for (i = 1; i < p + 1; i++)
            beforeSection = beforeSection.next;

        pNode = beforeSection.next;
        qNode = pNode;
        for (; i < q; i++)
            qNode = qNode.next;

        // Find the reversal
        ListNode previous = qNode.next;
        for (i = 0; i < q - p + 1; i++) {
            ListNode next = pNode.next;
            pNode.next = previous;
            previous = pNode;
            pNode = next;
        }

        // Set before Section
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
        ListNode beforeSection = null;
        ListNode first = head;
        ListNode last = calculateLastNode(first, k);

        while (last != null && last.next != null) {
            ListNode newSection = reverseFirstToLast(first, last);
            if (beforeSection == null)
                head = last;
            else
                beforeSection.next = last;
            beforeSection = first;
            first = newSection;
            last = calculateLastNode(first, k);
        }

        ListNode section = reverse(first);
        beforeSection.next = section;

        return head;
    }

    public static ListNode calculateLastNode(ListNode first, int k) {
        while (k > 1 && first != null) {
            first = first.next;
            k--;
        }
        return first;
    }

    public static ListNode reverseFirstToLast(ListNode first, ListNode last) {
        ListNode previous = last.next;
        ListNode stop = new ListNode(last.next.value);
        while (first.value != stop.value) {
            ListNode next = first.next;
            first.next = previous;
            previous = first;
            first = next;
        }

        return first;
    }

    /*
     * Reverse alternating K-element Sub-list
     * Given the head of a LinkedList and a number ‘k’, reverse every alternating
     * ‘k’ sized sub-list starting from the head.
     * 
     * If, in the end, you are left with a sub-list with less than ‘k’ elements,
     * reverse it too.
     */
    public static ListNode reverseAlternatingKElemethSubList(ListNode head, int k) {
        ListNode beforeSection = null;
        ListNode first = head;
        ListNode last = calculateLastNode(first, k);
        boolean toReverse = false;

        while (last != null && last.next != null) {
            toReverse = false;
            ListNode newSection = reverseFirstToLast(first, last);
            if (beforeSection == null)
                head = last;
            else
                beforeSection.next = last;

            // the next section below
            first = newSection;
            last = calculateLastNode(first, k);

            beforeSection = last;
            if (last != null && last.next != null) {
                toReverse = true;
                first = last.next;
                last = calculateLastNode(first, k);
            }
        }

        if (toReverse) {
            ListNode section = reverse(first);
            beforeSection.next = section;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(9);

        ListNode result = reverseAlternatingKElemethSubList(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();

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

        // Kth element :
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next = new ListNode(6);
        // head.next.next.next.next.next.next = new ListNode(7);
        // // head.next.next.next.next.next.next.next = new ListNode(8);
        // // head.next.next.next.next.next.next.next.next = new ListNode(9);

        // ListNode result = reverseEveryKthElementSubList(head, 3);
        // System.out.print("Nodes of the reversed LinkedList are: ");
        // while (result != null) {
        // System.out.print(result.value + " ");
        // result = result.next;
        // }
        // System.out.println();
    }
}