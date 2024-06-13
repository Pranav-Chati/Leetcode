import java.util.TreeSet;
import java.util.Set;

public class FastSlowPointers {
    /*
     * review: LinkedList Cycle
     * Given the head of a Singly LinkedList, write a function to determine if the
     * LinkedList has a cycle in it or not.
     */
    public static boolean llCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    /*
     * review: Start of LinkedList Cycle
     * Given the head of a Singly LinkedList that contains a cycle, write a function
     * to find the starting node of the cycle.
     */
    public static ListNode startLLCycle(ListNode head) {
        // get into the cycle
        ListNode fast = head;
        ListNode slow = head;

        int cycleLength = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                cycleLength = calculateLength(slow);
                break;
            }
        }
        fast = head;
        slow = head;
        // move pointer by that much
        while (cycleLength > 0) {
            fast = fast.next;
            cycleLength--;
        }

        // find where they meet
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
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

    /*
     * review: Happy Number
     * Any number will be called a happy number if, after repeatedly replacing it
     * with a number equal to the sum of the square of all of its digits, leads us
     * to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead,
     * they will be stuck in a cycle of numbers which does not include ‘1’.
     */
    public static boolean happyNumber(int num) {
        Set<Integer> numbers = new TreeSet<>();

        do {
            num = findSquaredValue(num);
            if (num == 1)
                return true;

            if (numbers.contains(num))
                return false;

            numbers.add(num);
        } while (true);
    }

    public static int findSquaredValue(int num) {
        // turn num into array
        // need to convert int into string before char array
        char[] digits = Integer.toString(num).toCharArray();
        int sum = 0;

        for (int i = 0; i < digits.length; i++) {
            // need to convert char into string before turning into int
            int digit = Integer.parseInt(Character.toString(digits[i]));
            sum += digit * digit;
        }

        return sum;
    }

    /*
     * another solution?
     */
    public static boolean altHappyNumber(int num) {
        int slow = num;
        int fast = num;

        do {
            slow = findSquaredValue1(num);
            fast = findSquaredValue1(findSquaredValue1(num));
        } while (slow != fast);

        return slow == 1;
    }

    public static int findSquaredValue1(int num) {
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }

}
