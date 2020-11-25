package Hot100;

/**
 * @program: LeetCode
 * @description: dd
 * @author: JJGGu
 * @create: 2020-11-10 14:31
 **/
public class LC1482 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 1; i < length; i *= 2) {
            ListNode pre = dummy;
            cur = dummy.next;
            while (cur != null) {
                ListNode h1 = cur;
                ListNode h2 = split(h1, i);
                cur = split(h2, i);
                pre.next = merge(h1, h2);
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }
    private ListNode split(ListNode head, int i) {
        if (head == null) {
            return null;
        }
        ListNode h = head;
        while (h != null && i > 1) {
            h = h.next;
            i--;
        }
        if (h == null) {
            return null;
        }
        ListNode ret = h.next;
        h.next = null;
        return ret;
    }
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        p.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }
}
