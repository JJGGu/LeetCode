package Hot100;

/**
 * @program: LeetCode
 * @description: 环形链表2
 * @author: JJGGu
 * @create: 2020-11-09 16:50
 **/
public class LC142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while (slow != fast) {
            if (slow == null || fast == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
