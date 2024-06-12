public class FastSlowPointers {

    /*
     * review: LinkedList Cycle
     * Given the head of a Singly LinkedList, write a function to determine if the
     * LinkedList has a cycle in it or not.
     */
    public static boolean linkedListCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /*
     * 
     */
    public static ListNode startOfCycleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;

        // 1: get into the cycle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                // 2: find the cycle length
                cycleLength = calculateLength(slow);
                break;
            }
        }

        fast = head;
        slow = head;

        // 3: move the fast pointer ahead by cycle length
        while (cycleLength > 0) {
            fast = fast.next;
            cycleLength--;
        }

        // 4: let it all play out until they meet
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public static int calculateLength(ListNode slow) {
        int length = 1;
        ListNode current = slow.next;

        while (current != slow) {
            length++;
            current = current.next;
        }

        return length;
    }
}
