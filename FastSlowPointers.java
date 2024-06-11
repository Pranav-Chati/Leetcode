import java.util.Set;
import java.util.TreeSet;

public class FastSlowPointers {

    /*
     * review: linkedlist cycle
     * Given the head of a Singly LinkedList, write a function to determine if the
     * LinkedList has a cycle in it or not.
     */

    public static boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null & fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }

        return false;
    }

    /*
     * Problem: Start of LinkedList Cycle
     * Given the head of a Singly LinkedList that contains a cycle, write a function
     * to find the starting node of the cycle.
     * 
     */

    public static ListNode startLLCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode insideCycle = null;
        ListNode findCycle = head;
        Set<ListNode> cycleNodes = new TreeSet<>();

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                cycleNodes.add(slow);
                insideCycle = slow.next;
                break;
            }
        }

        // Second: Create hashmap of cycle nodes

        while (insideCycle != slow) {
            cycleNodes.add(insideCycle);
            insideCycle = insideCycle.next;
        }

        // Third: search for cycle start

        while (!cycleNodes.contains(findCycle)) {
            findCycle = findCycle.next;
        }

        return findCycle;
    }

    public static ListNode solnStartCycleLL(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }

        return findStart(head, cycleLength);
    }

    public static int calculateCycleLength(ListNode slow) {
        int count = 1;
        ListNode current = slow.next;

        while (current != slow) {
            count++;
            current = current.next;
        }

        return count;
    }

    public static ListNode findStart(ListNode head, int cycleLength) {
        // move the first pointer up by K
        ListNode fast = head;
        ListNode slow = head;

        while (cycleLength > 0) {
            fast = fast.next;
            cycleLength--;
        }

        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
