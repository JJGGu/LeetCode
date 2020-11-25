package Hot100;

/**
 * @program: LeetCode
 * @description: 环形链表
 * @author: JJGGu
 * @create: 2020-11-09 16:28
 **/
public class LC141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        slow = head;
        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
