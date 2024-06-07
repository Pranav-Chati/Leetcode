
public class FastSlowPointers {

    class LinkedList {
        LinkedList next;
        int value;

        public LinkedList(int val, LinkedList n) {
            this.value = val;
            this.next = n;
        }
    }

    public static void main(String[] args) {

    }

    /*
     * Given the head of a Singly LinkedList, write a function to determine if the
     * LinkedList has a cycle in it or not.
     */
    public static boolean linkedListCycle(LinkedList list) {
        LinkedList slowPtr = list;
        LinkedList fastPtr = list;

        // while (fastPtr.next != null && slowPtr != fastPtr) {
        // fastPtr = fastPtr.next.next;
        // slowPtr = slowPtr.next;
        // }

        // return fastPtr.next != null;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }
}
