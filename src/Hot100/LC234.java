package Hot100;

/**
 * @program: LeetCode
 * @description: 回文链表
 * @author: JJGGu
 * @create: 2020-11-14 11:18
 **/
public class LC234 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        return fun2(head);
    }
    // 方法1.将链表中的值复制到数组中，使用双指针去判断
    private boolean fun1(ListNode head) {
        return true;
    }
    // 方法2.翻转链表
    private boolean fun2(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        if (count == 1) {
            return true;
        }
        ListNode temp = head;
        for (int i = 0; i < (count >> 1); i++) {
            temp = temp.next;
        }
        if ((count & 1) == 1) {
            temp = temp.next;
        }
        ListNode head2 = reverse(temp);
        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        if (head2 == null) {
            return true;
        }
        return false;
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = head;
            head = cur;
            cur = pre.next;
        }
        return head;
    }
}
