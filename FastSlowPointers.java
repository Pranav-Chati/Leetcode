public class FastSlowPointers {
    /*
     * review: LinkedList Cycle
     */
    public static boolean llCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == head)
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
        // three steps
        // 1. find cycle length
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                len = calculateLength(slow);
                break;
            }
        }

        // 2. place fast pointer ahead by that length
        slow = head;
        fast = head;
        while (len > 0) {
            fast = fast.next;
            len--;
        }

        // 3. find where they meet
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static int calculateLength(ListNode slow) {

        int length = 1;
        ListNode current = slow;
        while (current != slow) {
            current = current.next;
            length++;
        }

        return length;
    }

    /*
     * review: Happy Number
     */
    public static boolean happyNumber(int num) {

        int fast = num;
        int slow = num;
        do {
            fast = findSumOfDigits(findSumOfDigits(fast));
            slow = findSumOfDigits(slow);

        } while (fast != slow);
        return slow == 1;
    }

    public static int findSumOfDigits(int num) {
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
     * LinkedList is a palindrome or not
     */
    public static boolean palindromeLL(ListNode head) {
        boolean isPalindrome = true;
        // First find the middle of the linkedList
        ListNode middle = middleOfLL(head);

        // then reverse the linkedList
        ListNode headOfReversedList = reverse(middle);
        ListNode copySecondHalfHead = headOfReversedList;

        // check whether it is a yes
        while (head != null && copySecondHalfHead != null) {
            if (head.value != copySecondHalfHead.value) {
                isPalindrome = false;
            }
            head = head.next;
            copySecondHalfHead = copySecondHalfHead.next;
        }

        // revert back
        reverse(headOfReversedList);

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
     * review: Rearrange a LinkedList
     * Given the head of a Singly LinkedList, write a method to modify the
     * LinkedList such that the nodes from the second half of the LinkedList are
     * inserted alternately to the nodes from the first half in reverse order. So if
     * the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method
     * should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
     */
    public static ListNode rearrangeOfLL(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // find the middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the middle
        ListNode reversedSecondList = reverseLL(slow.next);
        slow.next = null;

        // transform
        ListNode pointer1 = head;
        ListNode copyOfHead = head;

        while (reversedSecondList != null) {
            // insert
            ListNode node = new ListNode(reversedSecondList.value);
            node.next = pointer1.next;
            pointer1.next = node;

            // increment
            reversedSecondList = reversedSecondList.next;
            pointer1 = pointer1.next.next;
        }

        return copyOfHead;
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

    // 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
    public static void main(String[] args) {
        ListNode head = list2();

        // Print the linked list (just for demonstration)
        printLinkedList(head);

        head = rearrangeOfLL(head);

        printLinkedList(head);
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }

    public static ListNode list1() {
        // Creating nodes
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(10);
        ListNode node6 = new ListNode(12);

        // Connecting nodes to form the linked list
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        // Head of the linked list
        return node1;
    }

    public static ListNode list2() {
        // Creating nodes
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(10);

        // Connecting nodes to form the linked list
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }
}
