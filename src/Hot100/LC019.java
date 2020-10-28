package Hot100;

/**
 * @program: LeetCode
 * @description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author: JJGGu
 * @create: 2020-10-24 14:17
 **/


public class LC019 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = head;
        if (n == 1) {
            head = head.next;
            return head;
        }
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slowPre = slow;
            slow = slow.next;
        }
        // delete
        slowPre.next = slow.next;
        slow.next = null;

        return head;
    }
}
