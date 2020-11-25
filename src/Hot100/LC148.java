package Hot100;

/**
 * @program: LeetCode
 * @description: 排序链表
 * @author: JJGGu
 * @create: 2020-11-10 10:09
 **/
public class LC148 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 在第n个节点处划分开，返回第二段的起始节点
    public ListNode cut(ListNode head, int n) {
        while(head != null && n > 1) {
            head = head.next;
            n--;
        }
        if (head == null) return null;
        ListNode ret = head.next;
        head.next = null;
        return ret;
    }
    // 迭代合并两个有序链表，返回链表头节点，这里使用dummy节点按序连接所有节点
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
    // 方法1.迭代法
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode p = head;
        while(p != null) {
            len++;
            p = p.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 按照1,2,4...的步长去划分然后合并
        for (int i = 1; i < len; i *= 2) {
            ListNode cur = dummy.next;
            ListNode tail = dummy;
            while(cur != null) {
                ListNode left = cur; // 划分后的第一部分的头结点
                ListNode right = cut(left, i); // 划分后的第二部分的头结点
                cur = cut(right, i); // 剩余部分头结点，也是下一次循环的开始节点
                tail.next = merge(left, right);
                while(tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }

}
