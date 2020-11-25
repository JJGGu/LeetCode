package Hot100;

/**
 * @program: LeetCode
 * @description: 反转链表
 * @author: JJGGu
 * @create: 2020-11-13 14:23
 **/
public class LC206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        return fun1(head);
    }

    // 方法1 迭代法
    private ListNode fun1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = head;
            head = cur;
            cur = pre.next;
        }
        return head;
    }

    // 方法2 递归法
    private ListNode fun2(ListNode head) {
        return null;
    }
}
