import java.util.TreeSet;
import java.util.Set;

public class FsatSlowPointers {
    class ListNode {
        ListNode next;
        int value;
    }

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

            if (fast == slow)
                return true;
        }

        return false;
    }

    /*
     * problem: Start of LinkedList Cycle
     */
    // find the cycle
    // hashmap values inside cycle

    // then start from head and check the ndoe until you reach the cycle

    public static ListNode startOfLLCyce(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        Set<ListNode> cycleNodes = new TreeSet<>();

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        // slow is discovered
        ListNode current = slow;
        while (!cycleNodes.contains(current)) {
            cycleNodes.add(current);
            current = current.next;
        }

        // get the set
        ListNode cycleStart = head;
        while (!cycleNodes.contains(cycleStart)) {
            cycleStart = cycleStart.next;
        }

        return cycleStart;
    }
}
